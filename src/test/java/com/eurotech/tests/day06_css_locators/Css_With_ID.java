package com.eurotech.tests.day06_css_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_With_ID {

        public static void main(String[] args) throws InterruptedException {
            WebDriver driver= WebDriverFactory.getDriver("chrome");
            driver.get("http://eurotech.study/login");

            //Accept cookies by CSS Selector with ID --> #valueOfID
            driver.findElement(By.cssSelector("#rcc-confirm-button")).click(); //lazy way

            //driver.findElement(By.id("rcc-confirm-butto")).click();
            //NoSuchElementException:Unable to locate element: {"method":"css selector","selector":"#rcc\-confirm\-butto"}
            // That means Selenium works with cssSelector at the background

            //CSS Selector with ID
            WebElement userEmail = driver.findElement(By.cssSelector("#loginpage-input-email"));
            userEmail.sendKeys("CSS Selector With ID");

            //CSS Selector with TagName and ID
            WebElement userPassword= driver.findElement(By.cssSelector("input#loginpage-form-pw-input"));
            userPassword.sendKeys("CSS Selector With TagName and ID");

            Thread.sleep(1000);
            driver.close();
        }
    }