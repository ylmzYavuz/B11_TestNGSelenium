package com.eurotech.tests.day08_typeOfWebelements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");


        WebElement vegetablesRadio= driver.findElement(By.xpath("//div[text()='Vegetables']/../input"));
        //   //div[text()='Vegetables']/preceding-sibling::input

        System.out.println("vegetablesRadio.isSelected() = " + vegetablesRadio.isSelected());
        Assert.assertTrue(vegetablesRadio.isSelected(),"Verify that the vegetables radio is selected");

        WebElement legumesRadio= driver.findElement(By.xpath("//div[text()='Legumes']/../input"));
        Assert.assertFalse(legumesRadio.isSelected(),"Verify that the legumes radio is NOT selected");

        Thread.sleep(1000);
        WebElement legumes= driver.findElement(By.xpath("//div[text()='Legumes']/../div[1]"));
        legumes.click();
        Thread.sleep(1000);
        Assert.assertTrue(legumesRadio.isSelected(),"Verify that the legumes radio is selected");
        Assert.assertFalse(vegetablesRadio.isSelected(),"Verify that the vegetables radio is NOT selected");
        driver.close();
    }
}