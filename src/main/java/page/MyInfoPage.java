package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

import static utils.ExplicitWaitUtils.*;
import static utils.SingletonDriver.getDriver;
import static utils.TextUtils.clearAndEnterTextInput;

public class MyInfoPage extends BasePage {

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "middleName")
    private WebElement middleNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(css = "span.oxd-checkbox-input")
    private WebElement firstCheckBox;

    @FindBy(className = "oxd-radio-input")
    private List<WebElement> genderRadioButtons;

    @FindBy(css = "button[type='submit']:nth-child(2)")
    private WebElement personalDetailsSaveButton;

    @FindBy(css = "p.oxd-text--toast-title")
    private WebElement toastMessageTitle;

    @FindBy(css = "div.oxd-select-text")
    private WebElement nationalityDropdownMenu;

    @FindBy(css = "div[role='option'] span")
    private List<WebElement> nationalityDropdownMenuOptions;

    @FindBy(className = "oxd-form-loader")
    private WebElement formLoader;

    public MyInfoPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step("waiting for the form to load")
    public MyInfoPage waitForFormToLoad() {
        waitForElementToDisappear(formLoader);
        logger.log(Level.INFO, "Waited for the form to load");
        return this;
    }

    @Step("user enters first name: {firstName}")
    public MyInfoPage enterFirstNameInput(String firstName) {
        clearAndEnterTextInput(firstNameInput, firstName);
        logger.log(Level.INFO, "Cleared first name input field and entered first name: {0}", firstName);
        return this;
    }

    @Step("user enters middle name: {middleName}")
    public MyInfoPage enterMiddleNameInput(String middleName) {
        clearAndEnterTextInput(middleNameInput, middleName);
        logger.log(Level.INFO, "Cleared middle name input field and entered middle name: {0}", middleName);
        return this;
    }

    @Step("user enters last name: {lastName}")
    public MyInfoPage enterLastNameInput(String lastName) {
        clearAndEnterTextInput(lastNameInput, lastName);
        logger.log(Level.INFO, "Cleared last name input field and entered last name: {0}", lastName);
        return this;
    }

    @Step("user clicks first check box")
    public MyInfoPage clickFirstCheckBox() {
        firstCheckBox.click();
        logger.log(Level.INFO, "Clicked first check box");
        return this;
    }

    @Step("user clicks gender radio button #{choiceNumber}")
    public MyInfoPage clickGenderRadioButton(int choiceNumber) {
        waitForElementToBeClickable(genderRadioButtons.get(choiceNumber - 1)).click();
        logger.log(Level.INFO, "Clicked gender radio button #{0}", choiceNumber);
        return this;
    }

    @Step("user clicks save button on the Personal Details form")
    public MyInfoPage clickSavePersonalDetailsButton() {
        personalDetailsSaveButton.click();
        logger.log(Level.INFO, "Clicked Personal Details save button");
        return this;
    }

    @Step("user selects nationality from the dropdown menu: {nationality}")
    public MyInfoPage selectNationalityDropdownOption(String nationality) {
        nationalityDropdownMenu.click();
        logger.log(Level.INFO, "Clicked nationality dropdown menu to show available options");
        for (int i = 0; i < nationalityDropdownMenuOptions.size() - 1; i++) {
            WebElement nationalityDropdownOption = nationalityDropdownMenuOptions.get(i);
            String nationalityOptionText = nationalityDropdownOption.getText().toLowerCase();
            if (nationalityOptionText.equals(nationality.toLowerCase())) {
                nationalityDropdownOption.click();
                break;
            }
        }
        logger.log(Level.INFO, "Searched for '{0}' option in the nationality dropdown menu and clicked it", nationality);
        return this;
    }

    @Step("retrieving title text from a Toast popup")
    public String getToastMessageTitleText() {
        return toastMessageTitle.getText();
    }


    @Step("retrieving employee first name from My Info page")
    public String getEmployeeFirstName() {
        waitForElementToHaveText(firstNameInput);
        return Objects.requireNonNull(firstNameInput.getDomProperty("value")).trim();
    }

    @Step("retrieving employee middle name from My Info page")
    public String getEmployeeMiddleName() {
        waitForElementToHaveText(middleNameInput);
        return Objects.requireNonNull(middleNameInput.getDomProperty("value")).trim();
    }

    @Step("retrieving employee last name from My Info page")
    public String getEmployeeLastName() {
        waitForElementToHaveText(lastNameInput);
        return Objects.requireNonNull(lastNameInput.getDomProperty("value")).trim();
    }
}