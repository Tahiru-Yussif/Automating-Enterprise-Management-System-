package tests.basetest;

import ArmsProject.util.AppConfig;
import ArmsProject.util.JsonDataReader;
import ArmsProject.util.Leaves.LeavesType;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import com.codeborne.selenide.Configuration;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

//    public WebDriver driver;
    public static String baseURL;
    public String leavePageURL;
    public static String username;
    public static String password;
    public static String leaveTypeName;
    protected  JsonNode jsonData;


    @BeforeClass
    public void setUp()  {
        // Set Selenide configuration
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";  // Set browser size instead of startMaximized
        Configuration.timeout = 10000;
        Configuration.baseUrl = AppConfig.getBaseURL();
        // Load URLs and other configurations from AppConfig
        baseURL = AppConfig.getBaseURL();
        leavePageURL = AppConfig.getLeavePageURL();
        username = AppConfig.getUsername();
        password = AppConfig.getPassword();
        leaveTypeName = LeavesType.getLeaveTypeName();
        // Load JSON data only once
//        jsonData = JsonDataReader.loadJsonData("src/main/resources/data/testData.json");
        try {
        jsonData = JsonDataReader.loadJsonData("src/main/resources/data/testData.json");
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Failed to load JSON data");
        }
    }

    @AfterSuite
    public void tearDown() {
        // Close the browser
        closeWebDriver();

        // Flush the ExtentReports
//        this.extent.flush();
    }
}
