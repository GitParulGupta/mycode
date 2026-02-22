package javaExamples.multithreading.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockMain {

    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock(true);

        ReadWriteLockDemo obj = new ReadWriteLockDemo();

        Thread t1 = new Thread(()->{
            obj.producer(lock);
        });

        //ReadWriteLockDemo obj2 = new ReadWriteLockDemo();
        Thread t2 = new Thread(()->{
            obj.consumer(lock);
        });

        t1.start();
        t2.start();
    }
}
