package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import services.BankAccount;

public class BankAccountDataProviderTest {

    @DataProvider(name = "depositData", parallel = true)
    public Object[][] depositData() {

        return new Object[][] {
            {100, 50, 150},
            {200, 100, 300},
            {500, 250, 750},
            {1000, 500, 1500}
        };
    }

    @Test(dataProvider = "depositData")
    public void depositShouldIncreaseBalance(
            int openingBalance,
            int depositAmount,
            int expectedBalance) {

        BankAccount account = new BankAccount(openingBalance);

        account.deposit(depositAmount);

        System.out.println(
                "Opening Balance: " + openingBalance
                + " Deposit: " + depositAmount
                + " Thread: " + Thread.currentThread().getId());

        Assert.assertEquals(account.getBalance(), expectedBalance);
    }
}