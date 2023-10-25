package com.eurotech.tests.day15_POM1;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    LoginPage loginPage;

    @Test
    public void t_wrongPassword() {
//        WebElement userEmailInput = driver.findElement(By.id("loginpage-input-email"));
//        WebElement userPasswordInput = driver.findElement(By.id("loginpage-form-pw-input"));
//        driver.findElement(By.id("rcc-confirm-button")).click();
//        userEmailInput.sendKeys(ConfigurationReader.get("emailTeacher"));
//        userPasswordInput.sendKeys("wrongKeyWord");
//        driver.findElement(By.id("loginpage-form-btn")).click();
//        WebElement warningMessage= driver.findElement(By.xpath("//*[contains(text(),'Invalid Credentials!')]"));
//        Assert.assertEquals(warningMessage.getText(),"Invalid Credentials!");

        loginPage = new LoginPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.understandBtn.click();
        loginPage.userEmailInput.sendKeys(ConfigurationReader.get("emailStudent"));
        loginPage.userPasswordInput.sendKeys("wrongPassword");
        loginPage.submitBtn.click();
        String actualMessage = loginPage.warningMessage.getText();
        Assert.assertEquals(actualMessage, "Invalid Credentials!");
    }
    @Test
    public void t_wrongUserName() {
        loginPage = new LoginPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.understandBtn.click();
        loginPage.userEmailInput.sendKeys("wrongEmail@gmail.com");
        loginPage.userPasswordInput.sendKeys(ConfigurationReader.get("passwordStudent"));
        loginPage.submitBtn.click();
        String actualMessage = loginPage.warningMessage.getText();
        Assert.assertEquals(actualMessage, "Invalid Credentials!");

    }
}
