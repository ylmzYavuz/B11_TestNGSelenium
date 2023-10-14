package com.eurotech.tests.day07_testNG;


import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task02_FacebookTest {
    /*
    -open chrome browser
    -go to https://www.facebook.com/
    -enter fake username
    -enter fake password
    -click login button
    -verify not that login successfully
     */
    WebDriver driver;
    @BeforeMethod
    public  void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //driver.findElement(By.xpath("[value='1'][type='submit'][data-cookiebanner='accept_button']")).click();
    }

    @Test
    public void facebookLogin() {

        driver.get("https://www.facebook.com/");
        driver.manage().window().fullscreen();
        driver.findElement(By.id("email")).sendKeys("absc@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123456hj");
        driver.findElement(By.name("login")).click();

        String expectedMessage="Ist das dein Konto?";
        String actualMessage=driver.findElement(By.className("_9kpn")).getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage,"Verify that actual message is equal expected message");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
