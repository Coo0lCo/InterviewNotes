package scbc.liyongjie.hypermedia.driven.threadlocal;

import org.junit.jupiter.api.Test;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/12
 *      ThreadLocal可以实现多线程
 */

public class ThreadLocalTests {

    public static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

    @Test
    public void test() throws InterruptedException {

        Thread thread = new Thread(()->{
            integerThreadLocal.set(1);
            System.out.println(integerThreadLocal.get());
        });

        thread.start();
        Thread.sleep(1000);

        new Thread(()-> System.out.println(integerThreadLocal.get())).start();

    }



}
