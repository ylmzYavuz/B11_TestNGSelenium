package com.eurotech.tests.day08_typeOfWebelements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {
    /**
     * What is disabled element?
     * Disable means :
     * U can NOT interact with the element
     * U can NOT click
     * or
     * U can NOT write something
     */
    @Test

    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement disabledElement = driver.findElement(By.cssSelector("[type='text']"));
        Assert.assertFalse(disabledElement.isEnabled(),"verify that the element is NOT enable OR is disabled");

        WebElement enableBtn = driver.findElement(By.cssSelector("#input-example>button"));
        enableBtn.click();

        Thread.sleep(4000);
        Assert.assertTrue(disabledElement.isEnabled(),"Verify that the element is enable now ");
        driver.close();
    }
}
