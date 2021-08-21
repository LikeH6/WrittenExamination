import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * 类描述:
 *
 * @ClassName ThreadPool
 * @Description
 * @Author chenjiahao
 * @Date 2021/7/26 10:16
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor
                (3,5,1L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + " ====>办理业务");
            });
        }
    }
}
