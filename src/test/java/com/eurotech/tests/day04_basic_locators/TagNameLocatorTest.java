package com.eurotech.tests.day04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        Thread.sleep(1000);//-> runtime in calismasini durdur java dan geliyor
        //Layz way
        driver.findElement(By.id("rcc-confirm-button")).click();

        Thread.sleep(1000);
        WebElement inputEmail = driver.findElement(By.name("email"));
        inputEmail.sendKeys("eurotech@gmail.com");

        Thread.sleep(1000);
        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.sendKeys("Test12345!");

        Thread.sleep(1000);

        driver.findElement(By.id("loginpage-form-btn")).click();

        Thread.sleep(1000);
        WebElement eperienceCredentials = driver.findElement(By.tagName("h2"));

        System.out.println("eperienceCredentials = " + eperienceCredentials);//[[ChromeDriver: chrome on WINDOWS (5546c324c52bde034f0091b5d0c681eb)] -> tag name: h2]

        System.out.println("eperienceCredentials.getText() = " + eperienceCredentials.getText());//Experience Credentials

        driver.close();

    }
}
