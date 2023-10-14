package com.eurotech.tests.day09_typeOfWebElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
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
    public void findElementsFormula() {
        driver.get("https://the-internet.herokuapp.com/");
        //save our elements inside the list
        List<WebElement> menuList = driver.findElements(By.xpath("//a[text()='A/B Testing']/../../li"));
        // get size // return the size of the elements
        System.out.println("menuList.size() = " + menuList.size()); // menuList.size() = 44

        int expectedSize=44;
        int actualSize= menuList.size();

        Assert.assertEquals(actualSize,expectedSize,"Verify that menu size is 44");

        System.out.println("menuList.get(0).getText() = " + menuList.get(0).getText());
        //element not clickable
        //menuList.get(0).click();

        for (WebElement element : menuList) {
            System.out.println("webElement.getText() = " + element.getText());
        }
    }

    @Test
    public void test2() {
        /* Class Task
          go to the https://demoqa.com/elements url
          and verify that 9 elements are there
         */

        driver.get("https://demoqa.com/elements");
        List<WebElement> menuList = driver.findElements(By.xpath("//span[text()='Text Box']/../../li"));
        System.out.println("menuList.size() = " + menuList.size());

        int expectedSize=9;
        int actualSize= menuList.size();
        Assert.assertEquals(actualSize,expectedSize,"Verify that menu size is 9");
        for (WebElement element : menuList) {
            System.out.println("element.getText() = " + element.getText());
            Assert.assertTrue(element.isDisplayed()); //selenium will check all elements list
        }

    }
}
