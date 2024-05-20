package multithreading.bankAccount;


public class BankAccount {
    private final int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized boolean withdraw(double amount) {
        if (balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized int getAccountNumber() {
        return accountNumber;
    }
}
