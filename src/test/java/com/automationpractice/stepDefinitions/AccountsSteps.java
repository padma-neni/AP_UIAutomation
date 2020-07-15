package com.automationpractice.stepDefinitions;

import com.automationpractice.pageObjects.AccountPage;
import com.automationpractice.cucumber.TestContext;
import com.automationpractice.pageObjects.HomePage;
import com.automationpractice.util.RandomValues;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountsSteps extends BaseSteps {
    private static final Logger logger = LoggerFactory.getLogger(AccountsSteps.class);

    AccountPage accountPage;
    HomePage homepage;

    TestContext testContext;
    public String emailAddress = RandomValues.generateRandomEmailAddress();
    public String wMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";
    public String loginUserName = "apuiautotest@test.com";
    public String loginPwd = "AutoTest123";


    public AccountsSteps(TestContext context){
        testContext = context;
        accountPage = testContext.getPageObjectManager().getaccountPage();
        homepage = testContext.getPageObjectManager().gethomePage();
    }

    @Given("^User clicks on sign in link on homepage$")
    public void userClicksonSigninlinkonHomePage(){
       accountPage.clickOnSignInLink();
    }



    @And("^click on create account entering \"([^\"]*)\" email address$")
    public void clickonCreateaccountenteringEmailAddress(String addressType){
        if(addressType.contentEquals("valid")){
            accountPage.createAccount(emailAddress);
        }
        else if(addressType.contentEquals("existing"))
        {
            accountPage.createAccount("kumari+1234@gmail.com");
        }
    }

    @And("^click on create account entering valid email address$")
    public void clickOnCreateAccoutEnteringValidEmailAddress(){
        accountPage.createAccount(emailAddress);
    }

    @When("^user enter valid mandatory personal information$")
    public void userEnterValidMandatoryPersonalInformation() {
        accountPage.fillPersonalInformation();
    }

    @And("^click on Register$")
      public void clickOnRegisterbutton(){
        accountPage.clickRegisterButton();
    }

    @Then("^account should be created successfully$")
    public void accountShouldBeCreatedSuccessfully(){
        Assert.assertTrue(accountPage.getWelcomemessage().contentEquals(wMessage));
    }

    @Then("^error message should be displayed$")
    public void displayOfErrorMessage(){
        Assert.assertTrue(accountPage.verifyAlreadyRegisteredEmessage());
    }

    @When("^User click on login button entering valid login details$")
    public void userClickOnLoginButtonEnteringValidLoginDetails(){
        accountPage.login(loginUserName, loginPwd);
    }

    @Then("^user should successfully logged in$")
    public void userLoggedInSuccessfully(){
        Assert.assertTrue(accountPage.getWelcomemessage().contentEquals(wMessage));
    }

}
