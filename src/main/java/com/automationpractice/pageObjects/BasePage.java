package com.automationpractice.pageObjects;

import com.automationpractice.managers.FileReadManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class BasePage {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    WebDriver driver;

    @FindBy(xpath = "//span[text()= 'Proceed to checkout']")
    WebElement proceedToCheckOut;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']")
    WebElement cartNavigation;

    public void clickOnProceedToCheckOut(){
        waitForPageLoadComplete();
        waitForVisibilityOfElement(cartNavigation);
        scrollByVisibleElement(cartNavigation);
        proceedToCheckOut.click();
        // clickOnElement(proceedToCheckOut);
    }

    long implicitWait = FileReadManager.getInstance().getConfigFileReader().getImplicitWait();

    public void waitForPageLoadComplete() {
        waitForPageLoadComplete(this.driver);
    }

    private void waitForPageLoadComplete(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(FileReadManager.getInstance().getConfigFileReader().getFluentWait()))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(pageLoadCondition);
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, implicitWait);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, implicitWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollByVisibleElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void pageRefresh() {
        driver.navigate().refresh();
        waitForPageLoadComplete();
    }

    public void clickOnElement(WebElement element) {
        waitForVisibilityOfElement(element);
        scrollByVisibleElement(element);
        element.click();
        waitForPageLoadComplete();
    }



}
