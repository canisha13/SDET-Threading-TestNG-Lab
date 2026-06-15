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
                + " Thread ID: "
                + Thread.currentThread().getId()
                + " Thread Name: "
                + Thread.currentThread().getName());

        Assert.assertEquals(currentAccount.getBalance(), 150);
    }

    @Test
    public void withdrawTest() {

        BankAccount currentAccount = account.get();

        currentAccount.withdraw(30);

        System.out.println("Withdraw Test Balance: "
                + currentAccount.getBalance()
                + " Thread ID: "
                + Thread.currentThread().getId()
                + " Thread Name: "
                + Thread.currentThread().getName());

        Assert.assertEquals(currentAccount.getBalance(), 70);
    }

    @Test
    public void balanceTest() {
    	BankAccount currentAccount = account.get();
    	System.out.println("Balance Test Balance: "
    	        + currentAccount.getBalance()
    	        + " Thread ID: "
    	        + Thread.currentThread().getId()
    	        + " Thread Name: "
    	        + Thread.currentThread().getName());

        Assert.assertEquals(currentAccount.getBalance(), 100);
    }
    @Test
    public void depositZeroAmountTest() {

        BankAccount currentAccount = account.get();

        currentAccount.deposit(0);

        Assert.assertEquals(currentAccount.getBalance(), 100);
    }

    @Test
    public void withdrawZeroAmountTest() {

        BankAccount currentAccount = account.get();

        currentAccount.withdraw(0);

        Assert.assertEquals(currentAccount.getBalance(), 100);
    }

    @Test
    public void withdrawFullBalanceTest() {

        BankAccount currentAccount = account.get();

        currentAccount.withdraw(100);

        Assert.assertEquals(currentAccount.getBalance(), 0);
    }

    @Test
    public void depositMultipleTimesTest() {

        BankAccount currentAccount = account.get();

        System.out.println("Starting Balance: "
                + currentAccount.getBalance());

        currentAccount.deposit(50);
        System.out.println("Balance after 1st deposit: "
                + currentAccount.getBalance());

        currentAccount.deposit(25);
        System.out.println("Balance after 2nd deposit: "
                + currentAccount.getBalance());

        currentAccount.deposit(10);
        System.out.println("Deposit Test Balance: "
                + currentAccount.getBalance());

        Assert.assertEquals(currentAccount.getBalance(), 185);
    }

    @Test
    public void withdrawMultipleTimesTest() {

        BankAccount currentAccount = account.get();
        System.out.println("Starting Balance: "
                + currentAccount.getBalance());

        currentAccount.withdraw(20);
        System.out.println("Balance after 1st withdraw: "
                + currentAccount.getBalance());

        currentAccount.withdraw(30);
        System.out.println("Balance after 2nd withdraw: "
                + currentAccount.getBalance());

        currentAccount.withdraw(10);
        System.out.println("Withdraw Test Balance: "
                + currentAccount.getBalance());

        Assert.assertEquals(currentAccount.getBalance(), 40);
    }

}
