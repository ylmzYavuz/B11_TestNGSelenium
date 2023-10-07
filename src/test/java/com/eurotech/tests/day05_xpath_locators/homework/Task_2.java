package com.eurotech.tests.day05_xpath_locators.homework;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task_2 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Test case 1
         Go to Ebay
         enter search term as "java"
         click on search button
         print number of results*/

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.de/");

        WebElement searchBtn = driver.findElement(By.xpath("//*[@*='text'][@class='gh-tb ui-autocomplete-input']"));
        searchBtn.sendKeys("java");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit' and @class='btn btn-prim gh-spr']"));
        loginBtn.click();

        WebElement result = driver.findElement(By.xpath("(//h1/span)[1]"));
        System.out.println("result.getText() = " + result.getText());


        Thread.sleep(4000);

        /**Test case 2
         Go to Ebay
         search Selenium
         xpath Locator14click on search button
         verify title contains Selenium
         **/

        driver.get("https://www.ebay.de/");
        WebElement searchInputBox = driver.findElement(By.xpath("//input[starts-with(@placeholder,'Bei eBay finden')]"));
        searchInputBox.sendKeys("Selenium");

        WebElement elementSearch = driver.findElement(By.xpath("//input[contains(@type,'submit')]"));
        elementSearch.click();

        WebElement elementTitle = driver.findElement(By.xpath("(//*[@class='BOLD'])[5]"));
        String expectedTitle = "Selenium";
        String actualTitle = elementTitle.getText();

        Thread.sleep(2000);

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        Thread.sleep(4000);

         /**Test case 3
         Go to wikipedia.org (Links to an external site.)
         enter search term selenium webdriver
         click on search button
         click on search result Selenium (software)
         verify url ends with `Selenium_(software)'*/

        driver.get("https://www.wikipedia.org/");

        WebElement searchBtn1 = driver.findElement(By.xpath("//input[contains(@id,'searchInput')]"));
        searchBtn1.sendKeys("selenium webdriver");

        WebElement search = driver.findElement(By.xpath("(//button/i)[1]"));
        search.click();

        WebElement elementClick = driver.findElement(By.xpath("//span[text()='Selenium']"));
        elementClick.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl= "https://de.wikipedia.org/wiki/Selenium";

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        Thread.sleep(2000);
        driver.close();

    }
}
