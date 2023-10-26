package com.eurotech.tests.day16_POM2;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest extends TestBase {
    /**
     * Task 2
     * go to http://eurotech.study/login page
     * login with teacher credentials
     * Get the text of the welcome message and verify following menu
     * Developers
     * All Posts
     * My Account
     */

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void dashbordMenu() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),"Welcome Teacher");
        ArrayList<String> expectedList=new ArrayList<>();
        expectedList.add("Developers");
        expectedList.add("All Posts");
        expectedList.add("My Account");

        //1. way
        ArrayList<String> actualList=new ArrayList<>();
        List<WebElement> dashbordMenu= dashboardPage.menuList;
        for (WebElement menu : dashbordMenu) {
            System.out.println("menu.getText() = " + menu.getText());
            actualList.add(menu.getText());
        }
        System.out.println("actualList = " + actualList);
        Assert.assertEquals(actualList,expectedList);

        //2. way
        List<String> actualList1= BrowserUtils.getElementsText(dashboardPage.menuList);
        Assert.assertEquals(actualList,expectedList);

        //3.way
        Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.menuList),expectedList);

    }
}
