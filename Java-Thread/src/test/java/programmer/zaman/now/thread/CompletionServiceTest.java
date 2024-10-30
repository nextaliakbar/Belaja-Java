package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

public class CompletionServiceTest {

    private Random rand = new Random();

    @Test
    void testCompletionService() throws InterruptedException {
        var executors = Executors.newFixedThreadPool(10);
        var completionService = new ExecutorCompletionService(executors);

        // submit
        Executors.newSingleThreadExecutor().execute(()-> {
           for (int i = 0; i < 100; i++) {
               final var index = i;
               completionService.submit(()-> {
                   Thread.sleep(rand.nextInt(2000));
                   return "Task " + index;
               });
           }
        });

        // poll task
        Executors.newSingleThreadExecutor().execute(()-> {
           while(true) {
               try {
                   Future<String> future = completionService.poll(5, TimeUnit.SECONDS);
                   if(future == null) {
                       break;
                   } else {
                       System.out.println(future.get());
                   }
               } catch (InterruptedException | ExecutionException e) {
                   e.printStackTrace();
                   break;
               }
           }
        });

        executors.awaitTermination(1, TimeUnit.DAYS);
    }
}
