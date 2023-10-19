package com.eurotech.tests.day12_actions_jse_fileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsTest {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test

    public void hoverOver() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img1 = driver.findElement(By.xpath("(//img)[2]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(img1).perform();

        WebElement viewProfile1 = driver.findElement(By.linkText("View profile"));
        Assert.assertTrue(viewProfile1.isDisplayed(),"verify that view profile text is displayed");

        /**  Hover class Task
         *      go to https://the-internet.herokuapp.com/hovers url
         *      and get "view profile" elements' text (all of them)
         *      and verify element is displayed (one by one)
         *
         *      hint: Use list and for loop
         */
    }
    @Test

    public void dragAndDrop() {
        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(source,target).perform();

        WebElement verifyMessage= driver.findElement(By.xpath("//p[text()='Dropped!']"));
        //System.out.println("verifyMessage = " + verifyMessage);

        //1st way for assertion
        //Assert.assertEquals(verifyMessage.getText(),"Dropped!");

        //2nd way for assertion
        Assert.assertTrue(verifyMessage.isDisplayed());
    }
    @Test

    public void dragAndDrop2() {
        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        //actions.dragAndDrop(source,target).perform();
        //actions.moveToElement(source).clickAndHold().moveToElement(target).release().perform();
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(3000).release().perform();

        WebElement verifyMessage= driver.findElement(By.xpath("//p[text()='Dropped!']"));
        //System.out.println("verifyMessage = " + verifyMessage);

        //1st way for assertion
        //Assert.assertEquals(verifyMessage.getText(),"Dropped!");

        //2nd way for assertion
        Assert.assertTrue(verifyMessage.isDisplayed());
    }
}
