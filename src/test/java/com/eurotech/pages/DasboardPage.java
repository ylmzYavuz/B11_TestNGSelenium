package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DasboardPage {
    @FindBy(id = "dashboard-h1")
    public WebElement dashBoardText;

    public DasboardPage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
