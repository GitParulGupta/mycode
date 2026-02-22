package javaExamples.multithreading.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public SharedResource(int size) {
        sharedBuffer = new LinkedList<>();
        bufferSize = size;
    }

    public synchronized void produce(int item){

        if(sharedBuffer.size() == bufferSize){
            System.out.println("Shared Buffer is full. Asking producer to wait");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        sharedBuffer.add(item);
        System.out.println("Added item to Buffer: " + item);
        notify();//notify any consumers
    }

    public synchronized void consume(int item){

        if(sharedBuffer.isEmpty()){
            System.out.println("Shared Buffer is empty. Asking consumer to wait");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        sharedBuffer.remove(item);
        System.out.println("Removed item from Buffer: " + item);
        notify();//notify any producers
    }

}
