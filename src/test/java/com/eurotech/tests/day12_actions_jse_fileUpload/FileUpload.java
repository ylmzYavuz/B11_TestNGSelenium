package com.eurotech.tests.day12_actions_jse_fileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void fileUploadTest1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        Thread.sleep(2000);
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:/Users/User/Desktop/Eurotech_Batch11.txt");
        Thread.sleep(1000);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(2000);
        String actualText = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualText,"Eurotech_Batch11.txt");

    }
    @Test
    public void fileUploadTest2() throws InterruptedException {
        //Project Path
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        //Operating system
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));

        //System Environment u can keep any variable or data in your system environment
        // and u can use them with getenv() -> for security
        System.out.println("System.getenv(\"Path\") = " + System.getenv("Path"));

        driver.get("https://the-internet.herokuapp.com/upload");
        Thread.sleep(2000);
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        String projectpath = System.getProperty("user.dir");
        String filePath = "src/test/resources/Eurotech_Batch11.txt";
        String fullPath = projectpath + "/" + filePath;

        chooseFile.sendKeys(fullPath);

        Thread.sleep(1000);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(2000);
        String actualText = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualText,"Eurotech_Batch11.txt");

    }
}
