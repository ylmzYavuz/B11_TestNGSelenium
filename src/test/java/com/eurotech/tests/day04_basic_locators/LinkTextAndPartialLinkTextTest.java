package com.eurotech.tests.day04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialLinkTextTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        Thread.sleep(1000);
        WebElement example1Link = driver.findElement(By.linkText("Example 1: Element on page that is hidden"));
        example1Link.click();

        String actualText = driver.findElement(By.tagName("h4")).getText();
        String expectedText = "Example 1: Element on page that is hidden";

        if (actualText.equals(expectedText)){
            System.out.println("Test Part1 Passed");
        }else {
            System.out.println("Test Part1 Failed");
        }
        Thread.sleep(1000);
        driver.navigate().back();

        Thread.sleep(1000);
        WebElement example2Link = driver.findElement(By.partialLinkText("Example 2"));
        example2Link.click();

        String actualText2 = driver.findElement(By.tagName("h4")).getText();
        String expectedText2 = "Example 2: ";

        if (actualText2.contains(expectedText2)){
            System.out.println("Test Part1 Passed");
        }else {
            System.out.println("Test Part1 Failed");
        }

        driver.close();
    }
}
