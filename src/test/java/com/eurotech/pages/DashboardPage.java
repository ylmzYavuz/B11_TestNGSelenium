package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "(//tbody)[1]/tr[2]/td[2]") //*[text()='Test Automation Engineer']
    public WebElement jobTitle;

    // same locator type with base menu so we can use navigateToMenu() method
   /** public void dashboardMenu(String menuName){//interwiev de cok etkileyici olabilir
        Driver.get().findElement(By.xpath("//*[text()='"+menuName+"']")).click();
    }*/

   /*public String getTitle(String title){
       return Driver.get().findElement(By.xpath("//td[text()='"+title+"']")).getText();
   }
   public String getCompany(String company){
       return Driver.get().findElement(By.xpath("//td[text()='"+company+"']")).getText();
   }*/
   public String getTextCommen(String element){//daha kullanisli
       return Driver.get().findElement(By.xpath("//td[text()='"+element+"']")).getText();
   }
}

