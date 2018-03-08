package com.cucumber.practice.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class NoteBooksPage {
    WebDriver driver;

    @FindBy(linkText = "Intel Core i7")
    private WebElement core7link;

    @FindBy(className = "remove-filter")
    private WebElement removeFilter;

    @FindBy(css="a[title*='Lenovo Thinkpad']")
    private WebElement lenovothinkpad;
    private String productLink="a[title*='%s']";

    @FindBy(className = "page-title")
    private WebElement categoryTitle;

    public NoteBooksPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void selectCPUFilter(){
        core7link.click();
        removeFilter.isDisplayed();
    }

    public void clickProductTile(String name){
        //lenovothinkpad.click();
        driver.findElement(By.xpath(String.format(productLink,name))).click();
    }

    public String getCategoryTitle(){
        return categoryTitle.getText();
    }
}
