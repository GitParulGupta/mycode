package javaExamples.multithreading.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class ReadWriteLockDemo {

    public void producer(ReadWriteLock lock) {

        try{
            lock.readLock().lock();
            System.out.println("Producer " + Thread.currentThread().getName()+" ReadLock acquired");
            Thread.sleep(5000);
        }catch (Exception e){

        }finally {
            lock.readLock().unlock();
            System.out.println("Producer " + Thread.currentThread().getName()+" ReadLock released");
        }

    }

    public void consumer(ReadWriteLock lock) {

        try{
            lock.writeLock().lock();
            System.out.println("consumer " + Thread.currentThread().getName()+" WriteLock acquired");
            Thread.sleep(5000);
        }catch (Exception e){

        }finally {
            lock.writeLock().unlock();
            System.out.println("consumer " + Thread.currentThread().getName()+" WriteLock released");
        }

    }
}
