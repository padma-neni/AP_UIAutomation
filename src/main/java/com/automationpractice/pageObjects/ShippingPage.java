package com.automationpractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShippingPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(ShippingPage.class);

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // @FindBy(xpath = "//input[@type='checkbox']")
    @FindBy(xpath = "//div/p[@class ='checkbox']/div/span/input")
    WebElement termsOfService;

    @FindBy(xpath = "//div[@class ='order_carrier_content box']")
    WebElement shippingOptionBox;

    @FindBy(xpath = "//button[@name='processCarrier']")
    WebElement shippingProceedToCheckOut;

    public void clickOnShippingProceedcheckout() {
        clickOnElement(shippingProceedToCheckOut);
    }

    public void clickOnTermsOfService() {
        scrollByVisibleElement(shippingOptionBox);
        termsOfService.click();
    }


}
