package com.eurotech.tests.day09_typeOfWebElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDown {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void noSelectDropdownFrom_aspnetawesome() throws InterruptedException {
        driver.get("https://demo.aspnetawesome.com/");
        driver.findElement(By.cssSelector("#btnCookie")).click();
       // WebElement dropDownBtn = driver.findElement(By.xpath("(//i[@class='o-caret'])[8]"));
        WebElement dropDownBtn = driver.findElement(By.xpath("(//div[@class='o-slbtn'])[8]"));
        dropDownBtn.click();

//        WebElement papayaDropDown = driver.findElement(By.xpath("//div[.='Papaya']"));
//        //UnexpectedTagNameException: Element should have been "select" but was "div"
//        Select dropdown=new Select(papayaDropDown);
//        papayaDropDown.click();
        Thread.sleep(1000);
        List<WebElement> dropdownList = driver.findElements(By.xpath("(//ul[@class='o-mnits'])[9]/li"));
        System.out.println("dropdownList.size() = " + dropdownList.size());
        Thread.sleep(2000);
        Assert.assertEquals(dropdownList.size(),25);

        for (WebElement element : dropdownList) {
            System.out.println("element.getText() = " + element.getText());
        }
        String actualText=dropdownList.get(3).getText();
        String expectedText="Banana";
        System.out.println("actualText = " + actualText);
        Assert.assertEquals(actualText,expectedText);
        String expectedSelectedElem=dropdownList.get(4).getText();
        dropdownList.get(4).click();

        WebElement selectedElement = driver.findElement(By.xpath("(//div[@class='o-cptn'])[8]"));
        Assert.assertEquals(selectedElement.getText(),expectedSelectedElem);
    }

    @Test
    public void noSelectDropdownFrom_DemoQA() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[3]")).click();

        driver.findElement(By.xpath("//div[text()='Green']")).click();
        driver.findElement(By.xpath("//div[text()='Blue']")).click();
        driver.findElement(By.xpath("//div[text()='Black']")).click();
        driver.findElement(By.xpath("//div[text()='Red']")).click();
    }
}
