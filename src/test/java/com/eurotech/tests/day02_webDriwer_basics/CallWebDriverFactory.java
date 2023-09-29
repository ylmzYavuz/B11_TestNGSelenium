package com.eurotech.tests.day02_webDriwer_basics;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory  {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("EDGE");

        driver.get("https://www.eurotechstudy.com");

        Thread.sleep(2000);

        driver.close();

        /**
         * Class Task
         * go to devex website --> http://eurotech.study/
         * expected title = DevEx
         * get title and verify that title is DevEx
         * then close browser
         */

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/");

        String expectedTitle = "DevEx";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        Thread.sleep(1000);

        driver.close();

    }
}
