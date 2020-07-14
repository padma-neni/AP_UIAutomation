package com.automationpractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(AddressPage.class);

    public AddressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
