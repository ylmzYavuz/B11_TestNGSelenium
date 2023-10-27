package com.eurotech.tests.day17_POM3;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.PostsPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest2 extends TestBase {
    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();
    PostsPage postsPage = new PostsPage();

    @Test
    public void verifyList() {
        /** Class Task - Duration: 10min
         go to "http://eurotech.study/login"
         Login with teacher credentials
         Verify login is successful
         Verify following menu
         - Edit Profile
         - Add Experience
         - Add Education
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), "Welcome Teacher", "Login verifcation is failed");
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Edit Profile");
        expectedList.add("Add Experience");
        expectedList.add("Add Education");

        List<String> actualList = new ArrayList<>();

        //1st way
//        for (WebElement listItem : dashboardPage.dashboardList) {
//            actualList.add(listItem.getText());
//        }
//        System.out.println("expectedList = " + expectedList);
//        System.out.println("actualList = " + actualList);
//        Assert.assertEquals(actualList,expectedList,"Verification of dashboard list is FAILED");

        //2nd way
//        List<WebElement> dashboardList= dashboardPage.dashboardList;
//        for (WebElement listItem : dashboardList) {
//            actualList.add(listItem.getText());
//        }
//        Assert.assertEquals(actualList,expectedList,"Verification of dashboard list is FAILED");

        // 3rd way
        Assert.assertEquals(BrowserUtils.getElementsText(dashboardPage.dashboardList), expectedList);
    }

    @Test
    public void logout() {
        /** Class Task - Duration: 15min
         go to "http://eurotech.study/login"
         Login with teacher credentials
         Verify login is successful
         Navigate to My Account and My Posts and verify that submit button is visible
         Navigate to Log Out  and verify that logout successful
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), "Welcome Teacher", "Login verifcation is failed");
        dashboardPage.navigateTSubMenu("My Posts");
        // 1. way of verifying Submit Button is visible/displayed
        Assert.assertTrue(postsPage.submitBtn.isDisplayed());
        // 2. way of verifying Submit Button is visible/displayed
        BrowserUtils.verifyElementDisplayed(postsPage.submitBtn);
        // 3. way of verifying with getAttribute Submit Button is visible/displayed
        Assert.assertEquals(postsPage.submitBtn.getAttribute("value"), "Submit");
        //logout
        postsPage.navigateTSubMenu("Logout");
        //verify logout
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void postComment() {
        /**
         Go to http://www.eurotech.study/
         Login with teacher credentials
         Navigate to My Account and navigate to My Posts
         Fill the title and post area
         Click submit button
         Verify that post saved successfully
         */
        driver.get("http://eurotech.study/login");
        loginPage.loginAsTeacher();
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), "Welcome Teacher", "Login verification is failed");

        dashboardPage.navigateTSubMenu("My Posts");
        String titleMsg = "Page Object Model";
        String postMsg ="Hallo Weld";
       /* postsPage.titleInput.sendKeys(titleText);
        postsPage.postInput.sendKeys(postText);
        postsPage.submitBtn.click();
        Assert.assertEquals(postsPage.postCreatedMsg.getText(),"Post Created","Verifying the post is created");*/

        postsPage.postComment(titleMsg,postMsg);
        BrowserUtils.waitFor(3);
    }
}
