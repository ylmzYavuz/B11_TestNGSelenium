package com.eurotech.tests.day10_typeOfWebElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void iframe() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        //How to switch to iframe
        //1st way: switch to frame by using ID or name
        driver.switchTo().frame("mce_0_ifr"); // we used ID attributes value to switch to iframe

        Thread.sleep(1000);
        WebElement textArea = driver.findElement(By.id("tinymce"));
        textArea.clear();
        textArea.sendKeys("Batch11 loves Iframe");

        Thread.sleep(1000);
        //switching to parent frame or HTML structure
        driver.switchTo().parentFrame();

        //2nd way: switch to frame by index
        driver.switchTo().frame(0);
        textArea.clear();
        Thread.sleep(1000);
        textArea.sendKeys("Batch11 loves Iframe very much");

        //switching to parent frame or HTML structure again
        driver.switchTo().parentFrame();

        //3rd way: switch to frame by using webElement
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        Thread.sleep(1000);
        textArea.clear();
        Thread.sleep(1000);
        textArea.sendKeys("Batch11 hates iframes");
    }

    @Test
    public void nestedIframes() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        //switch to frame by name --> Top Frame
        driver.switchTo().frame("frame-top");
        //switch to frame by index --> Middle Frame inside Top Frame
        driver.switchTo().frame(1);
        WebElement middleFrameText = driver.findElement(By.id("content"));
        System.out.println("middleFrameText.getText() = " + middleFrameText.getText());
        Assert.assertEquals(middleFrameText.getText(),"MIDDLE");
        //switch to parent frame
        driver.switchTo().parentFrame();
        //switch to Right frame with name
        driver.switchTo().frame("frame-right");
        WebElement rightFrameText = driver.findElement(By.tagName("body"));
        System.out.println("rightFrameText.getText() = " + rightFrameText.getText());
        Assert.assertEquals(rightFrameText.getText(),"RIGHT");

        //switching to first starting point - First HTML structure
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(),"BOTTOM");

        //Your task:
        //Switch to left frame and get text
    }
}
