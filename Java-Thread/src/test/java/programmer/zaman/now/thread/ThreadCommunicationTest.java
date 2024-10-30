package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

public class ThreadCommunicationTest {

    private String message;

    @Test
    void testThreadCommunicationManual() throws InterruptedException {

        var thread1 = new Thread(() -> {
           while(message == null) {
                // wait
           }
            System.out.println(message);
        });

        var thread2 = new Thread(() -> {
           message = "Ali Akbar Rafsanjani";
        });

        thread2.start();
        thread1.start();

        thread2.join();
        thread1.join();

    }

    @Test
    void testThreadCommunicationWaitNotify() throws InterruptedException {

        final Object lock = new Object();

        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
            message = "Ali Akbar Rafsanjani";
            lock.notify();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }

    @Test
    void testThreadCommunicationWaitNotifyAll() throws InterruptedException {

        final Object lock = new Object();

        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var thread3 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var thread4 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "Ali Akbar Rafsanjani";
                lock.notify();
            }
        });

        thread1.start();
        thread3.start();
        thread4.start();
        thread2.start();

        thread1.join();
        thread3.join();
        thread4.join();
        thread2.join();

    }
}
