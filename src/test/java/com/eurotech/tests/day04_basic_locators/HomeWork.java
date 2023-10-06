package com.eurotech.tests.day04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeWork {
    public static void main(String[] args) {
        /** Class Task
         *  go to the url -  "https://www.browserstack.com/users/sign_up"
         *  maximize the window --> driver.manage().window().maximize();
         *  accept cookies if any,
         *  fill in the blanks with the faker class
         *  click "Term of service" checkbox
         *  and close the window
         *
         *  hint: u can use any locator you want
         *
         */

        Faker faker = new Faker();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_up");
        driver.manage().window().maximize();

        driver.findElement(By.id("accept-cookie-notification")).click();

        WebElement fullName = driver.findElement(By.id("user_full_name"));
        fullName.sendKeys(faker.name().fullName());

        WebElement emailLogin = driver.findElement(By.id("user_email_login"));
        emailLogin.sendKeys(faker.internet().emailAddress());

        WebElement userPassword = driver.findElement(By.id("user_password"));
        userPassword.sendKeys(faker.internet().password());

        driver.findElement(By.name("terms_and_conditions")).click();


        driver.close();


    }
}
