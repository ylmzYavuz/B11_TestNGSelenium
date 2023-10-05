package com.eurotech.tests.day04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassnameLocatorTest {

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
        WebElement eperienceCredentialsText = driver.findElement(By.className("my-2"));
        System.out.println("eperienceCredentialsText.getText() = " + eperienceCredentialsText.getText());

        // Bad practice - We can NOT use classname locator when we have space inside class attribute's value
        //WebElement badPractice = driver.findElement(By.className("navbar bg-dark"));
        //System.out.println("badPractice.getText() = " + badPractice.getText());//NoSuchElementException
        driver.close();
    }
}
