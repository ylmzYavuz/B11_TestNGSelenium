package com.eurotech.tests.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task01 {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task
         * open the chrome browser
         * go to http://eurotech.study/login
         * enter email as eurotech@gmail.com
         * enter password as Test12345!
         * click login button
         * Verify login successfully
         * verify that Dashboard text is exist
         */
        String email = "eurotech@gmail.com";
        String password = "Test12345!";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        WebElement emailBox = driver.findElement(By.id("loginpage-input-email"));
        emailBox.sendKeys(email);

        WebElement passwordInputBox = driver.findElement(By.id("loginpage-form-pw-input"));
        passwordInputBox.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();

        Thread.sleep(2000);

        String expectedText = "Dashboard";//gercek projede requerment tan alicaz
        WebElement dashbord = driver.findElement(By.id("dashboard-h1"));
        System.out.println("dashbord.getText() = " + dashbord.getText());
        String actualText = dashbord.getText();

        if (expectedText.equals(actualText)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
