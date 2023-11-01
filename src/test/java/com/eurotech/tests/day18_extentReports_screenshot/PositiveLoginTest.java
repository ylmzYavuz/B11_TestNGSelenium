package com.eurotech.tests.day18_extentReports_screenshot;

import com.aventstack.extentreports.ExtentTest;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
    // Positive Test with login methods and take report
    DashboardPage dashboardPage=new DashboardPage();
    LoginPage loginPage=new LoginPage();

    @Test
    public void positiveLoginStudent() {
        extentLogger = report.createTest("Psitive Login test With Student Credentials");
        extentLogger.info("Go To"+ ConfigurationReader.get("url"));
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Use student's credentials to log in");
        loginPage.loginAsStudent();
        extentLogger.info("Verify that Login successfully ");
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());
        extentLogger.info("Test Passed");
    }
    @Test
    public void positiveLoginTeacher() {
        extentLogger = report.createTest("Psitive Login test With Teacher Credentials");
        extentLogger.info("Go To"+ ConfigurationReader.get("url"));
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Use teacher's credentials to log in");
        loginPage.loginAsTeacher();
        extentLogger.info("Verify that Login successfully ");
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());
        extentLogger.info("Test Passed");
    }
}
