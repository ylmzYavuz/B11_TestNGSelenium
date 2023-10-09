package com.eurotech.tests.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Css_With_Contains {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        //Contains with xpath
        String xpathText = driver.findElement(By.xpath("//p[contains(@id,'form-warn-')]")).getText();
        System.out.println("xpathText = " + xpathText);

        //Contains With CSS Selector
        String cssText = driver.findElement(By.cssSelector("p[id*='form-warn-']")).getText();
        System.out.println("cssText = " + cssText);

        Thread.sleep(1000);
        driver.close();
    }
}
