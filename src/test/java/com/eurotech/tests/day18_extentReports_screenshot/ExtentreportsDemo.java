package com.eurotech.tests.day18_extentReports_screenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentreportsDemo {
    //Thiss object will bu used for starting and building reports
    ExtentReports report;

    //this object will bu used to create HTML report file.
    ExtentHtmlReporter htmlReporter;

    //This object will define a test, enable adding logs, authors and test steps.
    ExtentTest extentLogger;


    @BeforeMethod
    public void setUp() {
        //This will initialize the ExtentReports Class
        report = new ExtentReports();

        //Create a report path --> how can we find our project dynamically
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //Initialize the HTML report with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //Attach the HTML Report to the report object
        report.attachReporter(htmlReporter);

        //We need to give a title for report
        htmlReporter.config().setReportName("Batch11 Smoke Test");

        //Set environment information--> Test name, Tester name, Browser, Test Steps, Test Data, Date and Time, Operating System, Result
        report.setSystemInfo("Environment", "Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", "Yavuz");

    }

    @Test
    public void test1() {
        //Let's give a name to our current test
        extentLogger = report.createTest("TC001 Login Test");

        //Let's enter our test steps
        extentLogger.info("Open The Browser");
        extentLogger.info("Go to URL " + ConfigurationReader.get("url"));
        extentLogger.info("Click I Understand Button");
        extentLogger.info("Enter Teacher Username");
        extentLogger.info("Enter Teacher Password");
        extentLogger.info("Click Login Button");
        extentLogger.info("Verify Logged In");

    }

    @AfterMethod
    public void tearDown() {
        //This is when the report is actually created
        report.flush();
    }
}
