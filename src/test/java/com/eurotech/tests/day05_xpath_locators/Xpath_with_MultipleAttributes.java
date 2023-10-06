package com.eurotech.tests.day05_xpath_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_with_MultipleAttributes {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        driver.findElement(By.xpath("//*[@*='rcc-confirm-button']")).click();
        //multiple attribute 1. way
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@type='email'][@name='email']"));
        emailInputBox.sendKeys("eurotech@gmail.com");
        //multiple attribute with and 2. way
        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@name='password' and @type='password']"));
        passwordInputBox.sendKeys("Test12345!");
        //multiple attribute with or 3. way
        driver.findElement(By.xpath("//input[@type='submit' or @id='value2']")).click();

        Thread.sleep(2000);
        driver.close();
    }
}
