package com.eurotech.tests.day01_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args) {

        //target javadaki out klasörüne karsilik geliyor

        WebDriverManager.chromedriver().setup();//->bonigarciadan
        //new ChromeDriver()->will open chrome browser
        WebDriver driver = new ChromeDriver(); //poly -> selenyumdan geliyor
        driver.get("http://eurotech.study/");

        /*WebDriverManager.edgedriver().setup();
        WebDriver driver1 = new EdgeDriver();
        driver1.get("http://eurotech.study/");*/

        /*WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://eurotech.study/");*/

}
}
