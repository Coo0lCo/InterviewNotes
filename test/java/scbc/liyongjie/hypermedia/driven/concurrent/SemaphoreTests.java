package scbc.liyongjie.hypermedia.driven.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/12
 *      Semaphore 与 CyclicBarrier 联合使用的demo
 *      信号量实现线程同步：
 *          信号量Semaphore允许多个线程同时访问一个临界区
 *          实际上就是初始化一个数值，来一个线程就减一，
 *          如果减1之后小于0就阻塞当前线程，进入一个阻塞队列里去排队，
 *          否则的话就允许执行临界区代码
 *
 *          而synchronized 只允许一个线程访问访问临界区，只有释放锁之后才能让在一个线程来访问临界区
 *          synchronized后面会细嗦
 */
public class SemaphoreTests {
    private static final Semaphore semaphore = new Semaphore(1);
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(1000);
    private static int count1 = 1;
    private static int count2 = 1;
    private static void add(){
        System.out.println(count1++ + " ");
    }
    private static void add_Semaphore(){
        try {
            semaphore.acquire();
            System.out.print(count2++ + " ");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            semaphore.release();
        }
    }

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                add();
                try {
                    cyclicBarrier.await();
                }catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                new Thread(SemaphoreTests::add_Semaphore).start();
            }).start();
        }
        Thread.sleep(1000);
    }

}
