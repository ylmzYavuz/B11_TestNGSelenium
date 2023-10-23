package com.eurotech.tests.day14_properties_singleton;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {//inheritence
    /*WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }*/
    @Test

    public void t2_openBrowserUsingConfigReader() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.findElement(By.id("loginpage-input-email")).sendKeys(ConfigurationReader.get("emailStudent"));
        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys(ConfigurationReader.get("passwordStudent")+Keys.ENTER);//it goes sing up//sing up a götürür

    }
}
