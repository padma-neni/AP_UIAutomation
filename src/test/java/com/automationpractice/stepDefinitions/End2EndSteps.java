package com.automationpractice.stepDefinitions;

import com.automationpractice.cucumber.TestContext;
import com.automationpractice.pageObjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en_scouse.An;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class End2EndSteps extends BaseSteps {

    private static final Logger logger = LoggerFactory.getLogger(End2EndSteps.class);

    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    ShoppingCartSummaryPage shoppingCartSummaryPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    AddressPage addressPage;


    public End2EndSteps(TestContext context){
        testContext = context;
        homePage = testContext.getPageObjectManager().gethomePage();
        productPage = testContext.getPageObjectManager().getProductPage();
        cartPage = testContext.getPageObjectManager().getCartPage();
        shoppingCartSummaryPage = testContext.getPageObjectManager().getShoppingCartSummaryPage();
        shippingPage = testContext.getPageObjectManager().getShippingPage();
        paymentPage = testContext.getPageObjectManager().getPaymentPage();
        addressPage = testContext.getPageObjectManager().getAddressPage();
    }

    @Given("^User clicks on \"([^\"]*)\" tab on home page$")
     public void userClicksonCategoryTabOnHomePage(String category){
        if(category.equalsIgnoreCase("women")){  homePage.clickOnWomensMenu();}
        else if (category.equalsIgnoreCase("dresses")){homePage.clickOnDressTab();}
        else if (category.equalsIgnoreCase("tshirts")){homePage.clickOnTShirts();}
    }

    @And ("^Click on \"([^\"]*)\" product$")
    public void clickOnProduct(String productName) throws InterruptedException {
        homePage.clickOnProduct(productName);
    }

    @And("^Click on add to cart with \"([^\"]*)\" quantity and verify successful message$")
    public void clickOnAddToCartWithQuantityAndVerify(String num){
        productPage.addtocart(num);
        Assert.assertTrue(cartPage.verifyDisplayOfProductSuccessPage());
    }

    @And("^User Clicks on \"([^\"]*)\" on cart page$")
    public void userClicksOnButtonOnCartPage(String buttonType){
        if(buttonType.equalsIgnoreCase("proceedToCheckout")){
            cartPage.clickOnProceedToCheckOut();
        }
        else if(buttonType.equalsIgnoreCase("continueShoping")){
            cartPage.clickOnContinueShopping();
        }
    }

    @And("^User clicks on \"([^\"]*)\" on Shopping cart summary page$")
    public void userClicksOnlinkOnShoppingCartPage(String buttonType){
        if(buttonType.equalsIgnoreCase("proceedToCheckout")){
            shoppingCartSummaryPage.clickOnProceedToCheckOut();
        }
//        else if(buttonType.equalsIgnoreCase("continueShoping")){
//            cartPage.clickOnContinueShopping();
//        }
    }

    @And("^User clicks on \"([^\"]*)\" on Address page$")
    public void userClicksonProceedOnAddressPage(String buttonType){
        if(buttonType.equalsIgnoreCase("proceedToCheckout")){
            addressPage.clickOnProceedToCheckOut();
        }
    }


    @And("^User agree terms of Service and click proceed to checkout in shipping page$")
    public void agreeTermsOfServiceAndClickProceed(){
        shippingPage.clickOnTermsOfService();
        shippingPage.clickOnShippingProceedcheckout();
    }

    @And("^Click on confirm order selecting \"([^\"]*)\" paymenttype$")
    public void clickOnConfirmOrderafterSelectingPayment(String paymenttype){
        if(paymenttype.equalsIgnoreCase("Bank")){
            paymentPage.clickPayByBank();
        }
        else if(paymenttype.equalsIgnoreCase("Check")) {
        paymentPage.clickPayByCheck();
        }

        paymentPage.clickOnConfirmMyOrder();
    }

    @Then("^User successfully navigates to OrderConfirmation page$")
    public void userNavigatesToOrderConfirmationPage(){
        Assert.assertTrue(paymentPage.orderConfirmationDisplay());
    }




}
