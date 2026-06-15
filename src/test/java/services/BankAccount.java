package services;

public class BankAccount {

    private int balance;

    public BankAccount(int openingBalance) {
        this.balance = openingBalance;
    }

    public void deposit(int amount) {
        balance = balance + amount;
    }

    public void withdraw(int amount) {
        balance = balance - amount;
    }

    public void transferTo(BankAccount targetAccount, int amount) {
        this.withdraw(amount);
        targetAccount.deposit(amount);
    }

    public int getBalance() {
        return balance;
    }
}