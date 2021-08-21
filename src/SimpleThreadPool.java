import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 类描述:
 *
 * @ClassName SimpleThreadPool
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/9 13:09
 */
public class SimpleThreadPool extends Thread {

    // 线程数量
    private int currentSize;
    // 默认的线程数量
    private static final int DEFAULT_SIZE = 4;
    // 任务队列
    private static final LinkedList<Runnable> TASKQUEUE = new LinkedList<>();
    // 线程池中的线程数组
    private static final List<WorkerThread> THREADQUEUE = new ArrayList<>();

    // 预定的队列值
    private int queueSize;
    // 默认的最大队列值，即最大任务数
    private static final int DEFAULT_QUEUE_SIZE = 30;

    // 拒绝策略
    private DiscardPolicy discardPolicy;
    // 默认的拒绝策略
    private static final DiscardPolicy DEFAULT_POLICY = ()->{
        throw new RuntimeException("任务超出预期");
    };
    // 是否已经关闭
    private boolean isDestory = false;

    private int min;
    private int active;
    private int max;


    public SimpleThreadPool() {
        this(4,8,12,DEFAULT_POLICY,DEFAULT_QUEUE_SIZE);
    }

    public SimpleThreadPool(int min,int active,int max,DiscardPolicy discardPolicy,int queueSize) {
        this.min = min;
        this.active = active;
        this.max = max;
        this.currentSize = min;
        this.discardPolicy = discardPolicy;
        this.queueSize = queueSize;
    }

    public void init(){
        for (int i = 0; i < currentSize; i++) {
            createTask();
        }
    }



    public void createTask(){

        WorkerThread workerThread = new WorkerThread();
        workerThread.start();
        THREADQUEUE.add(workerThread);

    }

    public enum WorkerThreadStatus{
        FREE, // 空闲
        BLOCK, // 阻塞
        RUNNING, // 运行
        DEAD  // 死亡
    }

    // 提交任务
    public void submit(Runnable task){
        if (isDestory){
            throw new RuntimeException("线程池已经关闭，不能再提交了");
        }
        synchronized (TASKQUEUE) {
            // 当前队列中的任务数超出预定的任务数就拒绝
            if (TASKQUEUE.size() > queueSize){
                System.out.println("当前队列中的任务数："+TASKQUEUE.size());
                this.discardPolicy.discard();
            }
            TASKQUEUE.addLast(task);
            TASKQUEUE.notify();  //通知线程队列队列中有任务了
        }
    }

    //拒绝策略
    public interface DiscardPolicy{
        void discard();
    }

    // 关闭线程池
    public void shutdown() throws InterruptedException {
        while (!TASKQUEUE.isEmpty()){
            Thread.sleep(500);
        }

        synchronized (THREADQUEUE){
            int threadSize = THREADQUEUE.size();
            while (threadSize > 0){
                for (WorkerThread workerThread :THREADQUEUE){
                    // 当线程状态为RUNNING的时候不能关闭
                    if (workerThread.state == WorkerThreadStatus.BLOCK){ // 线程在等待，夯住了
                        // 中断
                        workerThread.interrupt();
                        // 关闭
                        workerThread.close();
                        // 关闭后数量减一
                        threadSize--;
//                    }else if (workerThread.state == WorkerThreadStatus.FREE){  // 线程执行完毕
//                        // FREE状态时不需要中断
//                        // 关闭
//                        workerThread.close();
//                        threadSize--;
                    }else {  //线程还在RUNNING,等等吧
                        Thread.sleep(500);
                    }

                }
            }
        }
        // 线程池已经关闭
        isDestory = true;
        System.out.println(">>>>>>线程池已经关闭");
    }


