package com.eurotech.tests.day05_xpath_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTask {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task
         *  go to the amazon webpage --> https://www.amazon.co.uk/
         *  write "selenium" to search box
         *  verify that the result of the search
         *  please use xpath locator
         */
        String product = "java";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.co.uk/");

        driver.findElement(By.xpath("//input[@tabindex='1']")).click();

        Thread.sleep(1000);

        WebElement inputSearchBox = driver.findElement(By.xpath("//input[@type='text']"));
        inputSearchBox.sendKeys(product);

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Go']")).click(); //lazy way

        Thread.sleep(1000);

        String actualText = driver.findElement(By.xpath("//span[contains(text(),'results for')]/..")).getText();
        //System.out.println(actualText);

        if (actualText.contains(product)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        driver.close();
    }
}