package com.eurotech.tests.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Css_With_ParentToChild {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        //Parent to Child with Xpath
        String xpathText = driver.findElement(By.xpath("//section/p")).getText();
        System.out.println("xpathText = " + xpathText);

        //Parent to Child with CSS Selector
        String cssText= driver.findElement(By.cssSelector("section>p")).getText();
        System.out.println("cssText = " + cssText);

        //Parent to Child with CSS Selector 2nd Way --> body div section p
        String cssText2= driver.findElement(By.cssSelector("body section p")).getText();
        System.out.println("cssText2 = " + cssText2);

        // We can NOT go from Child to Parent by CSS Selector
        // We can NOT use INDEX by CSS Selector

        driver.close();
    }
}