    // 监控线程池，动态扩容和缩容
    @Override
    public void run(){
        /**
         常识：
         更少的线程可以处理很多的任务，所以设置三个参数：min active max
         1、min < 任务数 < active，或者 任务数 < min ，线程数只要min就可以了 ------默认
         2、active < 任务数 < max ,线程数要扩展到active
         3、max < 任务数，线程数要扩到max
         */
        while (!isDestory){
            System.out.println("##当前最小线程数："+min+"，活动线程数："+active+"，最大线程数:"+max+
                    "，当前线程数："+currentSize+"，当前任务量："+TASKQUEUE.size());
            // 扩容
            if (TASKQUEUE.size() > active && currentSize < active){
                for (int i = currentSize; i < active; i++) {
                    createTask();
                }
                currentSize = active;
                System.out.println("线程池已经扩容到active："+active);
            }else if (TASKQUEUE.size() > max && currentSize < max){
                for (int i = currentSize; i < max; i++) {
                    createTask();
                }
                currentSize = max;
                System.out.println("线程池已经扩容到max："+max);
            }

            // 缩容
            if (TASKQUEUE.isEmpty() && currentSize > active){
                System.out.println("=============线程池开始缩容=========");
                int releaseSize = currentSize - active;
                Iterator<WorkerThread> iterator = THREADQUEUE.iterator();
                while (iterator.hasNext()){
                    if (releaseSize <= 0)
                        break;
                    WorkerThread workerThread = iterator.next();
                    if (workerThread.state == WorkerThreadStatus.BLOCK){
                        workerThread.interrupt();
                        workerThread.close();
                        iterator.remove();
                        releaseSize--;
                        System.out.println("workerThread.state = " + workerThread.state);
                    }
                }
                currentSize = active;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
    线程池原理：
        1、定义一个队列，用来存放提交的任务（任务也是线程）
        2、内部线程类操作任务队列
        3、外部线程池提交任务

    线程池拒绝策略：
        任务队列中不可能无限制的增加任务，当任务达到一个阈值的时候，线程池得拒绝请求

    关闭线程池：
        线程池在非RUNNING状态的时候，即BLOCK状态的时候才能被关闭

    线程池扩容与缩容：
        扩容：
        缩容：
        常识：
            更少的线程可以处理很多的任务，所以设置三个参数：min active max
            1、min < 任务数 < active，或者 任务数 < min ，线程数只要min就可以了 ------默认
            2、active < 任务数 < max ,线程数要扩展到active
            3、max < 任务数，线程数要扩到max
     */
    class WorkerThread extends Thread{
        private volatile WorkerThreadStatus state = WorkerThreadStatus.FREE;
        @Override
        public void run(){
            OUTER:
            // 线程状态不是死亡的时候，就一直循环
            while (state != WorkerThreadStatus.DEAD) {
                Runnable task;
                synchronized (TASKQUEUE) {
                    while (TASKQUEUE.isEmpty()) {
                        try {
                            // 这条代码应该放到wait()方法前，如果在后面，则不会执行
                            this.state = WorkerThreadStatus.BLOCK;
                            // 队列中没有任务，要一直等，等到有任务了才开始执行
                            TASKQUEUE.wait();
                        } catch (InterruptedException e) {
                            // e.printStackTrace();
                            System.out.println("线程interrupt and will be close");
                            break OUTER; // 跳出到OUTER处
                        }

                    }
                    // 拿出任务来后不需要同步执行，可以并行执行，所以不用放到synchronized块中
                    // 队列中有任务了，就取出任务
                    task = TASKQUEUE.remove();

                }

                if (task != null){
                    this.state = WorkerThreadStatus.RUNNING;
                    // 执行任务
                    task.run();
                    this.state = WorkerThreadStatus.FREE;
                }
            }
        }
        public void close(){
            this.state = WorkerThreadStatus.DEAD;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool(5,10,15,SimpleThreadPool.DEFAULT_POLICY,66);
        simpleThreadPool.init();
        simpleThreadPool.start();

        // 提交五十个任务
        // 没有使用for循环
        IntStream.rangeClosed(1,50).forEach(i->{
            simpleThreadPool.submit(()->{
                try {
                    Thread.sleep(1000);
                    System.out.println(">>>>当前线程:"+Thread.currentThread()+"执行任务"+i);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });

        });
        Thread.sleep(10000);
        simpleThreadPool.shutdown();
//        // 关闭后再提交一个看看
//        simpleThreadPool.submit(()-> System.out.println("再提交一个任务x"));
    }
}
