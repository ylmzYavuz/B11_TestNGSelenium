package com.eurotech.tests.day10_typeOfWebElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
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

public class PopUpsAndAlerts {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        wait = new WebDriverWait(driver,15);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void popUpHTML() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=b656a");

        //click confirm button
        driver.findElement(By.xpath("(//span[text()='Confirm'])[1]")).click();
                                                // //span[.='Confirm'] --> 1 of 1-this also locates

        //click yes button
        driver.findElement(By.xpath("(//span[text()='Yes'])[2]")).click();

        /**
         *** NoAlertPresentException: no such alert
        Alert alert = driver.switchTo().alert();

        Thread.sleep(1000);
        alert.accept();
         *** NoAlertPresentException: no such alert
        */
        //verify confirm message
        String expectedMessage="You have accepted";
        Thread.sleep(1000 );
        WebElement actualMessage= driver.findElement(By.xpath("//p[text()='You have accepted']"));
        Assert.assertEquals(actualMessage.getText(),expectedMessage);
    }
    /** HOMEWORK TASK 1
     * For the above test
     * Verify all results are as expected for the JavaScript alerts
     */
    @Test
    public void jsAlerts() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        Thread.sleep(1000);
        //click for JS Confirm
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        //switch to JS Alert
        Alert alert = driver.switchTo().alert();

        Thread.sleep(1000);
        alert.accept();

        String expectedText = "You successfully clicked an alert";
        WebElement actualText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(actualText.getText(),expectedText);

        //Click for JS Confirm
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        Thread.sleep(1000);
        alert.accept();
        Thread.sleep(1000);

        String expectedText1 = "You clicked: Ok";
        WebElement actualText1 = driver.findElement(By.xpath("//p[text()='You clicked: Ok']"));
        Assert.assertEquals(actualText1.getText(),expectedText1);


        //Click for JS Prompt
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        alert.sendKeys("Eurotech Batch11 is here");
        System.out.println("alert.getText() = " + alert.getText());
        Thread.sleep(4000);
        alert.accept();

        String expectedText2 = "You entered: Eurotech Batch11 is here";
        WebElement actualText2 = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(actualText2.getText(),expectedText2);
    }

    /** HOMEWORK TASK 2
     * Go to https://demoqa.com/alerts
     * Practice with all JavaScript Alerts
     * Verify all results are as expected for the JavaScript alerts
     */
    @Test

    public void task2() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.cssSelector("#alertButton")).click();
        Alert alert = driver.switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        driver.findElement(By.cssSelector("#timerAlertButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert();
        alert.accept();
        WebElement element = driver.findElement(By.xpath("(//div/span)[16]"));
        Assert.assertEquals(element.getText(),"You selected Ok");


        driver.findElement(By.id("promtButton")).click();
        alert.sendKeys("B11 is here");
        alert.accept();
        WebElement result = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(result.getText(),"You entered B11 is here");

    }
}
