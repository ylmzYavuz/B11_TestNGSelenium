package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {//abstact olmasinin sebebi bu clastan obje olusturmayacagiz
    //OOP konsept.
    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }
}
