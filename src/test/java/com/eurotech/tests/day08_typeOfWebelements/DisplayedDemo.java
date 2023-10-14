package com.eurotech.tests.day08_typeOfWebelements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test

    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();

        WebElement hello = driver.findElement(By.xpath("//*[.='Hello World!']"));
        //WebElement hello = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        System.out.println("hello.isDisplayed() = " + hello.isDisplayed());
        Assert.assertFalse(hello.isDisplayed());

        WebElement start = driver.findElement(By.cssSelector("div>button"));
        start.click();

        Thread.sleep(6000);
        Assert.assertTrue(hello.isDisplayed());
        Thread.sleep(1000);
        //driver.close();

    }
    @Test
    public void task() throws InterruptedException {
        /**
         * Class Task
         * go to https://the-internet.herokuapp.com/dynamic_loading/2
         * see Example 2: Element rendered after the fact -->click
         * Then do this task;
         *    verify that hello world is not displayed
         *    click start button
         *    verify that hello element is displayed
         *    and verify that "Hello World!" text is present
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.manage().window().fullscreen();

        WebElement text = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Thread.sleep(1000);
        Assert.assertFalse(text.isDisplayed());

        Thread.sleep(1000);
        WebElement startBtn = driver.findElement(By.cssSelector("div>button"));
        startBtn.click();
        Thread.sleep(5000);
        Assert.assertTrue(text.isDisplayed());


        Thread.sleep(2000);
        driver.close();
    }

}
