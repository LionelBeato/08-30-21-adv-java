package threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class ExecutorsExample {

    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("Hello from a runnable");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newFixedThreadPool(10);
        executor.execute(runnable);
        executor.execute(() -> System.out.println("Hello from other runnable"));
        executor.shutdown();

        service.execute(() -> System.out.println("Hello from runnable 1"));
        service.execute(() -> System.out.println("Hello from runnable 2"));
        service.shutdown();


        int[] src = {10,255,34,23,12,43,23};
        int[] dst = {10,255,34,23,12,43,23};

        ForkBlur fb = new ForkBlur(src, 0, src.length, dst);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(fb);


    }

}
