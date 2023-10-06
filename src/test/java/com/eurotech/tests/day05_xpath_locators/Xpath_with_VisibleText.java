package com.eurotech.tests.day05_xpath_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_with_VisibleText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        //Locating element with known visible text
        // 1. way
        WebElement textElement = driver.findElement(By.xpath("//p[text()=' Sign Into Your Account']"));
        System.out.println("textElement.getText() = " + textElement.getText());
        //2.way
        WebElement titleText= driver.findElement(By.xpath("//*[.='Sign In']"));
        System.out.println("titleText.getText() = " + titleText.getText());

        Thread.sleep(2000);
        driver.close();
    }
}
