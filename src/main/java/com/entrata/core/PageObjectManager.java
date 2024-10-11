package com.entrata.core;

import org.openqa.selenium.WebDriver;
import com.entrata.pageObjects.BaseCampPage;
import com.entrata.pageObjects.DemoPage;
import com.entrata.pageObjects.HomePage;

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private DemoPage demoPage;
    private BaseCampPage baseCampPage;

    //defining a constructor
    public PageObjectManager(WebDriver driver){
        //initiated value to local driver
        this.driver = driver;
    }

    public HomePage getHomePage() {
        homePage = new HomePage(driver);
        return homePage;
    }
    public DemoPage getDemoPage() {
        demoPage = new DemoPage(driver);
        return demoPage;
    }

    public BaseCampPage getBaseCampPage() {
        baseCampPage = new BaseCampPage(driver);
        return baseCampPage;
    }
}
