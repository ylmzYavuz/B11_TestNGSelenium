package com.eurotech.pages;


import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage extends BasePage {

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

    ////////////////////////////////////////////////////////////

    //FindAll annotation is used like logical OR, and if one of the FindBy annotation finds element, it locates
    @FindAll({  //logical or
            @FindBy(id = "loginpage-input-email"),
            @FindBy(name = "email")
    })

    public WebElement userEmailInputFindAll;

    //FindBys annotation is used like logical AND, and if one of the FindBy annotation can NOT find element, it does NOT locate
    @FindBys({ //logical and
            @FindBy(id = "loginpage-form-pw-input"),
            @FindBy(xpath = "//input[@type='password']")
    })
    public WebElement userPasswordInputFindBys;

//    @FindBy(tagName = "li")
//    public List<WebElement> list;
    //////////////////////////////////////////////////////////


    public void login() {//tercih edilen
        String email=ConfigurationReader.get("emailTeacher");
        String password=ConfigurationReader.get("passwordTeacher");

        understandBtn.click();
        userEmailInput.sendKeys(email);
        userPasswordInput.sendKeys(password);
        submitBtn.click();
    }
    public void login(String email,String password) {//tercih edilen

        understandBtn.click();
        userEmailInput.sendKeys(email);
        userPasswordInput.sendKeys(password);
        submitBtn.click();
    }

    public void loginAsTeacher() {//tavsiye edilmez
        String email=ConfigurationReader.get("emailTeacher");
        String password=ConfigurationReader.get("passwordTeacher");

        understandBtn.click();
        userEmailInput.sendKeys(email);
        userPasswordInput.sendKeys(password);
        submitBtn.click();
    }
    public void loginAsStudent() {//tavsiye edilmez
        String email=ConfigurationReader.get("emailStudent");
        String password=ConfigurationReader.get("passwordStudent");

        understandBtn.click();
        userEmailInput.sendKeys(email);
        userPasswordInput.sendKeys(password);
        submitBtn.click();
    }

}
