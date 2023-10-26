package com.eurotech.tests.day15_POM1;

import com.eurotech.pages.DashboardPage;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    String email = ConfigurationReader.get("emailTeacher");
    String password = ConfigurationReader.get("passwordTeacher");

    @Test
    public void t_positiveLogin() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        driver.get(ConfigurationReader.get("url"));
        loginPage.understandBtn.click();
        loginPage.userEmailInput.sendKeys(ConfigurationReader.get("emailTeacher"));
        loginPage.userPasswordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.submitBtn.click();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");
    }

    @Test
    public void t_loginWithMethod() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        driver.get(ConfigurationReader.get("url"));
        loginPage.login();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");
    }

    @Test
    public void t_loginWithMethodWithParameter() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        driver.get(ConfigurationReader.get("url"));
        loginPage.login(email, password);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");
    }

    /**
     * Task 1
     * 1- use loginAsTeacher method
     * 2-use  loginAsStudent method
     */

    @Test

    public void loginAsTeacher() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");
    }

    @Test

    public void loginAsStudent() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsStudent();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");
    }
}
