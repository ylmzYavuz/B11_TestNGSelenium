package com.eurotech.tests.day15_POM1;

import com.eurotech.pages.DasboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
    LoginPage loginPage;
    DasboardPage dasboardPage;
    String email=ConfigurationReader.get("emailTeacher");
    String password=ConfigurationReader.get("passwordTeacher");
    @Test
    public void t_positiveLogin() {
        loginPage=new LoginPage();
        dasboardPage=new DasboardPage();

        driver.get(ConfigurationReader.get("url"));
        loginPage.understandBtn.click();
        loginPage.userEmailInput.sendKeys(ConfigurationReader.get("emailTeacher"));
        loginPage.userPasswordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.submitBtn.click();
        wait.until(ExpectedConditions.visibilityOf(dasboardPage.dashBoardText));
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");
    }

    @Test
    public void t_loginWithMethod() {
        loginPage=new LoginPage();
        dasboardPage=new DasboardPage();

        driver.get(ConfigurationReader.get("url"));
        loginPage.login();
        wait.until(ExpectedConditions.visibilityOf(dasboardPage.dashBoardText));
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");
    }
    @Test
    public void t_loginWithMethodWithParameter() {
        loginPage=new LoginPage();
        dasboardPage=new DasboardPage();

        driver.get(ConfigurationReader.get("url"));
        loginPage.login(email,password);
        wait.until(ExpectedConditions.visibilityOf(dasboardPage.dashBoardText));
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/dashboard");
    }

    /**  Task 1
     * 1- use loginAsTeacher method
     2-use  loginAsStudent method
     Task 2
     * go to http://eurotech.study/login page
     * login with teacher credentials
     * Get the text of the welcome message and verify following menu
     * Developers
     * All Posts
     * My Account
     */

}
