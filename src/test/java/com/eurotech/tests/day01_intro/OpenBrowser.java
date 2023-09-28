package com.eurotech.tests.day01_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        //new ChromeDriver()->will open chrome browsr
        WebDriver driver = new ChromeDriver(); //poly
        driver.get("http://eurotech.study/");

        /*WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://eurotech.study/");*/

}
}
