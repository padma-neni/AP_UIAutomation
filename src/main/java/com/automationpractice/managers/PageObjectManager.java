package com.automationpractice.managers;

import com.automationpractice.pageObjects.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageObjectManager {
    private static final Logger logger = LoggerFactory.getLogger(PageObjectManager.class);

    private WebDriver driver;

    private HomePage homePage;
    private AccountPage accountPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private ShoppingCartSummaryPage shoppingCartSummaryPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;
    private AddressPage addressPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage gethomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public AccountPage getaccountPage() {
        return (accountPage == null) ? accountPage = new AccountPage(driver) : accountPage;
    }

    public ProductPage getProductPage(){
        return (productPage ==null)? productPage = new ProductPage(driver): productPage;
    }

    public CartPage getCartPage(){
        return (cartPage == null)? cartPage = new CartPage(driver):cartPage;
    }

    public ShoppingCartSummaryPage getShoppingCartSummaryPage(){
        return (shoppingCartSummaryPage == null)?
                shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver):
                shoppingCartSummaryPage;
    }

    public ShippingPage getShippingPage(){
        return(shippingPage==null)?
                shippingPage= new ShippingPage(driver):
                shippingPage;
    }

    public PaymentPage getPaymentPage(){
        return (paymentPage==null)?
                paymentPage= new PaymentPage(driver):
                paymentPage;
    }

    public AddressPage getAddressPage(){
        return (addressPage == null)?
                addressPage = new AddressPage(driver):
                addressPage;
    }
}

