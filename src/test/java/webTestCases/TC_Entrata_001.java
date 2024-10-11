package webTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_Entrata_001 extends BaseTest{

    private String expectedTitle = "Property Management Software | Entrata";
    private String expectedURL = "https://www.entrata.com/b";

    @Test
    public void go_to_property_management() {
        String actualTitle = pageObjectManager.getHomePage().getPageTitle();
        String actualURL = pageObjectManager.getHomePage().getCurrentUrl();
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualURL, expectedURL);
        pageObjectManager.getHomePage().hoverOnProducts();
        pageObjectManager.getHomePage().clickPropertyManagement();
        //verify that after click user land on correct page
        Assert.assertEquals(pageObjectManager.getHomePage().getPageTitle(), "The Ultimate Property Management Software for Your Business.");
    }


}
