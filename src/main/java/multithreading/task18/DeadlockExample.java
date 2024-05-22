package multithreading.task18;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    private static class Resource {
        // Ресурсы
    }

    private final Resource resourceA = new Resource();
    private final Resource resourceB = new Resource();
    private final Lock lockA = new ReentrantLock();
    private final Lock lockB = new ReentrantLock();

    public void execute() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                acquireResourcesAndWork(lockA, lockB, resourceA, resourceB, "Thread-1");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                acquireResourcesAndWork(lockB, lockA, resourceB, resourceA, "Thread-2");
            }
        });

        thread1.start();
        thread2.start();
    }

    private void acquireResourcesAndWork(Lock firstLock, Lock secondLock, Resource firstResource, Resource secondResource, String threadName) {
        while (true) {
            boolean gotFirstLock = firstLock.tryLock();
            boolean gotSecondLock = false;

            try {
                if (gotFirstLock) {
                    System.out.println(threadName + " locked " + firstResource);
                    try {
                        Thread.sleep(50);  // имитация работы для увеличения шанса на deadlock
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    gotSecondLock = secondLock.tryLock();
                    if (gotSecondLock) {
                        System.out.println(threadName + " locked " + secondResource);

                        try {
                            // Имитация работы с ресурсом
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        } finally {
                            secondLock.unlock();
                            System.out.println(threadName + " unlocked " + secondResource);
                        }
                        break;  // Успешно захватили обе блокировки, выход из цикла
                    }
                }
            } finally {
                if (gotFirstLock && !gotSecondLock) {
                    firstLock.unlock();
                    System.out.println(threadName + " unlocked " + firstResource + " (due to failure to acquire second lock)");
                }
            }

            // Задержка перед повторной попыткой, чтобы избежать активного ожидания
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        DeadlockExample example = new DeadlockExample();
        example.execute();
    }
}

