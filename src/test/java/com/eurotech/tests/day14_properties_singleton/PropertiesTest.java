package com.eurotech.tests.day14_properties_singleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {
    @Test
    public void t1_properties() {
        String browser = ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);
        String url = ConfigurationReader.get("url");
        System.out.println("url = " + url);
    }
   @Test

    public void t2_openBrowserUsingConfigReader() throws InterruptedException {
       WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
       driver.get(ConfigurationReader.get("url"));
       driver.findElement(By.id("rcc-confirm-button")).click();
       driver.findElement(By.id("loginpage-input-email")).sendKeys(ConfigurationReader.get("emailStudent"));
       driver.findElement(By.id("loginpage-form-pw-input")).sendKeys(ConfigurationReader.get("passwordStudent")+ Keys.TAB+Keys.TAB+Keys.ENTER);//it goes sing up
                                                                                                                                                            //sing up a götürür
       Thread.sleep(2000);
       driver.close();
    }
    @Test

    public void t3_Singleton() {
        WebDriver driver1 = WebDriverFactory.getDriver("chrome");
        //driver1.get("https://www.amazon.co.uk/");
        WebDriver driver2 = WebDriverFactory.getDriver("chrome");
        //driver2.findElement(By.id("nav-search-submit-button"));
    }
}
