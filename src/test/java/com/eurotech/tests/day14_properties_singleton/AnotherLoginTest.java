package com.eurotech.tests.day14_properties_singleton;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {

   /** Class Task
    * go to url
    * click login      -> loginBtn.click();
    * enter email      -> email.sendKeys();
    * enter password   -> password.sendKeys();
    * click login btn  -> sumbit.click();
    */
   @Test

   public void t2_openBrowserUsingConfigReader() throws InterruptedException {
       //driver.get(ConfigurationReader.get("url"));
       driver.findElement(By.id("rcc-confirm-button")).click();
       WebElement userEmailInput=driver.findElement(By.id("loginpage-input-email"));
       userEmailInput.sendKeys(ConfigurationReader.get("emailStudent"));
       WebElement userPasswordInput=driver.findElement(By.id("loginpage-form-pw-input"));
       userPasswordInput.sendKeys(ConfigurationReader.get("passwordStudent")+ Keys.ENTER);//it goes sing up//sing up a götürür
   }

    @Test

    public void t_singletonReview() throws InterruptedException {

        WebDriver driver = Driver.get();
        WebDriver driver1 =Driver.get();

        driver.get("https://www.google.de/");
        Thread.sleep(2000);
        driver1.findElement(By.name("q")).sendKeys("selenium");

    }
}
