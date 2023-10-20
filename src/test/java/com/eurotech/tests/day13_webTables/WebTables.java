package com.eurotech.tests.day13_webTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test

    public void printTable() {

        WebElement tableDemo = driver.findElement(By.xpath("//table[@id='t01']"));
        System.out.println("tableDemo.getText() = " + tableDemo.getText());

        Assert.assertTrue(tableDemo.getText().contains("Jackson"));

    }
    @Test

    public void getAllHeaders() {
        List<WebElement>allHearders = driver.findElements(By.xpath("//table[@id='t01']//th"));
        System.out.println("allHearders.size() = " + allHearders.size());

        //to all get header use foreach loop
        for (WebElement allHearder : allHearders) {
            System.out.println("allHearder.getText() = " + allHearder.getText());
        }
    }
    @Test

    public void printTableSize() {
        //number of rows with header
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='t01']//tr"));
        System.out.println("allRowsWithHeader.size() = " + allRowsWithHeader.size());

        //number of rows without header
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        System.out.println("allRowsWithoutHeader.size() = " + allRowsWithoutHeader.size());
    }
    @Test

    public void getRows() {
        WebElement row2 = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[2]"));
        System.out.println("row2.getText() = " + row2.getText());

        System.out.println("");
        //get all rows dynamically and print them one by one (without header)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        for (WebElement webElement : allRowsWithoutHeader) {
            System.out.println("webElement.getText() = " + webElement.getText());
        }
            //get all rows dynamically and print them one by one (without header)(with for index loop)
        System.out.println();
            for (int i = 1; i <= allRowsWithoutHeader.size(); i++) {
                WebElement rowelement = driver.findElement(By.xpath("(//table[@id='t01']//td/..)["+i+"]"));
                System.out.println("rowelement.getText() = " + rowelement.getText());
            }
    }
    @Test

    public void getAllCellInOneRow() {
        //get All Cell of ........ Row
        List<WebElement> allCellInOneRow = driver.findElements(By.xpath("(//table[@id='t01']//td/..)[1]/td"));
        for (WebElement webElement : allCellInOneRow) {
            System.out.println("webElement.getText() = " + webElement.getText());
        }
    }
    @Test

    public void getSingleCellIneOneRow() {
        //det the 2. cell of first row ->Smith
        WebElement secondCellOfFirstRow = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[1]/td[2]"));
        System.out.println("secondCellOfFirstRow.getText() = " + secondCellOfFirstRow.getText());

        //det the 3. cell of second row ->94
        WebElement thirdCellOfSecondRow = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[2]/td[3]"));
        System.out.println("thirdCellOfSecondRow.getText() = " + thirdCellOfSecondRow.getText());

    }
    @Test

    public void printAllCellsByIndex() {
        //we would like to write a code that it will print all cells one by one
        int rowNumber = getNumbersOfRows();
        int columnNumber = getNumberOfColumns();

        for (int i = 1; i <=rowNumber ; i++) {
            for (int j = 1; j <=columnNumber; j++) {
                WebElement element = driver.findElement(By.xpath("(//table[@id='t01']//td/..)["+i+"]/td["+j+"]"));
                System.out.println(i+"/"+j+"--> "+element.getText());
            }
        }
    }
    private int getNumbersOfRows(){
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        int rowNumber=allRowsWithoutHeader.size();
        return rowNumber;
    }
    private int getNumberOfColumns(){
        List<WebElement>allHearders = driver.findElements(By.xpath("//table[@id='t01']//th"));
        int columnNumber = allHearders.size();
        return columnNumber;
    }

    public WebElement getSpecificCell(int row,int column) {
        WebElement element = driver.findElement(By.xpath("(//table[@id='t01']//td/..)["+row+"]/td["+column+"]"));
        return element;
    }
    @Test

    public void test() {
        //verify that value of 3 rd row and 2nd cell is"Doe"
        WebElement targetElement = getSpecificCell(3,2);
        String actual = targetElement.getText();
        String expected = "Doe";
        Assert.assertEquals(actual,expected);
    }
}
