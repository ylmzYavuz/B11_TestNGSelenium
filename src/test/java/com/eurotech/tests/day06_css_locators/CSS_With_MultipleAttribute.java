package com.eurotech.tests.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CSS_With_MultipleAttribute {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        //Multiple attribute with xpath
        String expathText = driver.findElement(By.xpath("//p[@class='lead'][@id='loginpage-p1']")).getText();
        System.out.println("expathText = " + expathText);

        //Multiple attribute with CSS Selector with TagName
        String cssText1 = driver.findElement(By.cssSelector("p[class='lead'][id='loginpage-p1']")).getText();
        System.out.println("cssText1 = " + cssText1);

        //multiple attribute with CSS Selector without TagName
        String cssText2 = driver.findElement(By.cssSelector("[class='lead'][id='loginpage-p1']")).getText();
        System.out.println("cssText2 = " + cssText2);
        Thread.sleep(2000);
        driver.close();
    }
}
