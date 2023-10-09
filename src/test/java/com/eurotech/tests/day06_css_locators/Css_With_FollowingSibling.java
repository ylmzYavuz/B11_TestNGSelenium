package com.eurotech.tests.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Css_With_FollowingSibling {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        //Following Sibling with Xpath
        String xpathText = driver.findElement(By.xpath("//form[@class='form']/following-sibling::p")).getText();
        System.out.println("xpathText = " + xpathText);

        //Following Sibling with CSS Selector --> ~ Tilde Sign
        String cssText = driver.findElement(By.cssSelector("[class='form']~p")).getText();
        String cssText2 = driver.findElement(By.cssSelector("form~p")).getText();
        System.out.println("cssText = " + cssText);
        System.out.println("cssText2 = " + cssText2);
        driver.close();
    }
}
