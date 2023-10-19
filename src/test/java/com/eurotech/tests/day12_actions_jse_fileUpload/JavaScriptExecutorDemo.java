package com.eurotech.tests.day12_actions_jse_fileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo {

    WebDriver driver;
    JavascriptExecutor jse;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        jse = (JavascriptExecutor) driver;

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test

    public void clickWithJS() {
        driver.get("https://www.amazon.co.uk/");
        driver.navigate().refresh();
        driver.findElement(By.id("a-autoid-0")).click();
        WebElement germany = driver.findElement(By.linkText("Germany"));
        // ask to google-> how to click with js executor
        // response:stackoverflow
        //JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", germany);
    }
    @Test

    public void typeWithJS() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputBox=driver.findElement(By.cssSelector("[type='text']"));
        String text = "Eurotech B11 is learning JS Executer";
        Thread.sleep(2000);
        // ask to google-> how to sendKeys with js executor
        // response:stackoverflow
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);

    }
    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("https://www.amazon.co.uk/");
        driver.navigate().refresh();
        driver.findElement(By.id("sp-cc-accept")).click();
        WebElement germany = driver.findElement(By.linkText("Germany"));
        Thread.sleep(1000);
        // ask to google-> how to scroll down and up with js executor
        // response: stackoverflow
        //jse.executeScript("window.scrollBy(0,1000)");

        for (int i = 0; i < 8; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,500)");
        }
        for (int i = 0; i < 8; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-500)");
        }
    }
    @Test
    public void scrollToElement() throws InterruptedException {
        driver.get("https://www.amazon.co.uk/");
        driver.navigate().refresh();
        driver.findElement(By.id("sp-cc-accept")).click();
        WebElement germany= driver.findElement(By.linkText("Germany"));
        Thread.sleep(1000);
        // ask to google-> how to scroll to element with js executor
        // response: stackoverflow
        jse.executeScript("arguments[0].scrollIntoView(true);", germany);
    }
}
