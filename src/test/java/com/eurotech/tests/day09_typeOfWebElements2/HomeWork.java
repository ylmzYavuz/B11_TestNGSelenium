package com.eurotech.tests.day09_typeOfWebElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork {
    /**
     Task 1
     //go to https://demoqa.com/select-menu
     // locate the "Select Title" web element
     // click on it
     // click on 'Mrs.'
     Task 2
     //go to https://demoqa.com/select-menu
     // locate the "Select Title" web element
     // click on it
     // get all options with findElements()
     */
    WebDriver driver;
    @BeforeMethod

    public void setUp() {
        driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().fullscreen();

    }
    @AfterMethod

    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }

    @Test
    /**Task 1
     //go to https://demoqa.com/select-menu
     // locate the "Select Title" web element
     // click on it
     // click on 'Mrs.'*/
    public void task1() {
     driver.get("https://demoqa.com/select-menu");
        List<WebElement> selectOptions = driver.findElements(By.xpath("//div[text()='Select Option']"));


    }
}
