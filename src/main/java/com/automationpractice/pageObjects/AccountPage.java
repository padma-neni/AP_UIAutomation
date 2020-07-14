package com.automationpractice.pageObjects;

import com.automationpractice.util.RandomValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(AccountPage.class);

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    WebElement signInLink;

    @FindBy(xpath = "//input[@name='email_create']")
    WebElement emailAddressTxtBox;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement title;

    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    WebElement customerLastName;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement passWord;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "postcode")
    WebElement postcode;

    @FindBy(id = "phone_mobile")
    WebElement mobilephone;

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    @FindBy(xpath = "//*[@id='center_column']/p")
    WebElement welcomeMessage;

    @FindBy(xpath = "//*[@id='create_account_error']/ol/li")
    WebElement aleadyRegEmessage;

    @FindBy(id = "email")
    WebElement userEmailAddress;

    @FindBy(id = "passwd")
    WebElement userPassword;

    @FindBy(id = "SubmitLogin")
    WebElement loginButton;

    public void clickOnSignInLink() {
        clickOnElement(signInLink);
    }

    public void enterEmailAddress(String emailAddress) {
        waitForVisibilityOfElement(emailAddressTxtBox);
        emailAddressTxtBox.clear();
        emailAddressTxtBox.sendKeys(emailAddress);
    }

    public void clickOnCreateAccount() {
        clickOnElement(createAccountButton);
    }

    public void createAccount(String emailAddress) {
        enterEmailAddress(emailAddress);
        clickOnCreateAccount();
    }

    public void selectTitle() {
        clickOnElement(title);
    }

    public void enterCustomerFirstname(String firstname) {
        waitForVisibilityOfElement(customerFirstName);
        scrollByVisibleElement(customerFirstName);
        customerFirstName.clear();
        customerFirstName.sendKeys(firstname);
    }

    public void enterCustomerLastName(String lastname) {
        waitForVisibilityOfElement(customerLastName);
        scrollByVisibleElement(customerLastName);
        customerLastName.clear();
        customerLastName.sendKeys(lastname);
    }

    public String getemailaddress() {
        waitForVisibilityOfElement(email);
        return email.getAttribute("value");
    }

    public void enterMobilePhoneNumber() {
        waitForVisibilityOfElement(mobilephone);
        mobilephone.clear();
        mobilephone.sendKeys(RandomValues.generateRandomPhoneNumber());
    }

    public void selectState() {
        Select drpState = new Select(driver.findElement(By.id("id_state")));
        drpState.selectByVisibleText("New York");
    }

    public void enteraddress() {
        waitForVisibilityOfElement(address1);
        address1.sendKeys("7909 Maple Street");
        city.sendKeys("Newburgh");
        selectState();
        postcode.sendKeys((String.valueOf(RandomValues.generateRandomZipcode())));
    }

    public void enterPassword() {
        waitForVisibilityOfElement(passWord);
        scrollByVisibleElement(passWord);
        passWord.sendKeys("AutoTest123");
    }

    public void fillPersonalInformation() {
        selectTitle();
        enterCustomerFirstname("TestfirstName");
        enterCustomerLastName("testLastName");
        enterPassword();
        enteraddress();
        enterMobilePhoneNumber();
    }

    public void clickRegisterButton() {
        waitForVisibilityOfElement(registerButton);
        scrollByVisibleElement(registerButton);
        registerButton.click();
        waitForPageLoadComplete();
    }

    public String getWelcomemessage() {
        waitForVisibilityOfElement(welcomeMessage);
        return welcomeMessage.getText();
    }

    public boolean verifyAlreadyRegisteredEmessage() {
        waitForVisibilityOfElement(aleadyRegEmessage);
        scrollByVisibleElement(aleadyRegEmessage);
        String errormessage = "An account using this email address has already been registered." +
                "Please enter a valid password or request a new one.";
        return aleadyRegEmessage.getText().equalsIgnoreCase(errormessage);
        //return driver.getPageSource().contains(errormessage);
    }

    public void enteruseremailAddress(String emailaddress) {
        waitForVisibilityOfElement(userEmailAddress);
        scrollByVisibleElement(userEmailAddress);
        userEmailAddress.sendKeys(emailaddress);
    }

    public void enterUserPassword(String pwd) {
        waitForVisibilityOfElement(userPassword);
        userPassword.sendKeys(pwd);
    }

    public void clickOnSigninButton() {
        waitForVisibilityOfElement(loginButton);
        loginButton.click();
    }

    public void login(String emailAddress, String pwd) {
        enteruseremailAddress(emailAddress);
        enterUserPassword(pwd);
        clickOnSigninButton();
    }


}
