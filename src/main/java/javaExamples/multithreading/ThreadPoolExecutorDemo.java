package javaExamples.multithreading;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,5, TimeUnit.MINUTES,new ArrayBlockingQueue<>(2),new CustomThreadFactory(),new CustomRejectedExecutionHandler());

        for(int i=0;i<=4;i++){ //if this is changed to 7, then task will get rejected
            int finalI = i;
            executor.submit(()->{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task Executed "+finalI+" "+Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(false);
        t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }
}

class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task Rejected By CustomRejectedExecutionHandler"+r.toString());
    }
}