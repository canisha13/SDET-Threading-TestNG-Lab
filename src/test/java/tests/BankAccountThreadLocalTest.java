package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import services.BankAccount;

public class BankAccountThreadLocalTest {

    private static ThreadLocal<BankAccount> account = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        account.set(new BankAccount(100));
    }

    @Test
    public void depositTest() {

        BankAccount currentAccount = account.get();

        currentAccount.deposit(50);

        System.out.println("Deposit Test Balance: "
                + currentAccount.getBalance()
                + " Thread: "
                + Thread.currentThread().getId());

        Assert.assertEquals(currentAccount.getBalance(), 150);
    }

    @Test
    public void withdrawTest() {

        BankAccount currentAccount = account.get();

        currentAccount.withdraw(30);

        System.out.println("Withdraw Test Balance: "
                + currentAccount.getBalance()
                + " Thread: "
                + Thread.currentThread().getId());

        Assert.assertEquals(currentAccount.getBalance(), 70);
    }

    @Test
    public void balanceTest() {

        BankAccount currentAccount = account.get();

        System.out.println("Balance Test Balance: "
                + currentAccount.getBalance()
                + " Thread: "
                + Thread.currentThread().getId());

        Assert.assertEquals(currentAccount.getBalance(), 100);
    }
}