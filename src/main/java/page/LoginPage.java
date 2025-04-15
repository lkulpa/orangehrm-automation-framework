package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

import static utils.SingletonDriver.getDriver;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = "p.oxd-alert-content-text")
    private WebElement loginErrorMessage;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step("user enters username: {username}")
    public LoginPage enterUsernameInput(String username) {
        usernameInput.sendKeys(username);
        logger.log(Level.INFO, "Entered username: {0}", username);
        return this;
    }

    @Step("user enters password: {password}")
    public LoginPage enterPasswordInput(String password) {
        passwordInput.sendKeys(password);
        logger.log(Level.INFO, "Entered password: {0}", password);
        return this;
    }

    @Step("user clicks the login button")
    public LoginPage clickLoginButton() {
        loginButton.click();
        logger.log(Level.INFO, "Clicked the login button");
        return this;
    }

    @Step("user enters username/password combination: {username}/{password}, and click the login button")
    public LoginPage login(String username, String password) {
        enterUsernameInput(username);
        enterPasswordInput(password);
        clickLoginButton();
        return this;
    }

    public String getLoginErrorMessageText() {
        return loginErrorMessage.getText();
    }
}