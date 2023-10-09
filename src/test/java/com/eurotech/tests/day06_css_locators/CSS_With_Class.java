package com.eurotech.tests.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_With_Class {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        WebElement userEmail = driver.findElement(By.cssSelector("#loginpage-input-email"));
        userEmail.sendKeys("CSS Selector With ID");

        WebElement userPassword= driver.findElement(By.cssSelector("input#loginpage-form-pw-input"));
        userPassword.sendKeys("CSS Selector With TagName and ID");

        //CSS Selector With Class --> . --> .valueOfClass
        String warningText = driver.findElement(By.cssSelector(".my-1")).getText();
        System.out.println("warningText = " + warningText);

        //CSS Selector With TagName and Class --> TagName.valueOfClass
        //Bosluklar yerine . yazilip locate edebiliyoruz
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        driver.close();
    }
}