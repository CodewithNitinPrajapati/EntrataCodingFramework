package webTestCases;


import org.testng.annotations.Test;

public class TC_Entrata_003 extends BaseTest {
    @Test
    public void register_user_for_base_camp() throws InterruptedException {
        pageObjectManager.getBaseCampPage().clickBaseCamp();
        pageObjectManager.getBaseCampPage().clickRegisterBtn();
        pageObjectManager.getBaseCampPage().verifyPersonalInformationText();
        pageObjectManager.getBaseCampPage().fillRegistrationForm("India", "Madhya Pradesh");
    }
}
