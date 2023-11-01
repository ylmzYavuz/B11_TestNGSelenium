package com.eurotech.tests.day18_extentReports_screenshot;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUserNameTest extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void wrongUsername() {
        extentLogger = report.createTest("Wrong Username Test");

        extentLogger.info("Go to " + ConfigurationReader.get("url") + " website");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Click Understand Button");
        loginPage.understandBtn.click();

        extentLogger.info("Enter Invalid Username");
        loginPage.userEmailInput.sendKeys("wrongusername@wrong.com");

        extentLogger.info("Enter valid Password");
        loginPage.userPasswordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));

        extentLogger.info("Click Login Button");
        loginPage.submitBtn.click();

        extentLogger.info("Verify That NOT Logged In");
        Assert.assertEquals(loginPage.warningMessage.getText(), "Invalid Credentials!");

        extentLogger.pass("Test Passed");
    }

    @Test
    public void wrongPassword() {
        extentLogger = report.createTest("Wrong Password Test");

        extentLogger.info("Go to " + ConfigurationReader.get("url") + " website");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Click Understand Button");
        loginPage.understandBtn.click();

        extentLogger.info("Enter Valid Username");
        loginPage.userEmailInput.sendKeys(ConfigurationReader.get("emailTeacher"));

        extentLogger.info("Enter Invalid Password");
        loginPage.userPasswordInput.sendKeys("WrongPassword");

        extentLogger.info("Click Login Button");
        loginPage.submitBtn.click();

        extentLogger.info("Verify That NOT Logged In");
        Assert.assertEquals(loginPage.warningMessage.getText(), "Invalid Credentials!");

        extentLogger.pass("Test Passed");
    }
}