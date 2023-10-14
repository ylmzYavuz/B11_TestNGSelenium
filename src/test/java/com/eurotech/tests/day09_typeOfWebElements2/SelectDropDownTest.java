package com.eurotech.tests.day09_typeOfWebElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void getOptionsTest() {

        //driver.get("https://demoqa.com/select-menu");

        WebElement colorDropDown = driver.findElement(By.id("oldSelectMenu"));
        //create select object by passing that elements as a constructor
        Select color=new Select(colorDropDown);
        //getOptions()-> return the all available options from the dropdown
        List<WebElement> colorList = color.getOptions();
        //print size of the option
        System.out.println("colorList.size() = " + colorList.size());

        Assert.assertEquals(colorList.size(),11);
        //print options one by one
        for (WebElement element : colorList) {
            System.out.println("element.getText() = " + element.getText());
        }
    }

    @Test
    public void selectByVisibleText() throws InterruptedException {
        //driver.get("https://demoqa.com/select-menu");

        // verify that default color is red
        WebElement colorDropDown = driver.findElement(By.id("oldSelectMenu"));
        Select color=new Select(colorDropDown);

        String expectedColor="Red";
        String actualColor=color.getFirstSelectedOption().getText();
        System.out.println("actualColor = " + actualColor);
        Assert.assertEquals(actualColor,expectedColor);
        //HOW TO SELECT OPTION FROM DROPDOWN
        // we can click each of element by 3 way

        //1. select using visible text
        Thread.sleep(2000);
        color.selectByVisibleText("Yellow");
        expectedColor="Yellow";
        //now first color is yellow so => getFirstSelectedOption() gets Yellow
        actualColor=color.getFirstSelectedOption().getText();
        Assert.assertEquals(actualColor,expectedColor);

    }

    @Test
    public void selectByIndexNumberTest() {
        WebElement colorDropDown = driver.findElement(By.id("oldSelectMenu"));
        Select color=new Select(colorDropDown);

        //2. select using index
        color.selectByIndex(2);
        String expectedColor="Green";
        String actualColor=color.getFirstSelectedOption().getText();
        Assert.assertEquals(actualColor,expectedColor);
        color.selectByIndex(0);
        expectedColor="Red";
        actualColor=color.getFirstSelectedOption().getText();
        System.out.println("actualColor = " + actualColor);
        Assert.assertEquals(actualColor,expectedColor);

    }

    @Test
    public void selectByAttributeValueTest() {
        WebElement colorDropDown = driver.findElement(By.id("oldSelectMenu"));
        Select color=new Select(colorDropDown);
        //3. select using value
        color.selectByValue("7");
        String expectedColor="Voilet";
        String actualColor=color.getFirstSelectedOption().getText();
        System.out.println("actualColor = " + actualColor);
        Assert.assertEquals(actualColor,expectedColor);

        color.selectByValue("red");
        expectedColor="Red";
        actualColor=color.getFirstSelectedOption().getText();
        System.out.println("actualColor = " + actualColor);
        Assert.assertEquals(actualColor,expectedColor);
    }
}
