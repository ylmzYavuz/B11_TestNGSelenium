package com.eurotech.tests.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_With_StartsWith {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        // Xpath with startsWith --> //input[starts-with(@placeholder,'Email')]
        //CSS Selector with StartsWith --> tagName[attribute^='value']
        WebElement userEmail = driver.findElement(By.cssSelector("input[placeholder^='Email']"));
        userEmail.sendKeys("eurotech@gmail.com");

        //CSS Selector with StartsWith --> [attribute^='value']
        WebElement userPassword= driver.findElement(By.cssSelector("[placeholder^='Pass']"));
        userPassword.sendKeys("Test12345!");

        driver.findElement(By.cssSelector("input[class^='btn']")).click();

        Thread.sleep(1000);
        driver.close();
    }
}