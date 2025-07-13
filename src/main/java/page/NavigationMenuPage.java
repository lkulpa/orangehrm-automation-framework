package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

import static utils.SingletonDriver.getDriver;

public class NavigationMenuPage extends BasePage {

    @FindBy(xpath = "//ul/li[1]/a")
    private WebElement adminButton;

    @FindBy(xpath = "//ul/li[2]/a")
    private WebElement pimButton;

    @FindBy(xpath = "//ul/li[6]/a")
    private WebElement myInfoButton;


    public NavigationMenuPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step("user clicked Admin button in the navigation menu")
    public NavigationMenuPage navigateToAdminPage() {
        adminButton.click();
        logger.log(Level.INFO, "Clicked Admin button in the navigation menu to go to Admin page");
        return this;
    }

    @Step("user clicked PIM button in the navigation menu")
    public NavigationMenuPage navigateToPimPage() {
        pimButton.click();
        logger.log(Level.INFO, "Clicked PIM button in the navigation menu to go to PIM page");
        return this;
    }

    @Step("user clicked My Info button in the navigation menu")
    public NavigationMenuPage navigateToMyInfoPage() {
        myInfoButton.click();
        logger.log(Level.INFO, "Clicked My Info button in the navigation menu to go to My Info page");
        return this;
    }
}