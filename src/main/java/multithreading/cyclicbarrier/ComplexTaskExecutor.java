package multithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplexTaskExecutor {
    private final int numberOfTasks;
    private final CyclicBarrier barrier;

    public ComplexTaskExecutor(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
        this.barrier = new CyclicBarrier(numberOfTasks);
    }

    public void executeTasks(int numberOfThreads) {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfTasks; i++) {
            executor.execute(() -> {
                ComplexTask task = new ComplexTask();
                task.execute();
                try {
                    barrier.await(); // Ожидание завершения всех потоков
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
    }
}
