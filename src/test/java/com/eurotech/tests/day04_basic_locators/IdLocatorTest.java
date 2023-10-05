package com.eurotech.tests.day04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {

    public static void main(String[] args) {

        Faker faker = new Faker();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");

        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys(faker.name().firstName());

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys(faker.internet().emailAddress());

        driver.close();
    }
}
