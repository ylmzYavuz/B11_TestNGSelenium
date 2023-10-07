package com.eurotech.tests.day05_xpath_locators.homework;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task_3 {

    public static void main(String[] args) throws InterruptedException {
        /** Class Task
         * go to the amazon webpage
         * write "selenium" to search box
         * verify that the result of the search
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchInputBox = driver.findElement(By.xpath("//input[@type='text']"));
        searchInputBox.sendKeys("selenium");

        driver.findElement(By.xpath("//input[@id='nav-search-submit-button'][@type='submit']")).click();

        String expectedTitle = "selenium";
        WebElement title = driver.findElement(By.xpath("//div/span[@class='a-color-state a-text-bold']"));
        String actualTitle = title.getText();
        System.out.println("actualTitle = " + actualTitle);

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        Thread.sleep(2000);
        driver.close();

    }
}
