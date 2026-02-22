package javaExamples.multithreading.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockResource {

    public void producer(ReentrantLock lock) {

        try{
            lock.lock();
            System.out.println("Producer " + Thread.currentThread().getName()+" Lock acquired");
            Thread.sleep(5000);
        }catch (Exception e){

        }finally {
            lock.unlock();
            System.out.println("Producer " + Thread.currentThread().getName()+" Lock released");
        }

    }

    /*public void consumer(ReentrantLock lock) {

        try{
            lock.lock();
            System.out.println("consumer " + Thread.currentThread().getName()+" Lock acquired");
            Thread.sleep(5000);
        }catch (Exception e){

        }finally {
            lock.unlock();
            System.out.println("consumer " + Thread.currentThread().getName()+" Lock released");
        }

    }*/
}
