package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(id = "dashboard-h1")
    public WebElement dashboardText;
    @FindBy(xpath = "//p[@id='dashboard-p1']")
    public WebElement welcomeMessage;
    @FindBy(css = ".btn.btn-light")
    public List<WebElement> dashboardList;
    @FindBy(id = "post-form-btn")
    public WebElement submitBtn;
}
