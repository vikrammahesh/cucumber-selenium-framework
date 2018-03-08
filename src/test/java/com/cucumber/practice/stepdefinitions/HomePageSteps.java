package com.cucumber.practice.stepdefinitions;

import com.cucumber.practice.PageObjects.ComputersPage;
import com.cucumber.practice.PageObjects.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {

    WebDriver driver;
    HomePage homePage;
    ComputersPage computersPage;

    public HomePageSteps(TestBase base) {
        this.driver = base.getDriver();
    }

    @Given("^user opens nopCommerce home page$")
    public void open_home(){
      driver.get("http://demo.nopcommerce.com/");
      homePage=new HomePage(driver);
      Assert.assertEquals(homePage.verifyBlockTitle(),"Welcome to our store");
    }

    @When("^user clicks computers from top menu$")
    public void click_computer_in_topmenu(){
      homePage.clickComputers();
      computersPage=new ComputersPage(driver);
      Assert.assertEquals(computersPage.getCategoryTitle(),"Computers");
    }

    @When("^clicks Notebooks tile$")
    public void click_notebook_tile(){
       computersPage.clickNotebook();
    }
}
