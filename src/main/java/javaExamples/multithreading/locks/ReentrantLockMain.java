package javaExamples.multithreading.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMain {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        ReentrantLockResource obj = new ReentrantLockResource();

        Thread t1 = new Thread(()->{
            obj.producer(lock);
        });

        ReentrantLockResource obj2 = new ReentrantLockResource();
        Thread t2 = new Thread(()->{
            obj2.producer(lock);
        });

        t1.start();
        t2.start();
    }
}
