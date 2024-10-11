package com.entrata.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.entrata.utils.SeleniumUtility;

public class HomePage extends SeleniumUtility {
    private WebDriver driver;

    private By productsLink = By.id("w-dropdown-toggle-0");
    private By footerNav = By.className("footer-nav");
    private By propertyManagement = By.xpath("//div[@class='mega-nav desktop']/div/a/h3[text()='Property Management']");

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void hoverOnProducts() {
        mouseHover(driver.findElement(productsLink));
    }

    public void clickPropertyManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(propertyManagement)); //wait until element will be clickable
        performPageAction("click", driver.findElement(propertyManagement), "propertyManagement");
    }
}
