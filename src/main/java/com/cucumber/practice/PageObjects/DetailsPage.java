package com.cucumber.practice.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsPage {

    WebDriver driver;

    @FindBy(className = "short-description")
    private WebElement productShortDes;

    @FindBy(id="add-to-cart-button-9")
    private WebElement addToCart;

    @FindBy(id="bar-notification")
    private WebElement addNotificationBaneer;

    @FindBy(xpath="//div[@id='bar-notification']//a")
    private WebElement banner_Cart;

    public DetailsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyProductShortDesc(String pName){
       if(productShortDes.getText().contains(pName))
           return true;
       else
           return false;
    }

    public void addProductToCart(){
        addToCart.click();
    }

    public void navigateToCart(){
        banner_Cart.click();
    }
}
