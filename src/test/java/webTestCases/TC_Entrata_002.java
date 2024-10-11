package webTestCases;

import org.testng.annotations.Test;

public class TC_Entrata_002 extends BaseTest{
    @Test
    public void schedule_demo(){
        pageObjectManager.getDemoPage().clickScheduleDemo();
        pageObjectManager.getDemoPage().fillDemoForm();
    }
}
