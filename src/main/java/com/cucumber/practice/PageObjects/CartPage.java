package com.cucumber.practice.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    @FindBy(css="td[class='product'] a")
    private WebElement productname;

    @FindBy(id="checkout")
    private WebElement checkout;

    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyCheckout(){
        checkout.isDisplayed();
    }

    public boolean verifyProductName(String pName){
        if(productname.getText().contains(pName))
            return true;
        else
            return false;
    }
}
