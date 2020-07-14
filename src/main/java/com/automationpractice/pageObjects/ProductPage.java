package com.automationpractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductPage extends  BasePage{

    private static final Logger logger = LoggerFactory.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id= "quantity_wanted")
    WebElement quantityWanted;

    @FindBy(xpath = "//p[@id= 'add_to_cart']/button[@name ='Submit'] ")
    WebElement addToCartButton;

    @FindBy(id = "our_price_display")
    WebElement productDisplayPrice;

    @FindBy(xpath = "//div[starts-with(@class,'layer_cart_cart')]//a[@title= 'Proceed to checkout']")
    WebElement proceedToCheckOutbutton;

    @FindBy(xpath = "//a[@title= 'Continue shopping']/span")
    WebElement continueShopping;



    public void enterQuantity(String num){
        waitForVisibilityOfElement(quantityWanted);
        scrollByVisibleElement(quantityWanted);
        quantityWanted.clear();
        quantityWanted.sendKeys(String.valueOf(num));
    }

    public void  clickOnAddToCart(){
        clickOnElement(addToCartButton);
    }

    public String getProductPrice(){
        scrollByVisibleElement(productDisplayPrice);
        return productDisplayPrice.getText();
    }

    public void addtocart(String num){
        enterQuantity(num);
        System.out.println(getProductPrice());
        clickOnAddToCart();
    }

//    public void clickOnProceedToCheckOut(){
//        clickOnElement(proceedToCheckOutbutton);
//    }
//
//    public void clickOnContinueShopping(){
//        scrollByVisibleElement(continueShopping);
//        continueShopping.click();
//    }
//
//    public boolean verifyDisplayOfProductSuccessPage(){
//        String sMessage = "Product successfully added to your shopping cart";
//        waitForVisibilityOfElement(productSuccessMessage);
//        scrollByVisibleElement(productSuccessMessage);
//        return productSuccessMessage.getText().contains(sMessage);
//    }


}
