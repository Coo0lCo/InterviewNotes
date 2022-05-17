package scbc.liyongjie.hypermedia.driven.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/12
 *      首先初始化一个state值
 *      来一个线程就countDown一次，计数器减一
 *      当计数器小于0的时候被阻塞的线程就会被唤醒
 *
 *     注意：其他线程是不会阻塞的
 *
 *     最后要执行的业务，需要等待其他线程都执行完某个业务之后再执行的场景
 */
public class CountDownLatchTests {

    private static final CountDownLatch countDownLatch = new CountDownLatch(20);

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            new Thread(()-> {
                System.out.println("大聪明"+ Thread.currentThread().getName() +"号上线辣!");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("游戏即将开始！！！！");
    }

}
