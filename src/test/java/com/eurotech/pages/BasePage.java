package com.eurotech.pages;

import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {//abstact olmasinin sebebi bu clastan obje olusturmayacagiz
    //OOP konsept.
    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(className = "nav__menu-item")
    public List<WebElement> menuList;

    @FindBy(id = "navbar-menu-list2-item2")//burasi daha genel oldugu icin basepage icine koyduk
    public WebElement allPosts;
    @FindBy(id = "navbar-menu-list2-item1")
    public WebElement developers;
    @FindBy(linkText = "My Account")
    public WebElement myAccount;

    public void navigateToMenu(String menuName){//interwiev de cok etkileyici olabilir
        Driver.get().findElement(By.xpath("//*[text()='"+menuName+"']")).click();
    }
    public void navigateTSubMenu(String subMenuName){
        BrowserUtils.hover(myAccount);
        Driver.get().findElement(By.xpath("//span[text()='"+subMenuName+"']")).click();
    }
}
