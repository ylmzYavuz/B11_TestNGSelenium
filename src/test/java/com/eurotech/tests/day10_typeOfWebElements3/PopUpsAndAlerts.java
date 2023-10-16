package com.eurotech.tests.day10_typeOfWebElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpsAndAlerts {
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
        WebElement actualMessage= driver.findElement(By.xpath("//p[text()='You have accepted']"));
        Assert.assertEquals(actualMessage.getText(),expectedMessage);
    }

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
        Thread.sleep(1000);

        //Click for JS Confirm
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        Thread.sleep(1000);
        alert.dismiss();

        //Click for JS Prompt
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        alert.sendKeys("Eurotech Batch11 is here");
        System.out.println("alert.getText() = " + alert.getText());
        Thread.sleep(4000);
        alert.accept();

        /** HOMEWORK TASK 1
         * For the above test
         * Verify all results are as expected for the JavaScript alerts
         */
    }

    /** HOMEWORK TASK 2
     * Go to https://demoqa.com/alerts
     * Practice with all JavaScript Alerts
     * Verify all results are as expected for the JavaScript alerts
     */
}
