package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import services.BankAccount;

public class BankAccountSharedStateTest {

    private BankAccount account = new BankAccount(100);

    @Test
    public void depositTest() {

        account.deposit(50);

        System.out.println("Deposit Test Balance: "
                + account.getBalance()
                + " Thread: "
                + Thread.currentThread().getId());

        Assert.assertTrue(account.getBalance() >= 100);
    }

    @Test
    public void withdrawTest() {

        account.withdraw(30);

        System.out.println("Withdraw Test Balance: "
                + account.getBalance()
                + " Thread: "
                + Thread.currentThread().getId());

        Assert.assertTrue(account.getBalance() <= 100);
    }

    @Test
    public void balanceTest() {

        System.out.println("Balance Test Balance: "
                + account.getBalance()
                + " Thread: "
                + Thread.currentThread().getId());

        Assert.assertEquals(account.getBalance(), 100);
    }
}