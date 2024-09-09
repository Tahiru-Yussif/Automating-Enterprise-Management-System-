package tests.Leaves.Settings;

import ArmsProject.util.leaveBase;
import ArmsProject.pages.Leaves.LeaveTypePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.basetest.BaseTest;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class LeavesType extends BaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        leaveBase.performLeaveHomePageTest(baseURL, username, password, leavePageURL);
    }

    @Test(description = "test description")
    public void performAddLeaveTypeTest() {
        // Retrieve test data
        String leaveTypeNames = jsonData.get("textFields").get("textFieldName").asText();
        String leaveTypeDescription = jsonData.get("textFields").get("textFieldDescription").asText();

        // instantiate LeavePage
        LeaveTypePage leaveTypePage = new LeaveTypePage();
        leaveTypePage.settingItemButton();

        // Perform add leave type action
        leaveTypePage.clickAddLeaveTypeButton();

        // Interact with the text fields.
        leaveTypePage.addLeaveTypeName(leaveTypeNames);
        leaveTypePage.addLeaveTypeDescription(leaveTypeDescription);

        // Select the first option from the dropdown
        leaveTypePage.selectOrganisation();

        sleep(2000);

        Assert.assertEquals(url(), leavePageURL + "leave-type", "URLS doesn't match");
    }
}
