package com.eurotech.tests.day05_xpath_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_with_VisibleText_Partial {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        //->//*[contains(text(),'Account')]
        WebElement textElement = driver.findElement(By.xpath("//p[contains(text(),'Account')]"));
        System.out.println("textElement.getText() = " + textElement.getText());



        Thread.sleep(2000);
        driver.close();
    }
}
