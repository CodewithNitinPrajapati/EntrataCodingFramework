package com.entrata.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.entrata.utils.FilePath;

import java.time.Duration;

public class WebDriverFactory {

    protected WebDriver driver;

    //We didn't want to change these value during the execution, so marked as final
    private final String executionType_maven = System.getProperty("execution");
    private final String executionType = executionType_maven !=null ? executionType_maven : ConfigReader.getProperty(FilePath.configFilePath, "executionType");
    private final String browserType_maven = System.getProperty("browser");
    private final String browserType = browserType_maven != null ? browserType_maven : ConfigReader.getProperty(FilePath.configFilePath, "browserType");


    protected void getDriver(){
        if (driver == null){
            driver = createNewDrive();
        }
    }

    private WebDriver createNewDrive(){
        switch (executionType){
            case "LOCAL":
                driver = createLocalDriver();
                break;
            case "REMOTE":
                driver = createRemoteDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + executionType);
        }
        return driver;
    }
    //Create local driver to run the test cases locally on browsers
    private WebDriver createLocalDriver(){
        switch (browserType) {
            case "Chrome":
               WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.chromedriver().setup();
                driver = new FirefoxDriver();
                break;
            case "Edge":
                WebDriverManager.chromedriver().setup();
                driver = new EdgeDriver();
                break;

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //define an implicitly wait for loading dom
        driver.manage().window().maximize();  // Maximize the window size
        return driver;
    }

    //Create remote driver to run the test cases remotely
    private WebDriver createRemoteDriver(){
        switch (browserType) {
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                options.addArguments("headless"); //
                options.addArguments("window-size=1200x600");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case "Firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                firefoxOptions.addArguments("headless"); //
                firefoxOptions.addArguments("window-size=1200x600");
                driver = new FirefoxDriver();
                break;
            case "Edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                edgeOptions.addArguments("headless"); //
                edgeOptions.addArguments("window-size=1200x600");
                driver = new EdgeDriver();
                break;

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

}
