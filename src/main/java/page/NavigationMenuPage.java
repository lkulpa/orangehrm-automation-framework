package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

import static utils.SingletonDriver.getDriver;

public class NavigationMenuPage extends BasePage {

    @FindBy(xpath = "//ul/li[6]/a")
    private WebElement myInfoButton;

    @FindBy(xpath = "//ul/li[2]/a")
    private WebElement pimButton;

    public NavigationMenuPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public NavigationMenuPage navigateToMyInfoPage() {
        myInfoButton.click();
        logger.log(Level.INFO, "Clicked My Info button in the navigation menu to go to My Info page");
        return this;
    }

    public NavigationMenuPage navigateToPimPage() {
        pimButton.click();
        logger.log(Level.INFO, "Clicked PIM button in the navigation menu to go to PIM page");
        return this;
    }
}