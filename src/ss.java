import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类描述:
 *
 * @ClassName ss
 * @Description
 * @Author chenjiahao
 * @Date 2021/8/12 16:56
 */
public class ss {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {

                @Override
                public void run() {
                    System.out.println("线程"+Thread.currentThread().getName()+"正执行");
                    countDownLatch.countDown();
                }
            };
            service.execute(runnable);
        }
        try {
            Thread.sleep(1000);
            countDownLatch.await();
            System.out.println("主线程开始执行");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
