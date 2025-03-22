package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.time.Duration;

import static utils.SingletonDriver.getDriver;
import static utils.TextUtils.clearAndEnterTextInput;

public class MyInfoPage {

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "middleName")
    private WebElement middleNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(css = "span.oxd-checkbox-input")
    private WebElement firstCheckBox;

    @FindBy(css = ".--gender-grouped-field span")
    private List<WebElement> genderRadioButtons;

    @FindBy(css = "button[type='submit']:nth-child(2)")
    private WebElement personalDetailsSaveButton;

    @FindBy(css = "p.oxd-text--toast-title")
    private WebElement toastMessageTitle;

    @FindBy(css = "div.oxd-select-text")
    private WebElement nationalityDropdownSelect;

    @FindBy(css = "div[role='option'] span")
    private List<WebElement> dropdownSelectOptions;

    public MyInfoPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public MyInfoPage enterFirstNameInput(String firstName) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
        clearAndEnterTextInput(firstNameInput, firstName);
        return this;
    }

    public MyInfoPage enterMiddleNameInput(String middleName) {
        clearAndEnterTextInput(middleNameInput, middleName);
        return this;
    }

    public MyInfoPage enterLastNameInput(String lastName) {
        clearAndEnterTextInput(lastNameInput, lastName);
        return this;
    }

    public MyInfoPage clickFirstCheckBox() {
        firstCheckBox.click();
        return this;
    }

    public MyInfoPage clickGenderRadioButton(int choiceNumber) {
        genderRadioButtons.get(choiceNumber).click();
        return this;
    }

    public MyInfoPage clickSavePersonalDetailsButton() {
        personalDetailsSaveButton.click();
        return this;
    }

    public MyInfoPage selectNationalityDropdownOption(String nationality) {
        nationalityDropdownSelect.click();
        for (int i = 0; i < dropdownSelectOptions.size() - 1; i++) {
            WebElement nationalityDropdownOption = dropdownSelectOptions.get(i);
            String nationalityOptionText = nationalityDropdownOption.getText().toLowerCase();
            if (nationalityOptionText.equals(nationality.toLowerCase())) {
                nationalityDropdownOption.click();
                break;
            }
        }
        return this;
    }

    public String getToastMessageTitleText() {
        return toastMessageTitle.getText();
    }
}