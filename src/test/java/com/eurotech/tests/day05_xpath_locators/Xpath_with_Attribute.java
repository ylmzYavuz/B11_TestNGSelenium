package com.eurotech.tests.day05_xpath_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_with_Attribute {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.xpath("//*[@*='rcc-confirm-button']")).click();

        //xpath with tagName and attribute and value
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@id='loginpage-input-email']"));
        emailInputBox.sendKeys("eurotech@gmail.com");

        //xpath with tagName/* and attribute and value
        WebElement passwordInputBox = driver.findElement(By.xpath("//*[@id='loginpage-form-pw-input']"));
        passwordInputBox.sendKeys("Test12345!");

        //xpath with tagName/* and attribute/* and value
        WebElement loginBtn= driver.findElement(By.xpath("//*[@*='loginpage-form-btn']"));
        loginBtn.click();


        Thread.sleep(2000);
        driver.close();
    }
}
