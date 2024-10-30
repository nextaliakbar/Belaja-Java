package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Comparator;
import java.util.concurrent.*;

public class BlockingQueueTest {

    @Test
    void testArrayBlockingQueue() throws InterruptedException {
        var queue = new ArrayBlockingQueue<String>(5);
        var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var data = i;
            executor.execute(()-> {
                try {
                    queue.put("Data " + String.valueOf(data));
                    System.out.println("Finish Put Data " + String.valueOf(data));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.execute(()-> {
            while(true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println("Recieve data " + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void testLinkedBlockingQueue() throws InterruptedException {
        var queue = new LinkedBlockingQueue<String>();
        var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var data = i;
            executor.execute(()-> {
                try {
                    queue.put("Data " + String.valueOf(data));
                    System.out.println("Finish Put Data " + String.valueOf(data));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.execute(()-> {
            while(true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println("Recieve data " + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.awaitTermination(20, TimeUnit.SECONDS);
//        executor.shutdown();
    }

    @Test
    void testPriorityBlockingQueue() throws InterruptedException {
        var queue = new PriorityBlockingQueue<Integer>(10, Comparator.reverseOrder());
        var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var data = i;
            executor.execute(()-> {
                queue.put(data);
                System.out.println("Finish Put Data " + String.valueOf(data));
            });
        }

        executor.execute(()-> {
            while(true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println("Recieve data " + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.awaitTermination(20, TimeUnit.SECONDS);
//        executor.shutdown();
    }

    @Test
    void testDelayQueue() throws InterruptedException {
        var queue = new DelayQueue<ScheduledFuture<String>>();
        var executor = Executors.newFixedThreadPool(10);
        var executorSchedule = Executors.newScheduledThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            final var data = i;
            queue.put(executorSchedule.schedule(()-> "Data" + data, i, TimeUnit.SECONDS));
        }

        executor.execute(()-> {
            while(true) {
                try {
                    var value = queue.take();
                    System.out.println("Recieve data " + value.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.awaitTermination(1, TimeUnit.MINUTES);
        executor.shutdown();
    }

    @Test
    void testSynchornousQueue() throws InterruptedException {
        var queue = new SynchronousQueue<String>();
        var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var data = i;
            executor.execute(()-> {
                try {
                    queue.put("Data " + data);
                    System.out.println("Finish Put Data " + data);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.execute(()-> {
            while(true) {
                try {
                    Thread.sleep(2000);
                    var value = queue.take();
                    System.out.println("Recieve data " + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void testBlockingQueue() throws InterruptedException {
        var queue = new LinkedBlockingDeque<String>();
        var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var data = i;
            try {
                queue.putLast(String.valueOf(data));
                System.out.println("Finish Put Data " + data);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        executor.execute(()-> {
            while(true) {
                try {
                    Thread.sleep(2000);
//                    var value = queue.takeLast();
                    var value = queue.takeFirst();
                    System.out.println("Recieve data " + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void testTransferQueue() throws InterruptedException {
        var queue = new LinkedTransferQueue<String>();
        var executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final var data = i;
            executor.execute(()-> {
                try {
                    queue.transfer(String.valueOf(data));
                    System.out.println("Finish Put Data " + data);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
        }

        executor.execute(()-> {
            while(true) {
                try {
                    Thread.sleep(2000);
//                    var value = queue.takeLast();
                    var value = queue.take();
                    System.out.println("Recieve data " + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
