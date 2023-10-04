package com.eurotech.tests.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        driver.findElement(By.id("rcc-confirm-button")).click();

        String email = "eurotech@gmail.com";
        Thread.sleep(2000);
        WebElement emailInputBox = driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys(email);

        //
        String value = emailInputBox.getAttribute("value");
        System.out.println("value = " + value);
        System.out.println("emailInputBox.getAttribute(\"placeHolder\") = " + emailInputBox.getAttribute("placeHolder"));
        System.out.println("emailInputBox.getAttribute(\"name\") = " + emailInputBox.getAttribute("name"));
        System.out.println("emailInputBox.getAttribute(\"type\") = " + emailInputBox.getAttribute("type"));

        Thread.sleep(2000);
        driver.close();
    }
}
