package com.eurotech.tests.day02_webDriwer_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        /**
         Class Task
         go to google
         go to facebook
         turn back
         you should see google again
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        Thread.sleep(2000);

        //we navigated to another website with another selenium method
        //driver.get("https://www.facebook.com");
        driver.navigate().to("https://www.facebook.com");

        Thread.sleep(2000);

        //navigate back to google page
        driver.navigate().back();

        Thread.sleep(2000);

        //navigate to forward - go back to back
        driver.navigate().forward();

        Thread.sleep(2000);

        //let' refresh the page
        driver.navigate().refresh();
    }
}
