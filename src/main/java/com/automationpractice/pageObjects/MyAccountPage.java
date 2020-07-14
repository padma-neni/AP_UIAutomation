package com.automationpractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAccountPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(MyAccountPage.class);

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text() = 'Order history and details']")
    WebElement orderHistoryDetails;

    @FindBy(xpath = "//span[text() = 'My credit slips']")
    WebElement myCreditSlip;

    @FindBy(xpath = "//span[text() = 'My addresses']")
    WebElement myAddress;

    @FindBy(xpath = "//span[text() = 'My personal information']")
    WebElement myPersonalInformation;

    @FindBy(xpath = "//span[text() = 'My wishlists']")
    WebElement myWishList;

    public void clickOnOrderHistoryDetails(){
        waitForElementToBeClickable(orderHistoryDetails);
        scrollByVisibleElement(orderHistoryDetails);
        orderHistoryDetails.click();
    }

    public void clickOnMyCreditSlips(){
        waitForElementToBeClickable(myCreditSlip);
        scrollByVisibleElement(myCreditSlip);
        myCreditSlip.click();
    }

    public void clickOnMyAddress(){
        waitForElementToBeClickable(myAddress);
        scrollByVisibleElement(myAddress);
        myAddress.click();
    }

    public void clickOnMyPersonalInfomation(){
        waitForElementToBeClickable(myPersonalInformation);
        scrollByVisibleElement(myPersonalInformation);
        myPersonalInformation.click();
    }

    public void clickOnMyWishLists(){
        waitForElementToBeClickable(myWishList);
        scrollByVisibleElement(myWishList);
        myWishList.click();
    }

}
