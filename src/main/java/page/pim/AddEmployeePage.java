package page.pim;

import io.qameta.allure.Step;
import page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

import static utils.SingletonDriver.getDriver;
import static utils.TextUtils.clearAndEnterTextInput;
import static utils.ExplicitWaitUtils.waitForElementToBeVisible;

public class AddEmployeePage extends BasePage {

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "middleName")
    private WebElement middleNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(css = "button[type='submit']")
    private WebElement saveButton;

    @FindBy(css = "div[class='oxd-grid-2 orangehrm-full-width-grid'] input")
    private WebElement employeeIdInput;

    @FindBy(css = "div.oxd-toast--success")
    private WebElement toastSuccessMessage;

    public AddEmployeePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step("user enters first name: {firstName}")
    public AddEmployeePage enterFirstNameInput(String firstName) {
        clearAndEnterTextInput(firstNameInput, firstName);
        logger.log(Level.INFO, "Cleared first name input field and entered first name: {0}", firstName);
        return this;
    }

    @Step("user enters middle name: {middleName}")
    public AddEmployeePage enterMiddleNameInput(String middleName) {
        clearAndEnterTextInput(middleNameInput, middleName);
        logger.log(Level.INFO, "Cleared middle name input field and entered middle name: {0}", middleName);
        return this;
    }

    @Step("user enters last name: {lastName}")
    public AddEmployeePage enterLastNameInput(String lastName) {
        clearAndEnterTextInput(lastNameInput, lastName);
        logger.log(Level.INFO, "Cleared last name input field and entered last name: {0}", lastName);
        return this;
    }

    @Step("user clicks the Save button")
    public AddEmployeePage clickSaveButton() {
        saveButton.click();
        logger.log(Level.INFO, "Clicked the save button");
        return this;
    }

    @Step("retrieving auto-generated employee id value")
    public String getEmployeeIdValue() {
        return employeeIdInput.getDomProperty("value");
    }

    @Step("waiting for success toast message popup")
    public AddEmployeePage waitForSuccessPopup() {
        waitForElementToBeVisible(toastSuccessMessage);
        logger.log(Level.INFO, "Waited for success toast message popup");
        return this;
    }
}