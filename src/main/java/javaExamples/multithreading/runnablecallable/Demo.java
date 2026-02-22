package javaExamples.multithreading.runnablecallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Demo {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5),new ThreadPoolExecutor.DiscardPolicy());

        //Runnable task without return
        Future<?> obj1 = executor.submit(()->System.out.println(""));

        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> obj2 = executor.submit(new MyRunnable(output),output);

        List<Integer> output2;
        try {
            output2 = obj2.get();
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println(output.size());

        List<Integer> output3 = new ArrayList<>();
        Future<List<Integer>> obj3 = executor.submit(()->{
            System.out.println("Callable task");
            output3.add(100);
            return output3;
        });



    }
}
