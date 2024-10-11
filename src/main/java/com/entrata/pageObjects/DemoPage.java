package com.entrata.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.entrata.utils.SeleniumUtility;

public class DemoPage extends SeleniumUtility {

    private WebDriver driver;
    private static String parentWindowID;

    public DemoPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By scheduleDemoBtn = By.xpath("//div[@class='black_btn-text-2']/parent::a[contains(@href,'schedule-demo.html')]");
    private By firstName = By.name("FirstName");
    private By lastName = By.id("LastName");
    private By emailId = By.cssSelector("input[id='Email']");
    private By companyName = By.id("Company");
    private By phoneNumber = By.id("Phone");
    private By unitCount = By.id("Unit_Count__c");
    private By jobTitle = By.xpath("//input[@placeholder='Job Title']");
    private By demoFor = By.xpath("//select[@name='demoRequest']");

    public void clickScheduleDemo(){
        performPageAction("click", driver.findElement(scheduleDemoBtn), "scheduleDemoButton");
        parentWindowID = switchToChildWindow(); // switch to child window
        String demoPageTitle = getPageTitle();
        Assert.assertEquals(demoPageTitle, "Entrata | Property Management the Way It Should Be"); //Verify title of child window
    }

    public void fillDemoForm(){
        //Fill data for demo
        performPageAction("sendKeys", driver.findElement(firstName), "Nitin");
        performPageAction("sendKeys", driver.findElement(lastName), "Prajapati");
        performPageAction("sendKeys", driver.findElement(emailId), "nitinprajapati@yopmail.com");
        performPageAction("sendKeys", driver.findElement(companyName), "Nitin Prajapati");
        performPageAction("sendKeys", driver.findElement(phoneNumber), "1234567890");
        selectOptionFromDropDown(driver.findElement(unitCount), "11 - 100");  //selecting value from drop down list
        performPageAction("sendKeys", driver.findElement(jobTitle), "Nitin Prajapati");
        selectOptionFromDropDown(driver.findElement(demoFor), "a Resident");
        switchToParentWindow(parentWindowID); //switch back to parent window
    }

}
