package com.cucumber.practice.stepdefinitions;

import com.cucumber.practice.PageObjects.DetailsPage;
import com.cucumber.practice.PageObjects.NoteBooksPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class NoteBookPageSteps {

    WebDriver driver;
    NoteBooksPage noteBooksPage;
    DetailsPage detailsPage;

    public NoteBookPageSteps(TestBase base) {
        this.driver = base.getDriver();
        noteBooksPage=new NoteBooksPage(driver);
    }

    @Given("^user in \"([^\"]*)\" page$")
    public void user_in_page(String page) {
        driver.get("http://demo.nopcommerce.com/"+page);

    }

    @Then("^avialable notebooks should be shown$")
    public void verify_avialble_products(){
      Assert.assertEquals(noteBooksPage.getCategoryTitle(),"Notebooks");
    }

    @When("^apply corei7 filter$")
    public void apply_filer(){
        System.out.println();
        noteBooksPage.selectCPUFilter();
    }

    @When("^click on \"([^\"]*)\" note book$")
    public void click_on_notebook(String productName){
       noteBooksPage.clickProductTile(productName);
    }

    @Then("^\"([^\"]*)\" deatils page should be shown$")
    public void notebook_details_page(String pName){
        detailsPage=new DetailsPage(driver);
        Assert.assertTrue(detailsPage.verifyProductShortDesc(pName));
    }

    @When("^click on add to cart and move to cart$")
    public void click_on_add_tocart(){
        detailsPage.addProductToCart();
        detailsPage.navigateToCart();
    }

}
