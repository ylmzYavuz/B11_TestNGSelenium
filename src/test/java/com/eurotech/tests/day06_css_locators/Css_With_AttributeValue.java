package com.eurotech.tests.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_With_AttributeValue {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        //CSS Selector with Attribute&Value --->x[attribute='value']
        WebElement userEmail = driver.findElement(By.cssSelector("[type='email']"));
        userEmail.sendKeys("batch11test@gmail.com");

        //CSS Selector with TagName and Attribute&Value --> TagName[attribute='value']
        WebElement userPassword= driver.findElement(By.cssSelector("input[type='password']"));
        userPassword.sendKeys("Yilmaz.1234");

        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();

        Thread.sleep(2000);
        driver.close();
    }
}
