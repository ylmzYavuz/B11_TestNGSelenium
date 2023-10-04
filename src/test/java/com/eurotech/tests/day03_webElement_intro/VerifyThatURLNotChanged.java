package com.eurotech.tests.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLNotChanged {

    public static void main(String[] args) throws InterruptedException {

        /** Class Task
         * open the chrome browser
         * go to http://eurotech.study/login
         * enter email address
         * click login button
         * verify (dogrulamak) that url NOT changed
         */

        String email = "eurotech@gmail.com";
        WebDriver driver = WebDriverFactory.getDriver("CHROME");
        driver.get("http://eurotech.study/login");
        String expectedUrl = "http://eurotech.study/login";
        Thread.sleep(2000);

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        WebElement emailBox = driver.findElement(By.id("loginpage-input-email"));
        emailBox.sendKeys(email);

        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();

        //String expectedUrl = "http://eurotech.study/login";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        Thread.sleep(2000);

        driver.close();
    }
}
