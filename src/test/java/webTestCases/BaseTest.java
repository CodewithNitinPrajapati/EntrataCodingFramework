package webTestCases;

import com.entrata.core.PageObjectManager;
import com.entrata.core.WebDriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.entrata.core.ConfigReader;
import com.entrata.utils.FilePath;

public class BaseTest extends WebDriverFactory {

    protected PageObjectManager pageObjectManager;

    //setup before running any test class
    @BeforeClass
    public void setup(){
        getDriver(); //calling drive class
        pageObjectManager = new PageObjectManager(driver);
        driver.get(ConfigReader.getProperty(FilePath.configFilePath, "url"));//To launch the application
    }


    @AfterClass
    public void tearDown(){
        driver.quit(); // for closing all opened tab and window
    }
}
