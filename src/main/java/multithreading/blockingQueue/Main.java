package multithreading.blockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>(10);

        Runnable producer = () -> {
            for (int i = 0; i < 20; i++) {
                try {
                    blockingQueue.enqueue(i);
                    System.out.println("Producer " + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable consumer = () -> {
            for (int i = 0; i < 20; i++) {
                try {
                    int item = blockingQueue.dequeue();
                    System.out.println("Consumer " + i + ": " + item);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
