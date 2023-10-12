package com.eurotech.tests.day07_testNG;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {
    @BeforeMethod
    public void setUp() {
        System.out.println("Open Browser");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Close Browser");
    }

    @Test
    public void test1() {

        System.out.println("First annotations");
        Assert.assertEquals("Title", "Title");
        System.out.println("Second assertion");
        Assert.assertEquals("url", "url");

    }

    @Test
    public void test2() {
        System.out.println("test 2");
        Assert.assertEquals("test2", "test2");
    }

    @Test
    public void test3() {
        String expectedTitle = "Euro";
        String actualTitle = "Eurotech";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle));
        //Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test

    public void test4() {
        // verify that email contains "@"
        String email = "eurotechgmail.com";

       /* if (email.contains("@")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }*/

        Assert.assertTrue(email.contains("@"));
    }

    @Test

    public void test5() {
        //Assert.assertFalse(1>0,"Verify that 1 is great than 0");
        Assert.assertFalse(0>1,"Verify that 1 is great than 0");
    }
    @Test

    public void test6() {
        Assert.assertNotEquals("1","one");
    }
}
