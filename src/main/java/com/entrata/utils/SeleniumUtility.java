package com.entrata.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class SeleniumUtility {

    private WebDriver driver;
    public Logger log = LogManager.getLogger(this.getClass().getName());
    protected WebDriverWait wait;

    protected SeleniumUtility(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /**
     * Method to get the current URL of the page
     *
     * @return
     */
    public String getCurrentUrl() {
        String actualPageUrl = "";
        try {
            log.info("Getting the current url of the page");
            actualPageUrl = driver.getCurrentUrl();
        } catch (NullPointerException exp) {
            log.error("NullPointerException : Driver has no object/Driver scope is not defined correctly!!!");
            exp.printStackTrace();
        }
        return actualPageUrl;
    }

    /**
     * Method to get the current window title of the page
     */
    public String getPageTitle() {
        String actualTitle = "";
        try {
            log.info("Getting the title of the page");
            actualTitle = driver.getTitle();
        } catch (NullPointerException exp) {
            log.error("NullPointerException : Driver has no object/Driver scope not defined correctly!!!");
            exp.printStackTrace();
        }
        return actualTitle;
    }

    /**
     * Method to return text of given element
     *
     * @param element
     * @return
     */
    public String getElementText(WebElement element) {
        String actualText = "";
        try {
            actualText = element.getText();
        } catch (NoSuchElementException exp) {
            log.error("NoSuchElementException : There is no such element in DOM!!!");
            exp.printStackTrace();
        }
        return actualText;
    }

    /**
     * Method to select value from drop down list
     *
     * @param element
     * @param option
     */
    public void selectOptionFromDropDown(WebElement element, String option) {
        Select select = new Select(element);
        select.selectByVisibleText(option);
        log.info("Option " + option + " selected from drop down successfully");
    }

    /**
     * Method to perform hovering on the element
     *
     * @param element
     */
    public void mouseHover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        log.info("Hovering over the mouse on the element " + element);
    }

    /**
     * Performs the javascript click on the given element
     *
     * @param element is the WebElement Reference
     */
    public void clickJs(WebElement element) {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", element);
            log.info("Clicked on the element " + element + " using JavaScript");
        } catch (JavascriptException exp) {
            log.error("JavascriptException!!!");
            exp.printStackTrace();
        }
    }

    /**
     * Method for all webdriver element operation
     *
     * @param actionType action to be performed
     * @param element
     * @param value      value needs to be entered or used
     */
    public void performPageAction(String actionType, WebElement element, String value) {
        switch (actionType) {
            case "clear":
                try {
                    element.clear();
                } catch (NoSuchElementException exp) {
                    log.error("NoSuchElementException : There is no such element in DOM!!!");
                    exp.printStackTrace();
                }
                break;
            case "click":
                try {
                    element.click();
                    log.info(value + " clicked successfully");
                } catch (NoSuchElementException exp) {
                    log.error("NoSuchElementException : There is no such element in DOM!!!");
                    exp.printStackTrace();
                } catch (ElementNotInteractableException exp) {
                    log.info("ElementClickInterceptedException : Hence, performing click action using JavaScriptExecutor");
                    clickJs(element);
                }
                break;
            case "sendKeys":
                try {
                    element.sendKeys(value);
                    log.info(value + " entered successfully");
                } catch (NoSuchElementException exp) {
                    log.error("NoSuchElementException : There is no such element in DOM!!!");
                    exp.printStackTrace();
                }
                break;
        }
    }

    /**
     * Method to switch to a parent window
     *
     * @param parentWindowId the id of the parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.close();
        driver.switchTo().window(parentWindowId);
        log.info("driver scope switched to parent window : " + parentWindowId);
    }
    public String switchToChildWindow() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        String parentWindowId = itr.next();
        //switch to child window
        driver.switchTo().window(itr.next());
        log.info("driver scope switched to child window");
        return parentWindowId;
    }

    /**
     * Performs scroll into view of the element using javascript
     * @param element is the WebElement Reference
     */
    public void scrollToElementJavascript(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(arguments[1]);", element, true);
        log.info("Scrolling to the element " + element + "using JavaScript");
    }
}