package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FutureTest {

    @Test
    void testFuture() throws ExecutionException, InterruptedException {
        Callable<String> callable = ()-> {
            Thread.sleep(5000);
            return "Hello World";
        };

        var executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(callable);
        System.out.println("Selesai Future");

        while (!future.isDone()) {
            System.out.println("Waiting futures");
            Thread.sleep(1000);
        }
        String value = future.get();
        System.out.println(value);
    }

    @Test
    void testFutureCancel() throws ExecutionException, InterruptedException {
        Callable<String> callable = ()-> {
            Thread.sleep(5000);
            return "Hello World";
        };

        var executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(callable);
        System.out.println("Selesai Future");
        Thread.sleep(2000);
        future.cancel(true);
        System.out.println(future.isCancelled());
        String value = future.get();
        System.out.println(value);
    }

    @Test
    void testInvokeAll() throws ExecutionException, InterruptedException {
        var executor = Executors.newFixedThreadPool(10);
        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj(value -> (Callable<String>)()-> {
            Thread.sleep(500L);
            return "Hello ".concat(String.valueOf(value));
        }).collect(Collectors.toList());

        List<Future<String>> futures = executor.invokeAll(callables);
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
    }

    @Test
    void testInvokeAny() throws ExecutionException, InterruptedException {
        var executor = Executors.newFixedThreadPool(10);
        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj(value -> (Callable<String>)()-> {
            Thread.sleep(500L);
            return "Hello ".concat(String.valueOf(value));
        }).collect(Collectors.toList());

        var value = executor.invokeAny(callables);
        System.out.println(value);
    }
}
