package com.cucumber.practice.Runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.io.File;


    @RunWith(Cucumber.class)
    @CucumberOptions(features ="src/test/resources/feature",
                     glue= {"com.cucumber.practice.stepdefinitions"},
                     plugin = {"html:target/cucumber-report","com.cucumber.listener.ExtentCucumberFormatter:target/extend-report/report.html"},
                     tags ={"~@GoogleSearch"})
    public class NotebookRunner {

        @AfterClass
        public static void writeExtentReport(){
            Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
            Reporter.setSystemInfo("user", System.getProperty("user.name"));
            Reporter.setSystemInfo("os", "Win 10");
            Reporter.setTestRunnerOutput("Sample test runner output message");
        }

    }

