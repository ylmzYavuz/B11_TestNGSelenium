package com.eurotech.tests.day13_webTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicWebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test

    public void dummy() {
        driver.get("https://demoqa.com/webtables");
        WebElement aldenName = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[2]/div/div[1]"));
        System.out.println("aldenName.getText() = " + aldenName.getText());

        WebElement lastName = driver.findElement(By.xpath("//div[text()='Last Name']"));
        lastName.click();

        /*System.out.println("aldenName.getText() = " + aldenName.getText());
        Assert.assertEquals(aldenName.getText(),"Alden");*/

        String name="Alden";

        WebElement actualName = driver.findElement(By.xpath("//div[@class='rt-table']//div[.='"+name+"']"));
        System.out.println("actualName.getText() = " + actualName.getText());
        Assert.assertEquals(actualName.getText(),name);


    }
    @Test
    public void testDynamic() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        WebElement firstName = driver.findElement(By.xpath("//div[@class='rt-table']//div[.='Kierra']"));
        WebElement lastname= driver.findElement(By.xpath("//div[text()='Last Name']"));
        System.out.println("firstName.getText() = " + firstName.getText());
        lastname.click();

        Thread.sleep(2000);
        System.out.println("after click firstName.getText() = " + firstName.getText());
    }
}
