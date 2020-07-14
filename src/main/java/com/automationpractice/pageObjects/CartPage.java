package com.automationpractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[starts-with(@class,'layer_cart_cart')]//a[@title= 'Proceed to checkout']")
    WebElement proceedToCheckOutbutton;

    @FindBy(xpath = "//span[@title= 'Continue shopping']")
    WebElement continueShopping;

    @FindBy(xpath = "//div[starts-with(@class,'layer_cart_product ')]/h2")
    WebElement productSuccessMessage;


    public void clickOnProceedToCheckOut(){
        clickOnElement(proceedToCheckOutbutton);
    }

    public void clickOnContinueShopping(){
        scrollByVisibleElement(continueShopping);
        continueShopping.click();
    }

    public boolean verifyDisplayOfProductSuccessPage(){
        String sMessage = "Product successfully added to your shopping cart";
        waitForVisibilityOfElement(productSuccessMessage);
        scrollByVisibleElement(productSuccessMessage);
        return productSuccessMessage.getText().contains(sMessage);
    }


}
