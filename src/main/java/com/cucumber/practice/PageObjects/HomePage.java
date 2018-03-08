package com.cucumber.practice.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(className = "topic-block-title")
    private WebElement toptitle;

    @FindBy(xpath = "//ul[@class='top-menu']//a[@href='/computers']")
    private WebElement computers;

    public HomePage(WebDriver driver){
       this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String verifyBlockTitle(){
        return toptitle.getText();
    }

    public void clickComputers(){
        computers.click();
    }
}
