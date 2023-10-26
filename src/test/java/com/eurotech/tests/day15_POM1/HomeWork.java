package com.eurotech.tests.day15_POM1;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork extends TestBase {

    /**
     * Task 2
     * go to http://eurotech.study/login page
     * login with teacher credentials
     * Get the text of the welcome message and verify following menu
     * Developers
     * All Posts
     * My Account
     */
    LoginPage loginPage;
    DashboardPage dashboardPage;
    String email= ConfigurationReader.get("emailTeacher");
    String password=ConfigurationReader.get("passwordTeacher");

    @Test
    public void task_2() {
        loginPage=new LoginPage();
        dashboardPage =new DashboardPage();
        driver.get(ConfigurationReader.get("url"));
        loginPage.understandBtn.click();
        loginPage.userEmailInput.sendKeys(ConfigurationReader.get("emailTeacher"));
        loginPage.userPasswordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.submitBtn.click();
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());
    }
}
