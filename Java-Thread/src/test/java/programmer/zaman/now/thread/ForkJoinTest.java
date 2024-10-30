package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForkJoinTest {

    @Test
    void testCreate() {
        var forkJoinPollCommont = ForkJoinPool.commonPool(); // membuat thread sesuai dengan core cpu perangkat
        var forkJoinPollCustom = new ForkJoinPool(5);

        var executorCommont = Executors.newWorkStealingPool(); // merunning thread sesuai dengan core cpu perangkat
        var executorCustom = Executors.newWorkStealingPool(5);
    }

    @Test
    void testRecursiveAction() throws InterruptedException {
        var pool = ForkJoinPool.commonPool();
        List<Integer> list = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        var task = new SimpleForkJoinTask(list);
        pool.execute(task);

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void testRecursiveTask() throws InterruptedException, ExecutionException {
        var pool = ForkJoinPool.commonPool();
        List<Integer> list = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        var task = new TotalRecursiveTask(list);
        ForkJoinTask<Long> submit = pool.submit(task);

        Long aLong = submit.get();
        System.out.println(aLong);

        Long sum = list.stream().mapToLong(val -> val).sum();
        System.out.println(sum);

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);
    }

    public static class SimpleForkJoinTask extends RecursiveAction {

        private List<Integer> list;

        public SimpleForkJoinTask(List<Integer> list) {
            this.list = list;
        }

        @Override
        protected void compute() {
            if(list.size() <= 10) {
                // eksekusi
                doExecute();
            } else {
                // forking
                forkCompute();
            }
        }

        private void forkCompute() {
            List<Integer> list1 = this.list.subList(0, this.list.size() / 2);
            SimpleForkJoinTask task1 = new SimpleForkJoinTask(list1);

            List<Integer> list2 = this.list.subList(this.list.size()/ 2, this.list.size());
            SimpleForkJoinTask task2 = new SimpleForkJoinTask(list2);

            ForkJoinTask.invokeAll(task1, task2);
        }

        private void doExecute() {
            list.forEach(value -> System.out.println(value));
        }

    }

    public static class TotalRecursiveTask extends RecursiveTask<Long> {

        private List<Integer> list;

        public TotalRecursiveTask(List<Integer> list) {
            this.list = list;
        }

        @Override
        protected Long compute() {
            if(list.size() <= 10) {
                return doCompute();
            } else {
                return forkCompute();
            }
        }

        private Long doCompute() {
            return list.stream().mapToLong(value -> value).peek(value -> {
                System.out.println(value);
            }).sum();
        }

        private Long forkCompute() {
            List<Integer> list1 = this.list.subList(0, this.list.size() / 2);
            TotalRecursiveTask task1 = new TotalRecursiveTask(list1);

            List<Integer> list2 = this.list.subList(this.list.size()/ 2, this.list.size());
            TotalRecursiveTask task2 = new TotalRecursiveTask(list2);

            ForkJoinTask.invokeAll(task1, task2);
            return task1.join() + task2.join();

        }
    }
}
