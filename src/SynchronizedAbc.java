import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类描述:
 *
 * @ClassName SynchronizedAbc
 * @Description
 * @Author chenjiahao
 * @Date 2021/7/17 16:01
 */
public class SynchronizedAbc {
    // 使用lock锁来保证线程的访问的互斥
    private static Lock lock = new ReentrantLock();

    // 通过state的值对线程数量取模跟编号对比，来确定该线程是否打印
    private static int state = 0;

    // 线程数量
    private static int threadCount = 3;

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread(0);
        MyThread myThread2 = new MyThread(1);
        MyThread myThread3 = new MyThread(2);
        new Thread(myThread1,"A").start();
        new Thread(myThread2,"B").start();
        new Thread(myThread3,"C").start();
//        new MyThread(0).start();
//        new MyThread(1).start();
//        new MyThread(2).start();
    }

    static class MyThread implements Runnable{

        //线程编号，很重要，用来确定该线程应该打印哪个字母
        private int threadNum;

        public MyThread(int threadNum){
            this.threadNum = threadNum;
        }

        @Override
        public void run() {
            // while循环10次
            int i = 0;

            while (i < 10){
                try {
                    lock.lock();
                    //递增的state，state取模，判断是否该当前线程打印
                    while (state % threadCount == this.threadNum){
                        if (threadNum == 0){
                            System.out.println(Thread.currentThread().getName()+ "==A");
                        }else if (threadNum == 1){
                            System.out.println(Thread.currentThread().getName()+ "==B");
                        }else {
                            System.out.println(Thread.currentThread().getName()+ "==C");
                        }
                        //state值+1，每次线程进来打印一个字母后，state值+1,
                        state++;
                        //i++操作是为了打印10次后，跳出最外层while循环
                        i++;

                    }

                }finally {
                    lock.unlock();
                }
            }

        }
    }
}
