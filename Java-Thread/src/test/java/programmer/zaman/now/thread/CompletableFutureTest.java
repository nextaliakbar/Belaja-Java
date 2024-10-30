package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

public class CompletableFutureTest {

    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private Random random = new Random();

    public CompletableFuture<String> getValue() {
        CompletableFuture<String> future = new CompletableFuture<>();

        executorService.execute(()-> {
            try {
                Thread.sleep(2000);
                future.complete("Ali Akbar Rafsanjani");
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });

        return future;
    }

    @Test
    public void testFuture() throws ExecutionException, InterruptedException {
        String value = getValue().get();
        System.out.println(value);
    }

    private void execute(CompletableFuture<String> future, String value) {
        executorService.execute(()->{
            try {
                Thread.sleep(2000 + random.nextInt(5000));
                future.complete(value);
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });
    }

    public Future<String> getFastest() {
        CompletableFuture<String> future = new CompletableFuture<>();

        execute(future, "Hello World 1");
        execute(future, "Hello World 2");
        execute(future, "Hello World 3");

        return future;
    }

    @Test
    void testFastestFuture() throws ExecutionException, InterruptedException {
        System.out.println(getFastest().get());
    }

    @Test
    void testCompleteStage() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = getValue();

        CompletableFuture<String[]> future1 = future
                .thenApply(string -> string.toUpperCase())
                .thenApply(string -> string.split(" "));

        String[] strings = future1.get();

        for (String value : strings) {
            System.out.println(value);
        }
    }
}
