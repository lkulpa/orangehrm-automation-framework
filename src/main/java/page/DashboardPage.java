package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.SingletonDriver.getDriver;

public class DashboardPage extends BasePage {

    @FindBy(css = "li.oxd-userdropdown")
    private WebElement userDropdown;

    public DashboardPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step("checking if a static element of the Dashboard Page (User dropdown menu) is present")
    public boolean isUserDropdownDisplayed() {
        return userDropdown.isDisplayed();
    }
}