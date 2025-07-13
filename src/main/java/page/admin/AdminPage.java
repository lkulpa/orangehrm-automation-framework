package page.admin;

import page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

import static utils.SingletonDriver.getDriver;

public class AdminPage extends BasePage {

    @FindBy(css = ".orangehrm-header-container button")
    private WebElement addEmployeeButton;

    @FindBy(xpath = "//label[text()='Username']/../..//input")
    private WebElement searchInput;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    @FindBy(css = ".oxd-table-body div div:nth-child(3) div")
    private WebElement userRoleSearchResultField;

    @FindBy(css = ".oxd-table-body div div:nth-child(4) div")
    private WebElement employeeNameSearchResultField;

    @FindBy(css = ".oxd-table-body div div:nth-child(5) div")
    private WebElement statusSearchResultField;

    public AdminPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step("user clicked the Add Employee button")
    public AdminPage goToAddEmployeePage() {
        addEmployeeButton.click();
        logger.log(Level.INFO, "Clicked the '+ Add' button");
        return this;
    }

    @Step("user enters text in the search input field: {searchPhrase}")
    public AdminPage enterSearchInput(String searchPhrase) {
        searchInput.sendKeys(searchPhrase);
        logger.log(Level.INFO, "Entered '{0}' in the search input field", searchPhrase);
        return this;
    }

    @Step("user click the search button")
    public AdminPage clickSearchButton() {
        searchButton.click();
        logger.log(Level.INFO, "Clicked the search button");
        return this;
    }

    @Step("retrieving search result user role")
    public String getSearchResultUserRole() {
        return userRoleSearchResultField.getText();
    }

    @Step("retrieving search result employee name")
    public String getSearchResultEmployeeName() {
        return employeeNameSearchResultField.getText();
    }

    @Step("retrieving search result status")
    public String getSearchResultStatus() {
        return statusSearchResultField.getText();
    }
}