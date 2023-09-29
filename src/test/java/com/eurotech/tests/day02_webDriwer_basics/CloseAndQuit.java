package com.eurotech.tests.day02_webDriwer_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://eurotech.study/");

        Thread.sleep(1000);

        driver.close(); //closses current tab gecerli tabi kapatir genelde tek bir sekmede
        //calisicaz onun icin bunu daha sik kullanicaz normalde en son yazilir

        driver = new ChromeDriver();

        driver.get("https://www.eurotechstudy.com");

        Thread.sleep(1000);

        driver.quit();//closses all tabs


    }
}
