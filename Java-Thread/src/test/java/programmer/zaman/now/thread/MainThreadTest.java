package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

public class MainThreadTest {

    @Test
    void testMainThread() {
        var name = Thread.currentThread().getName();
        System.out.println(name);
    }

    @Test
    void testCreateThread() {
        Runnable runnable = () -> {
            System.out.println("Hello From Thread " + Thread.currentThread().getName());
        };

        var thread = new Thread(runnable);
        thread.start();

        System.out.println("Program Selesai");
    }

    @Test
    void testThreadSleep() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2000L);
                System.out.println("Hello From Thread " + Thread.currentThread().getName());
            } catch(InterruptedException exception) {
                exception.printStackTrace();
            }
        };

        var thread = new Thread(runnable);
        thread.start();

        System.out.println("Program 1 Selesai");
        Thread.sleep(3_000L);
        System.out.println("Program 2 Selesai");
    }

    @Test
    void testThreadJoin() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2000L);
                System.out.println("Hello From Thread " + Thread.currentThread().getName());
            } catch(InterruptedException exception) {
                exception.printStackTrace();
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        System.out.println("Program 1 Selesai");
        thread.join();
        System.out.println("Program 2 Selesai");
    }

    @Test // Cara yang salah ketika menginterrupt
    void testThreadInterrupt1() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable " + i);
                try {
                    Thread.sleep(1000L);
                } catch(InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000L);
        thread.interrupt();
        System.out.println("Program 1 Selesai");
        thread.join();
        System.out.println("Program 2 Selesai");
    }

    @Test // Cara yang benar ketika menginterrupt
    void testThreadInterrupt2() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                // Cara manual interrupted
                if(Thread.interrupted()) {
                    return;
                }

                System.out.println("Runnable " + i);
                try {
                    Thread.sleep(1000L);
                } catch(InterruptedException exception) {
                    return;
                }
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000L);
        thread.interrupt();
        System.out.println("Program 1 Selesai");
        thread.join();
        System.out.println("Program 2 Selesai");
    }

    @Test
    void testThreadName() {
        var thread = new Thread(() -> {
            System.out.println("Hello From Thread " + Thread.currentThread().getName());
        });

        thread.setName("Akbar");
        thread.start();

    }

    @Test
    void testThreadState() throws InterruptedException {
        var thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getState());
            System.out.println("Hello From Thread " + Thread.currentThread().getName());
        });

        thread.setName("Akbar");
        System.out.println(thread.getState());

        thread.start();
        thread.join();
        System.out.println(thread.getState());
    }
}
