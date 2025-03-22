package page.pim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static utils.SingletonDriver.getDriver;
import static utils.TextUtils.clearAndEnterTextInput;

public class AddEmployeePage {

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

    public AddEmployeePage enterFirstNameInput(String firstName) {
        clearAndEnterTextInput(firstNameInput, firstName);
        return this;
    }

    public AddEmployeePage enterMiddleNameInput(String middleName) {
        clearAndEnterTextInput(middleNameInput, middleName);
        return this;
    }

    public AddEmployeePage enterLastNameInput(String lastName) {
        clearAndEnterTextInput(lastNameInput, lastName);
        return this;
    }

    public AddEmployeePage clickSaveButton() {
        saveButton.click();
        return this;
    }

    public String getEmployeeIdValue() {
        return employeeIdInput.getDomProperty("value");
    }

    public void waitForSuccessPopup() {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(toastSuccessMessage));
    }
}