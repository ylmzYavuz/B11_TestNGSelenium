package com.eurotech.tests;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;//inherit edilen ve ayni package daki claslarin ulasmasi icin protected tanimladik
    protected WebDriverWait wait;
    protected Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.get("url"));//lazimsa koy koyalim dursun olmaz
        wait = new WebDriverWait(driver, 15);//lazimsa koy koyalim dursun olmaz
        actions = new Actions(driver); //lazimsa koy koyalim dursun olmaz
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }
}
