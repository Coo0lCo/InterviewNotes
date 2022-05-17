package scbc.liyongjie.hypermedia.driven.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/12
 */
public class ReentrantReadWriteLockTests {

    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static final Lock readLock = reentrantReadWriteLock.readLock();
    private static final Lock writeLock = reentrantReadWriteLock.readLock();

    @Test
    public void test(){

    }

}
