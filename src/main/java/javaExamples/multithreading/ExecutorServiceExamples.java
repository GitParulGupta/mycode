package javaExamples.multithreading;

import java.util.concurrent.*;

public class ExecutorServiceExamples {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(50),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());

        CompletableFuture<String> obj = CompletableFuture.supplyAsync(()->"heallo",executor).thenApply((a)->{
            return a+"def";
        });



        ExecutorService executor2 = Executors.newFixedThreadPool(5 , Executors.defaultThreadFactory());
        executor2.submit(()->{
            System.out.println("task3");
        });

        ExecutorService executor23 = Executors.newScheduledThreadPool(4);
        executor23.submit(()->{
            System.out.println("task4");
        });

        ScheduledThreadPoolExecutor executor4 = new ScheduledThreadPoolExecutor(4);
        executor4.schedule(()->{
            System.out.println("task5");
        },10,TimeUnit.MINUTES);


        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set(Thread.currentThread().getName());



        ExecutorService executor5 = Executors.newVirtualThreadPerTaskExecutor();

    }
}

