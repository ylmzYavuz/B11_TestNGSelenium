package com.eurotech.tests.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_With_EndsWith {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        // We can NOT use ends-with method with Xpath

        //CSS Selector with EndsWith --> tagName[attribute$='value']
        WebElement userEmail = driver.findElement(By.cssSelector("input[placeholder$='Address']"));
        userEmail.sendKeys("eurotech@gmail.com");

        //CSS Selector with EndsWith --> [attribute$='value']
        WebElement userPassword= driver.findElement(By.cssSelector("[id$='pw-input']"));
        userPassword.sendKeys("Test12345!");

        driver.findElement(By.cssSelector("[id$='btn']")).click();

        Thread.sleep(1000);
        driver.close();
    }
}