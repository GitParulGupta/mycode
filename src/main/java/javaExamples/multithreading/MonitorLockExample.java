package javaExamples.multithreading;

public class MonitorLockExample {

    public synchronized void task1(){
        System.out.println("task1");
        try {
            Thread.sleep(1000);
            System.out.println("task1 completed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void task2(){
        System.out.println("task2");
        synchronized (this){
            System.out.println("task2 Sync block");
        }
    }

    public void task3(){
        System.out.println("task3");
    }
}


