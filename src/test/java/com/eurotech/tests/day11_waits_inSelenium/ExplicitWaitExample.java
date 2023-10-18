package com.eurotech.tests.day11_waits_inSelenium;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,15);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test

    public void explicitWaitTest1() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start>button")).click();

        WebDriverWait wait = new WebDriverWait(driver,15);

        WebElement hello = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        wait.until(ExpectedConditions.visibilityOf(hello));
        Assert.assertEquals(hello.getText(),"Hello World!");
    }
    @Test

    public void explicitWaitTest2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        //driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Eurotech B11 is Here");
        WebElement inputBox = driver.findElement(By.cssSelector("input[type='text']"));
        WebDriverWait wait = new WebDriverWait(driver,15);

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("Eurotech B11 is Here");

        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertEquals(message.getText(),"It's enabled!");
    }
}
