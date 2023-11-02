package com.eurotech.tests.day19_review_and_xmlRunner;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StaleElement extends TestBase {

    @Test
    public void t_staleProblem() {
        driver.get("https://freecrm.com/");
        BrowserUtils.waitFor(2);
        WebElement loginBtn = driver.findElement(By.xpath("//span[text()='Log In']"));
        loginBtn.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("email@gmail.com");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("Test1234");
        driver.navigate().refresh();
        BrowserUtils.waitFor(2);
        emailInput.sendKeys("email@gmail.com");
        //StaleElementReferenceException: stale element reference: stale element not found

    }
    @Test
    public void t_staleFix() {
        driver.get("https://freecrm.com/");
        BrowserUtils.waitFor(2);
        WebElement loginBtn = driver.findElement(By.xpath("//span[text()='Log In']"));
        loginBtn.click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("email@gmail.com");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("Test1234");
        driver.navigate().refresh();
        BrowserUtils.waitFor(2);

        try {
            emailInput.sendKeys("email@gmail.com");
        }catch (StaleElementReferenceException e){
            emailInput = driver.findElement(By.name("email"));
            emailInput.sendKeys("email@gmail.com");
            passwordInput = driver.findElement(By.name("password"));
            passwordInput.sendKeys("Test1234");
        }
        //StaleElementReferenceException: stale element reference: stale element not found
    }
}
