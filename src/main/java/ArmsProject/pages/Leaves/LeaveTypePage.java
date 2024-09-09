package ArmsProject.pages.Leaves;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.cssSelector;

public class LeaveTypePage {
    private final SelenideElement addLeaveTypeButton = $(cssSelector("[data-cy='addLeaveType']"));
    private final SelenideElement settingsItem = $(cssSelector("[data-cy='settingsItem']"));
    private final SelenideElement leaveTypeName = $(cssSelector("input[data-cy='name']"));
    private final SelenideElement leaveTypeDescription = $(cssSelector("textarea[data-cy='description']"));
    private final SelenideElement organisationDropdown = $(cssSelector("[data-cy='organisation']"));
    private final SelenideElement firstOption = $(cssSelector("[data-cy='dropDownList'] > div:nth-child(3)"));


    public void clickAddLeaveTypeButton() {
        addLeaveTypeButton.click();
    }

    public void settingItemButton() {
        settingsItem.click();
    }

    public void addLeaveTypeName(String name) {
        String LeaveTypeNameValue = name + " " + System.currentTimeMillis();
        leaveTypeName.shouldBe(visible).click();
        leaveTypeName.setValue(LeaveTypeNameValue);
        leaveTypeName.shouldHave(value(LeaveTypeNameValue));
    }

    public void addLeaveTypeDescription(String description) {
        leaveTypeDescription.shouldBe(visible).click();
        leaveTypeDescription.setValue(description);
        leaveTypeDescription.shouldHave(value(description));
    }

    public void selectOrganisation() {
        organisationDropdown.shouldBe(visible).click();
        firstOption.shouldBe(visible, Duration.ofSeconds(5)).click();
        firstOption.shouldHave(value(firstOption.text()));
        System.out.println(firstOption.getText());
    }
}
