package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerTest {


    // Digunakan untuk pertukaran data antar thread, jika terdapat salah satu yang tidak menerima data maka akan memblock
    @Test
    void testExchanger() throws InterruptedException {
        final var exchanger = new Exchanger<String>();
        final var executor = Executors.newFixedThreadPool(10);

        executor.execute(()-> {
            try {
                System.out.println("Thread 1 : send : First");
                Thread.sleep(1000);
                var result = exchanger.exchange("first");
                System.out.println("Thread 1 : receive : " + result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.execute(()-> {
            try {
                System.out.println("Thread 2 : send : Second");
                Thread.sleep(2000);
                var result = exchanger.exchange("second");
                System.out.println("Thread 2 : receive : " + result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.awaitTermination(1 , TimeUnit.DAYS);
    }
}
