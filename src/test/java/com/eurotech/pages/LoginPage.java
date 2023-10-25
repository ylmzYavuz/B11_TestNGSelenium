package com.eurotech.pages;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "rcc-confirm-button")
    public WebElement understandBtn;
    @FindBy(id = "loginpage-input-email")
    public WebElement userEmailInput;

    @FindBy(id = "loginpage-form-pw-input")
    public WebElement userPasswordInput;
    @FindBy(id = "loginpage-form-btn")
    public WebElement submitBtn;
    @FindBy(xpath = "//*[contains(text(),'Invalid Credentials!')]")
    public WebElement warningMessage;

    public void login() {
        String email=ConfigurationReader.get("emailTeacher");
        String password=ConfigurationReader.get("passwordTeacher");

        understandBtn.click();
        userEmailInput.sendKeys(email);
        userPasswordInput.sendKeys(password);
        submitBtn.click();
    }
    public void login(String email,String password) {

        understandBtn.click();
        userEmailInput.sendKeys(email);
        userPasswordInput.sendKeys(password);
        submitBtn.click();
    }

    public void loginAsTeacher() {
        String email=ConfigurationReader.get("emailTeacher");
        String password=ConfigurationReader.get("passwordTeacher");

        understandBtn.click();
        userEmailInput.sendKeys(email);
        userPasswordInput.sendKeys(password);
        submitBtn.click();
    }
    public void loginAsStudent() {
        String email=ConfigurationReader.get("emailStudent");
        String password=ConfigurationReader.get("passwordStudent");

        understandBtn.click();
        userEmailInput.sendKeys(email);
        userPasswordInput.sendKeys(password);
        submitBtn.click();
    }

}
