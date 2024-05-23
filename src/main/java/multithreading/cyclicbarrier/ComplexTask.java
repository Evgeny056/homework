package multithreading.cyclicbarrier;

public class ComplexTask {
    public void execute() {
        // Реализуйте выполнение сложной задачи здесь
        System.out.println(Thread.currentThread().getName() + " is executing a complex task...");
        try {
            Thread.sleep(2000); // Для имитации выполнения сложной задачи
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
