package com.eurotech.tests.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLChanged {

    public static void main(String[] args) throws InterruptedException {

        /* /** Class Task
         * open the chrome browser
         * go to http://eurotech.study/login
         * enter email as eurotech@gmail.com
         * enter password as Test12345!
         * click login button
         * verify that url has changed
         */

        String email = "eurotech@gmail.com";
        String password = "Test12345!";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        //Lazy way -> click unterstandBtn
        //driver.findElement(By.id("rcc-confirm-button")).click();

        WebElement emailInputBox = driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys(email);

        WebElement passwordInputBox = driver.findElement(By.id("loginpage-form-pw-input"));
        passwordInputBox.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();

        Thread.sleep(2000);

        String expextedUrl = "http://eurotech.study/dashboard";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);

        if (expextedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        Thread.sleep(2000);

        driver.close();
    }
}
