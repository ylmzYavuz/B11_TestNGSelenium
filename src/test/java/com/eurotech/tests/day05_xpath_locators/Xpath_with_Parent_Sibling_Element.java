package com.eurotech.tests.day05_xpath_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_with_Parent_Sibling_Element {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        //parent element
        WebElement elementText = driver.findElement(By.xpath("//i[@id='loginpage-singin-icon']/parent::p"));
        // 2. way //i[@id='loginpage-singin-icon']/parent::*
        // 3. way //i[@id='loginpage-singin-icon']/..
        System.out.println("elementText.getText() = " + elementText.getText());
        //sibling element
        //following sibling
        WebElement titleText = driver.findElement(By.xpath("//p[@id='loginpage-p1']/following-sibling::p"));
        System.out.println("titleText.getText() = " + titleText.getText());
        //preceding-sibling
        WebElement elementText2 = driver.findElement(By.xpath("//p[@class='my-1']/preceding-sibling::p"));
        System.out.println("elementText2.getText() = " + elementText2.getText());


        Thread.sleep(2000);
        driver.close();
    }
}
