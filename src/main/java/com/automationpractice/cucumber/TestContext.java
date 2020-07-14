package com.automationpractice.cucumber;

import com.automationpractice.managers.PageObjectManager;
import com.automationpractice.managers.WebDriverManager;



public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;

    public TestContext(){
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager(){ return webDriverManager;}

    public PageObjectManager getPageObjectManager(){ return pageObjectManager;}
}
