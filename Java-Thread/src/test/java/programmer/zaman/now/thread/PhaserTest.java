package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest {

    @Test
    void testPhaserCountDownLach() throws InterruptedException {
        var phaser = new Phaser();
        var executor = Executors.newFixedThreadPool(15);

        phaser.bulkRegister(5);
        phaser.bulkRegister(5);

        for (int i = 0; i < 10; i++) {
            executor.execute(()-> {
                try {
                    System.out.println("Start Task");
                    Thread.sleep(2000);
                    System.out.println("Done Task");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    phaser.arrive();
                }
            });
        }


        executor.execute(()-> {
            phaser.awaitAdvance(0);
            System.out.println("Done All Task");
        });
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void testPhaserCyclicBarrier() throws InterruptedException {
        var phaser = new Phaser();
        var executor = Executors.newFixedThreadPool(15);

        phaser.bulkRegister(5);

        for (int i = 0; i < 5; i++) {
            executor.execute(()-> {
                try {
                    System.out.println("Waiting");
                    Thread.sleep(1000);
                    phaser.arriveAndAwaitAdvance();
                    System.out.println("DONE");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
