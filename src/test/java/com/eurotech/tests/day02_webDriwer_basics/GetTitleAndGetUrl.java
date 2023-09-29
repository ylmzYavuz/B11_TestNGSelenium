package com.eurotech.tests.day02_webDriwer_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {


    //Task open chrome and navigate to https://www.eurotechstudy.com
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.get("https://www.eurotechstudy.com");

        driver.get("https://www.facebook.com");

        //Geing tittle with selenium method
        String title = driver.getTitle();
        System.out.println("title = " + title);//Facebook – Anmelden oder Registrieren

        String expectedTitle = "Facebook – Anmelden oder Registrieren";
        String actualTitle = driver.getTitle();
        System.out.println("expectedTitle.equals(actualTitle) = " + expectedTitle.equals(actualTitle));

        if (expectedTitle.equals(actualTitle)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        // get the URL from browser
        String currentUrl = driver.getCurrentUrl(); //alt+enter
        System.out.println("currentUrl = " + currentUrl);

        //get the source of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);
    }
}
