package com.cucumber.practice.TestDefinitions;

import com.cucumber.practice.stepdefinitions.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class GoogleSearchStepDefinition{

    TestBase base;
    WebDriver driver;

    public GoogleSearchStepDefinition(TestBase base){
        this.base=base;
        driver=this.base.getDriver();
    }


   @Given("^user navigates to google.com$")
   public void open_google(){
     System.out.println("From Given");
     driver.get("https://google.com");
   }

   @When("^user enters \"([^\"]*)\" in serach box$")
    public void enter_in_serachbox(String inputText){
       System.out.println("From When");
       WebElement searchBox=driver.findElement(By.id("lst-ib"));
       searchBox.sendKeys(inputText);
       new Actions(driver).sendKeys(Keys.ESCAPE);
       driver.findElement(By.name("btnK")).click();
   }

   @Then("^Result should be \"([^\"]*)\"$")
    public void get_correct_result(String result){
       System.out.println("From Then");
       driver.findElement(By.id("cwtltblr"));
       String actulaResult=driver.findElement(By.id("cwos")).getText();
       Assert.assertEquals(result,actulaResult);

   }

}
