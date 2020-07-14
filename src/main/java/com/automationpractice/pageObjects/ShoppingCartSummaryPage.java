package com.automationpractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShoppingCartSummaryPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartSummaryPage.class);

    public ShoppingCartSummaryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



}
