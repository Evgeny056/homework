package multithreading.bankAccount;

import java.util.HashMap;
import java.util.Map;

public class ConcurrentBank {
    private final Map<Integer, BankAccount> bankAccounts = new HashMap<>();
    private int nextAccountNumber = 1;

    public synchronized BankAccount createAccount(double initialBalance) {
        int accountNumber = nextAccountNumber++;
        BankAccount newAccount = new BankAccount(accountNumber, initialBalance);
        bankAccounts.put(accountNumber, newAccount);
        return newAccount;
    }

    public void transfer(BankAccount from, BankAccount to, double amount) {
        BankAccount firstLock, secondLock;
        if (from.getAccountNumber() < to.getAccountNumber()) {
            firstLock = from;
            secondLock = to;
        } else {
            firstLock = to;
            secondLock = from;
        }

        synchronized (firstLock) {
            synchronized (secondLock) {
                if (from.withdraw(amount)) {
                    to.deposit(amount);
                }
            }
        }
    }

    public double getTotalBalance() {
        synchronized (this) {
            double totalBalance = 0;
            for(BankAccount account : bankAccounts.values()) {
                synchronized (account) {
                    totalBalance += account.getBalance();
                }
            }
            return totalBalance;
        }
    }
}
