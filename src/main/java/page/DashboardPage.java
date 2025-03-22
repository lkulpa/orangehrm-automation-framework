package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.SingletonDriver.getDriver;

public class DashboardPage {

    @FindBy(css = "li.oxd-userdropdown")
    private WebElement userDropdown;

    public DashboardPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isUserDropdownDisplayed() {
        return userDropdown.isDisplayed();
    }
}