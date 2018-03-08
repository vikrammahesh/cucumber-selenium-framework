package com.cucumber.practice.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComputersPage {

    WebDriver driver;

    @FindBy(className = "page-title")
    private WebElement categoryTitle;

    @FindBy(css = "a[title='Show products in category Notebooks']")
    private WebElement notebookstile;

    public ComputersPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickNotebook(){
        notebookstile.click();
    }

    public String getCategoryTitle(){
        return categoryTitle.getText();
    }
}
