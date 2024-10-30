package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class ReactiveStreamTest {


    @Test
    void testPublish() throws InterruptedException {
        var publisher = new SubmissionPublisher<String>();
        var subscriber1 = new PrintSubscriber("A", 1000L);
        var subscriber2 = new PrintSubscriber("B", 500L);
        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        var executor = Executors.newFixedThreadPool(10);
        executor.execute(()-> {
            // jika data yang dikirim >= 256 maka data selanjutnya akan dikirim setelah data diterima oleh subscirber
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(2000);
                    publisher.submit("Akbar " + i);
                    System.out.println(Thread.currentThread().getName()+" : Send Akbar " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.shutdown();
//        executor.awaitTermination(1, TimeUnit.DAYS);
        Thread.sleep(100 * 1000);
    }

    @Test
    void testBuffer() throws InterruptedException {
        var publisher = new SubmissionPublisher<String>(Executors.newFixedThreadPool(10), 10);
        var subscriber1 = new PrintSubscriber("A", 1000L);
        var subscriber2 = new PrintSubscriber("B", 500L);
        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        var executor = Executors.newFixedThreadPool(10);
        executor.execute(()-> {
            for (int i = 0; i < 10; i++) {
                publisher.submit("Akbar " + i);
                System.out.println(Thread.currentThread().getName()+" : Send Akbar " + i);
            }
        });

        Thread.sleep(100 * 1000);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void testProcessor() throws InterruptedException {
        var publisher = new SubmissionPublisher<String>();
        var processor = new HelloProcessor();
        publisher.subscribe(processor);

        var subscriber = new PrintSubscriber("A", 1000L);
        processor.subscribe(subscriber);

        var executor = Executors.newFixedThreadPool(10);
        executor.execute(()-> {
            // jika data yang dikirim >= 256 maka data selanjutnya akan dikirim setelah data diterima oleh subscirber
            for (int i = 0; i < 100; i++) {
                publisher.submit("Akbar " + i);
                System.out.println(Thread.currentThread().getName()+" : Send Akbar " + i);
            }
        });

        executor.shutdown();
        Thread.sleep(100 * 1000);
    }

    public static class PrintSubscriber implements Flow.Subscriber<String> {

        private Flow.Subscription subscription;
        private String name;
        private Long sleep;

        public PrintSubscriber(String name, Long sleep) {
            this.name = name;
            this.sleep = sleep;
        }

        // untuk menarik data
        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            subscription.request(1);
            //subscription.cancel(); // digunakan jika subscriber tidak lagi membutuhkan data
        }

        @Override
        public void onNext(String item) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": "+name+" :" + item);
                this.subscription.request(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            System.out.println(Thread.currentThread().getName() + ": Completed");
        }
    }

    public static class HelloProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {

        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            var value = "Hello " + item;
            submit(value);
            this.subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            close();
        }
    }
}
