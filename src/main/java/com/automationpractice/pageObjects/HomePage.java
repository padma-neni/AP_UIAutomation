package com.automationpractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.interactions.Actions;


public class HomePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Women']")
    WebElement womenTab;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li/a[@title='Dresses']")
    WebElement dressesTab;

   // @FindBy(xpath = "//a[@title='T-shirts']")
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li/a[@title='T-shirts']")
    WebElement tShirts;

    @FindBy(id = "home-page-tabs")
    WebElement homePagetabs;

    @FindBy(id = "productsSortForm")
    WebElement productsSortForm;

    @FindBy(id = "subcategories")
    WebElement subcategoriesBlock;

    public void clickOnWomensMenu() {
        clickOnElement(womenTab);
    }

    public void clickOnDressTab() {
        pageRefresh();
        clickOnElement(dressesTab);
    }

    public void clickOnTShirts(){
        pageRefresh();
        clickOnElement(tShirts);
    }

    public void clickOnProduct(String productname) throws InterruptedException {
        String productimagexpath = "//a[@title='" + productname + "']";
        WebElement productImage = driver.findElement(By.xpath(productimagexpath));
        String productXpath = "//*[@class='right-block']//a[@title='" + productname + "']";
        WebElement product = driver.findElement(By.xpath(productXpath));
        waitForPageLoadComplete();
        scrollByVisibleElement(productImage);
        product.click();
    }

}
