package com.eurotech.tests.day08_typeOfWebelements1;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {
    @Test

    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox2 = driver.findElement(By.xpath("//form/input[2]"));
        WebElement checkBox1 = driver.findElement(By.xpath("//form/input[1]"));

        Assert.assertTrue(checkBox2.isSelected(),"verifyy that the checkBox2 is selected");
        Assert.assertFalse(checkBox1.isSelected(),"verifyy that the checkBox1 is not selected");

        Thread.sleep(1000);
        checkBox1.click();
        Thread.sleep(1000);
        checkBox2.click();

        Thread.sleep(1000);
        Assert.assertFalse(checkBox2.isSelected());
        Assert.assertTrue(checkBox1.isSelected());

        Thread.sleep(1000);
        driver.close();

    }
    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().fullscreen();

        WebElement sports = driver.findElement(By.id("hobbies-checkbox-1"));
        WebElement reading = driver.findElement(By.id("hobbies-checkbox-2"));
        WebElement music = driver.findElement(By.id("hobbies-checkbox-3"));

        Assert.assertFalse(sports.isSelected());
        Assert.assertFalse(reading.isSelected());
        Assert.assertFalse(music.isSelected());

        // Class Task
        // complete the task
        // click all the checkboxes
        // then assert that is selected or not

        WebElement sportsCheck = driver.findElement(By.cssSelector("[for='hobbies-checkbox-1']"));
        Thread.sleep(1000);
        sportsCheck.click();
        Thread.sleep(1000);
        Assert.assertTrue(sports.isSelected());
        Thread.sleep(1000);

        WebElement readingCheck = driver.findElement(By.cssSelector("[for='hobbies-checkbox-2']"));
        readingCheck.click();
        Thread.sleep(1000 );
        Assert.assertTrue(reading.isSelected());
        Thread.sleep(1000);

        WebElement musicCheck = driver.findElement(By.cssSelector("[for='hobbies-checkbox-3']"));
        musicCheck.click();
        Thread.sleep(1000);
        Assert.assertTrue(music.isSelected());
        Thread.sleep(1000);
        driver.close();


    }
}
