package com.automationpractice.stepDefinitions;

import com.automationpractice.cucumber.TestContext;
import com.automationpractice.managers.FileReadManager;
import com.automationpractice.pageObjects.HomePage;
import com.automationpractice.util.CaptureScreenShort;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    TestContext testContext;
    HomePage homePage;

    public Hooks(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().gethomePage();
    }

    @Before
    public void setup() {
        logger.info("------Scenarios running on Environment :" + FileReadManager.getInstance().getConfigFileReader().getProfile() + "-----");

    }

    @After(order = 10)
    public void afterScenario(Scenario scenario) {
        logger.info(" Completed Scenarios ...." + scenario.getName());
        logger.info("Completed Scenario Status...." + scenario.getStatus());
        if (scenario.isFailed()) {
            String screenshotName = "" + System.currentTimeMillis();
            CaptureScreenShort.takeScreenshot(testContext.getWebDriverManager().getDriver(), screenshotName,scenario.getStatus());
        }
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        testContext.getWebDriverManager().closeDriver();
    }

}
