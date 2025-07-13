package page.admin;

import page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Level;

import static utils.ExplicitWaitUtils.*;
import static utils.SingletonDriver.getDriver;
import static utils.TextUtils.clearAndEnterTextInput;

public class AddEmployeePage extends BasePage {

    @FindBy(css = "form > div > div > div:nth-child(1) .oxd-select-text-input")
    private WebElement userRoleDropdownMenu;

    @FindBy(css = "form > div > div > div:nth-child(3) .oxd-select-text-input")
    private WebElement statusDropdownMenu;

    @FindBy(className = "oxd-select-option")
    private List<WebElement> dropdownMenuOptions;

    @FindBy(css = "input[placeholder='Type for hints...']")
    private WebElement employeeNameInput;

    @FindBy(xpath = "//div[text()='Searching....']")
    private WebElement autocompleteLoadingCue;

    @FindBy(css = ".oxd-autocomplete-option span")
    private List<WebElement> employeeNameAutocompleteOptions;

    @FindBy(className = "oxd-userdropdown-name")
    private WebElement userDropdownMenuText;

    @FindBy(xpath = "//label[text()='Username']/../..//input")
    private WebElement usernameInput;

    @FindBy(xpath = "//label[text()='Password']/../..//input")
    private WebElement passwordInput;

    @FindBy(xpath = "//label[text()='Confirm Password']/../..//input")
    private WebElement confirmPasswordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement saveButton;

    @FindBy(css = "div.oxd-toast--success")
    private WebElement toastSuccessMessage;

    @FindBy(className = "oxd-form-loader")
    private WebElement formLoader;

    public AddEmployeePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step("user selects option #{optionNumber} from the User Role dropdown menu")
    public AddEmployeePage selectUserRoleDropdownOption(int optionNumber) {
        userRoleDropdownMenu.click();
        dropdownMenuOptions.get(optionNumber - 1).click();
        logger.log(Level.INFO, "Selected option #{0} in the User Role dropdown menu", optionNumber);
        return this;
    }

    @Step("user selects option #{optionNumber}")
    public AddEmployeePage selectStatusDropdownOption(int optionNumber) {
        statusDropdownMenu.click();
        dropdownMenuOptions.get(optionNumber - 1).click();
        logger.log(Level.INFO, "Selected option #{0} in the User Role dropdown menu", optionNumber);
        return this;
    }

    @Step("user enters employee name: {employeeName}")
    public AddEmployeePage enterEmployeeName(String employeeName) {
        clearAndEnterTextInput(employeeNameInput, employeeName);
        logger.log(Level.INFO, "Cleared employee name input field and entered text: {0}", employeeName);
        return this;
    }

    @Step("user selects employee name from autocomplete options: {employeeName}")
    public AddEmployeePage selectEmployeeNameAutocompleteOption(String employeeName) {
        waitForElementToDisappear(autocompleteLoadingCue);
        for (WebElement option : employeeNameAutocompleteOptions) {
            if (option.getText().equalsIgnoreCase(employeeName)) {
                option.click();
                break;
            }
        }
        logger.log(Level.INFO, "Waited for autocomplete options to appear and selected: {0}", employeeName);
        return this;
    }

    @Step("user enters username: {username}")
    public AddEmployeePage enterUsername(String username) {
        clearAndEnterTextInput(usernameInput, username);
        logger.log(Level.INFO, "Cleared username input field and entered username: {0}", username);
        return this;
    }

    @Step("user enters password in the first password input field: {password}")
    public AddEmployeePage enterPassword(String password) {
        clearAndEnterTextInput(passwordInput, password);
        logger.log(Level.INFO, "Cleared password input field and entered password: {0}", password);
        return this;
    }

    @Step("user enters password again in the 'confirm password' input field: {password}")
    public AddEmployeePage enterPasswordConfirmation(String password) {
        clearAndEnterTextInput(confirmPasswordInput, password);
        logger.log(Level.INFO, "Cleared password input field and entered password: {0}", password);
        return this;
    }

    @Step("user clicks the Save button")
    public AddEmployeePage clickSaveButton() {
        saveButton.click();
        logger.log(Level.INFO, "Clicked the save button");
        return this;
    }

    @Step("waiting for success toast message popup")
    public boolean isSuccessPopupVisible() {
        boolean outcome;
        try {
            waitForElementToBeVisible(toastSuccessMessage);
            outcome = true;
        } catch (TimeoutException e) {
            outcome = false;
        }
        logger.log(Level.INFO, "Waited for success toast message popup");
        return outcome;
    }

    @Step("waiting for form loader to disappear")
    public AddEmployeePage waitForFormLoaderToDisappear() {
        waitForElementToDisappear(formLoader);
        return this;
    }
}