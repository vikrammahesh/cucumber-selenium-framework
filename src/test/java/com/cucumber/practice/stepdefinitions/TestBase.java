package com.cucumber.practice.stepdefinitions;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    private static boolean startBrowser = false;
    ExtentReports extent;
    ExtentTest logger;

    @Before
    public void init(){
        if (!startBrowser) {
            System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome2.35\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            startBrowser=true;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    @After(order=1)
    public void embedScreenshot(Scenario scenario){

        if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            String screenshotInDirectory="screenshot/"+screenshotName+".png";
            try {
                File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File dest=new File(System.getProperty("user.dir")+"/target/extend-report/"+screenshotInDirectory);
                FileUtils.copyFile(source,dest);
                Reporter.addScreenCaptureFromPath(screenshotInDirectory);
                //This is to embeded the screenshot in default html report
                /*byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
                System.out.println("captured screenshot");*/
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        System.out.println("End");

    }

    //@After(order=0)
    public void closeBrowser(){
        driver.close();
    }
}
