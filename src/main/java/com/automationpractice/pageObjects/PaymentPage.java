package com.automationpractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentPage extends  BasePage{
    private static final Logger logger = LoggerFactory.getLogger(PaymentPage.class);

    public PaymentPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Pay by check.']")
    WebElement payByCheck;

    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    WebElement payByBank;

    @FindBy(xpath = "//span[text()='I confirm my order']//parent::button")
    WebElement confirmOrder;

    @FindBy(xpath = "//p[@id='cart_navigation']/a")
    WebElement otherPaymentMethods;

    @FindBy(id = "//div/p[@class='payment_module']")
    WebElement paymentmethodBlock;

    @FindBy(xpath = "//*[@id='center_column']/h1")
    WebElement headertext;

    public void clickPayByCheck(){
        clickOnElement(payByCheck);
    }

    public void clickPayByBank(){
        clickOnElement(payByBank);
    }

    public void clickOnConfirmMyOrder(){
        clickOnElement(confirmOrder);
    }

    public void clickOnOtherPaymentMethods(){
        clickOnElement(otherPaymentMethods);
    }

    public boolean orderConfirmationDisplay(){
      return  headertext.getText().equalsIgnoreCase("ORDER CONFIRMATION");
    }

}
