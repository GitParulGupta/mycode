package javaExamples.multithreading;

import java.util.concurrent.*;

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,1, TimeUnit.MINUTES,new ArrayBlockingQueue<>(2),new ThreadPoolExecutor.DiscardPolicy());

        CompletableFuture<String> obj = CompletableFuture.supplyAsync(() -> {
            return "task1 completed";
        },executor);

        System.out.println(obj.get());


        CompletableFuture<String> obj2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "task2 completed";
        },executor).thenApply(str -> str + Thread.currentThread().getName());

        System.out.println(obj2.get());


        CompletableFuture<String> obj3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "task3 completed";
        },executor).thenApplyAsync(str -> str + Thread.currentThread().getName(),executor).exceptionally((ex)->{
            throw new RuntimeException(ex);
        });

        System.out.println(obj3.get());

        System.out.println(obj.isDone());
        System.out.println(obj2.isDone());
        System.out.println(obj3.isDone());


        CompletableFuture<String> obj4 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "task4 completed";
        },executor).thenCompose((String val)->{
            return CompletableFuture.supplyAsync(()->val + "current thread "+Thread.currentThread().getName());
        });
        System.out.println(obj4.get());

        CompletableFuture<Void> obj5 = CompletableFuture.supplyAsync(() -> { //maintains stack of dependent actions
            System.out.println(Thread.currentThread().getName()+"task5 completed");
            return "task5 completed";
        },executor).thenComposeAsync((String val)->{
            return CompletableFuture.supplyAsync(()->{System.out.println(val + "current thread "+Thread.currentThread().getName()); return "temp";},executor);
        },executor).thenAccept((String val)-> System.out.println("All stages completed"));

        System.out.println(obj5.get());

        CompletableFuture<Integer> async1 = CompletableFuture.supplyAsync(()->{
            return 100;
        },executor);

        CompletableFuture<String> async2 = CompletableFuture.supplyAsync(()->{
            return "k";
        },executor);


        CompletableFuture<String> obj6 = async1.thenCombine(async2,(Integer v1,String v2)->v1+v2);
        System.out.println(obj6.get());

        executor.shutdown();
    }
}
