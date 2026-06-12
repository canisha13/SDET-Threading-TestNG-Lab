package tests;

import org.testng.annotations.Test;

public class ThreadInfoTest {

    @Test
    public void testOne() throws InterruptedException {

        System.out.println(
                "Test One running on thread: "
                        + Thread.currentThread().getId());

        Thread.sleep(2000);
    }

    @Test
    public void testTwo() throws InterruptedException {

        System.out.println(
                "Test Two running on thread: "
                        + Thread.currentThread().getId());

        Thread.sleep(2000);
    }

    @Test
    public void testThree() throws InterruptedException {

        System.out.println(
                "Test Three running on thread: "
                        + Thread.currentThread().getId());

        Thread.sleep(2000);
    }

    @Test
    public void testFour() throws InterruptedException {

        System.out.println(
                "Test Four running on thread: "
                        + Thread.currentThread().getId());

        Thread.sleep(2000);
    }
}