package com.entrata.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.entrata.utils.SeleniumUtility;

public class BaseCampPage extends SeleniumUtility {

    protected WebDriver driver;
    protected static String parentWindowID;

    public BaseCampPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By baseCamp = By.xpath("//a[@href='https://basecamp.entrata.com/']");
    private By registerBtn = By.className("basecamp-register-button-text");
    private By personalInfoText = By.cssSelector("h2[data-cvent-id='IdentityConfirmation-headerText']");
    private By firstName = By.xpath("//input[@aria-label='First name']");
    private By lastName = By.xpath("//input[@aria-label='Last name']");
    private By company = By.xpath("//input[@aria-label='Company']");
    private By title = By.xpath("//input[@aria-label='Title']");
    private By eamailAddress = By.xpath("//input[@aria-label='Email address']");
    private By mobile = By.xpath("//input[@aria-label='Mobile']");
    private By address1 = By.xpath("//input[@aria-label='Address 1']");
    private By country = By.id("react-select-2-placeholder");
    private By city = By.xpath("//input[@aria-label='City']");
    private By state = By.id("react-select-3-placeholder");
    private By pinCode = By.xpath("//input[@aria-label='ZIP/Postal Code']");


    public void clickBaseCamp(){
        performPageAction("click", driver.findElement(baseCamp), "baseCamp");
        parentWindowID = switchToChildWindow(); // Move to child window
        String actualPageURL = getCurrentUrl(); //getting actual page url
        Assert.assertEquals(actualPageURL, "https://basecamp.entrata.com/"); //Verify url of child window
    }
    public void clickRegisterBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn)); //wait for element ot be clickable
        performPageAction("click", driver.findElement(registerBtn), "registerBtn"); //click on Register button
        Assert.assertTrue(getPageTitle().contains("Personal Information - Base Camp 2025")); //Verify page title
    }
    public void verifyPersonalInformationText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalInfoText)); //wait for personal information text should be present on page
        log.info(getElementText(driver.findElement(personalInfoText)));
    }
    public void fillRegistrationForm(String countryName, String stateName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)); //wait for element visible on dom
        //Fill all details in the form
        performPageAction("sendKeys", driver.findElement(firstName),"Nitin");
        performPageAction("sendKeys", driver.findElement(lastName),"Prajapati");
        performPageAction("sendKeys", driver.findElement(company),"XYZ Company");
        performPageAction("sendKeys", driver.findElement(title),"Software Engineer");
        performPageAction("sendKeys", driver.findElement(eamailAddress),"nitinprajpati@yopmail.com");
        performPageAction("sendKeys", driver.findElement(mobile),"1234567890");
        performPageAction("sendKeys", driver.findElement(address1),"Noida");
        performPageAction("click", driver.findElement(country),"");
        WebElement india = driver.findElement(By.xpath("//div[text()='"+countryName+"']"));

        wait.until(ExpectedConditions.visibilityOf(india)); //wait for element is visible
        scrollToElementJavascript(india); //scroll till element
        performPageAction("click", india,countryName);
        performPageAction("sendKeys", driver.findElement(city),"Noida");
        performPageAction("click", driver.findElement(state),"");
        WebElement up = driver.findElement(By.xpath("//div[text()='"+stateName+"']"));

        wait.until(ExpectedConditions.visibilityOf(up)); //wait for element is visible
        scrollToElementJavascript(up); //scroll till element
        performPageAction("click", up,stateName);
        performPageAction("sendKeys", driver.findElement(pinCode),"201303");

    }
}
