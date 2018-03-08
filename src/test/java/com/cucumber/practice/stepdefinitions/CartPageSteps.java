package com.cucumber.practice.stepdefinitions;

import com.cucumber.practice.PageObjects.CartPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CartPageSteps {

    WebDriver driver;
    CartPage cartPage;

    public CartPageSteps(TestBase base) {
        this.driver = base.getDriver();
    }

    @Then("^\"([^\"]*)\" should be added to cart$")
    public void verify_prodcut_added_tocart(String pname){
      cartPage=new CartPage(driver);
      cartPage.verifyCheckout();
      Assert.assertTrue(cartPage.verifyProductName(pname));
    }


}
