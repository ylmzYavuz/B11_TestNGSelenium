package com.eurotech.tests.day05_xpath_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Absolute_Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        //Absolute Locator ex
        WebElement emailInputBox = driver.findElement(By.xpath("/html/body/div/section/form/div[1]/input"));
        emailInputBox.sendKeys("eurotech@gmail.com");

        Thread.sleep(2000);
        driver.close();
    }
}
