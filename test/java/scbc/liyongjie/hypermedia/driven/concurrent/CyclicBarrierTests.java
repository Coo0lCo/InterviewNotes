package scbc.liyongjie.hypermedia.driven.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/12
 *      Cyclic-Barrier 可循环的屏障，直译过来就是这个意思
 *      实际上内部是基于可重入锁ReentrantLock+Condition实现的
 *      每次来一个线程计数器就会减1
 *      如果计数器不等于0则调用 condition.await阻塞等待
 *      如果等于0则 condition.signalAll 唤醒所有的线程
 *      condition.signalAll后会重置屏障
 *      CyclicBarrier是可以重复使用的
 */
public class CyclicBarrierTests {
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(100);
    private static final ReentrantLock reentrantLock = new ReentrantLock();
    private static int count = 1;
    private static int count1 = 1;
    private static void add(){
        System.out.println(count++);
    }
    private static void add_Lock(){
        reentrantLock.lock();
        System.out.print(count1+++" ");
        reentrantLock.unlock();
    }

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                add();
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                add_Lock();
            }).start();
        }
        Thread.sleep(1000);
    }


}

