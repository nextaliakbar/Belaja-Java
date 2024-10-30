package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamParallelTest {

    @Test
    void testStreamParallel() {
        Stream<Integer> stream = IntStream.range(0, 1000).boxed();
        stream.parallel().forEach(value -> System.out.println(Thread.currentThread().getName() + ": " + value));
    }

    @Test
    void testStreamParallelCustom() {
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);

        ForkJoinTask<?> task =  forkJoinPool.submit(()-> {
            Stream<Integer> stream = IntStream.range(0, 1000).boxed();
            stream.parallel().forEach(value -> System.out.println(Thread.currentThread().getName() + ": " + value));
        });

        task.join();
    }
}
