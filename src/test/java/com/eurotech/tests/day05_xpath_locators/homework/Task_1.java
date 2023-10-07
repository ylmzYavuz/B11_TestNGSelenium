package com.eurotech.tests.day05_xpath_locators.homework;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task_1 {

    public static void main(String[] args) throws InterruptedException {

        /**
         * 1. Open Chrome browser
         2. Go to
         (https://the-internet.herokuapp.com/forgot_password) Links to an external site.
         3. Locate all the WebElements on the page using XPATH locator only
         a. “Forgot password” header
         b. “E-mail” text
         c. E-mail input box
         d. “Retrieve password” button
         4.Print text of a,b,d and put some email to c.*/

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement titleText1 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        System.out.println("titleText1.getText() = " + titleText1.getText());

        WebElement titleText2 = driver.findElement(By.xpath("//label[text()='E-mail']"));
        System.out.println("titleText2.getText() = " + titleText2.getText());

        WebElement emailInputBox = driver.findElement(By.xpath("//input[@*='email']"));
        emailInputBox.sendKeys("batch11@gmail.com");

        WebElement loginBtn = driver.findElement(By.xpath("//i[text()='Retrieve password']"));
        loginBtn.click();

        Thread.sleep(2000);
        driver.close();

    }
}
