package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.SingletonDriver.getDriver;

public class NavigationMenuPage {

    @FindBy(xpath = "//ul/li[6]/a")
    private WebElement myInfoButton;

    @FindBy(xpath = "//ul/li[2]/a")
    private WebElement pimButton;

    public NavigationMenuPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public NavigationMenuPage navigateToMyInfoPage() {
        myInfoButton.click();
        return this;
    }

    public NavigationMenuPage navigateToPimPage() {
        pimButton.click();
        return this;
    }
}