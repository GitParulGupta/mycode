package javaExamples.multithreading.producerconsumer;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingLocks {

    int capacity = 10;
    ReentrantLock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();
    Queue<Integer> queue = new LinkedList<>();

    public void producer(int i){
        lock.lock();

        try{
            while(queue.size()==capacity){
                notFull.await();
            }
            queue.add(i);
            notEmpty.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

    public int consumer(){
        lock.lock();

        try{
            while(queue.isEmpty()){
                notEmpty.await();
            }
            int result = queue.poll();
            System.out.println(result);
            notFull.signal();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

}
