package com.eurotech.tests.day10_typeOfWebElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
        driver.quit();
    }

    @Test
    public void twoWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        WebElement click_Here = driver.findElement(By.linkText("Click Here"));
        click_Here.click();
        Thread.sleep(1000);
        String titleAfterClick = driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);

        String currentTab= driver.getWindowHandle();
        System.out.println("currentTab = " + currentTab);
        //1CC495AA1E1847C80678F3C7E26A81DC
        //B8A2DF50E7582F625F0873A2E1F416ED

        Set<String> windowHandles= driver.getWindowHandles();// NO DUPLICATE
        // first and most important thing ;
        // HashSet is a collection of an items where every item is unique!!!
        for (String tab : windowHandles) {
            System.out.println("tab = " + tab);
            if (!tab.equals(currentTab)){
                driver.switchTo().window(tab);
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

    @Test
    public void multipleWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        WebElement click_Here = driver.findElement(By.linkText("Click Here"));
        click_Here.click();
        click_Here.click();
        click_Here.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
            //System.out.println("driver.getTitle() = " + driver.getTitle());
//            if (driver.getTitle().equals("New Window")){
//                System.out.println("driver.getTitle() = " + driver.getTitle());
//                System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
//            }
            if (driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/windows/new")){
                System.out.println("driver.getTitle() = " + driver.getTitle());
                System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
                break;
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
}
