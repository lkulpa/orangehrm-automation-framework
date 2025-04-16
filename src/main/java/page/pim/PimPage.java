package page.pim;


import io.qameta.allure.Step;
import page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

import static utils.ExplicitWaitUtils.waitForTextToBePresentInElement;
import static utils.SingletonDriver.getDriver;
import static utils.TextUtils.clearAndEnterTextInput;

public class PimPage extends BasePage {

    @FindBy(css = "div[class='orangehrm-header-container'] button")
    private WebElement addEmployeeButton;

    @FindBy(xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[2]/input")
    private WebElement employeeIdInput;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='oxd-table-card']/div/div[2]/div")
    private WebElement firstSearchResultEmployeeIdCell;

    @FindBy(xpath = "//div[@class='oxd-table-card']/div/div[3]/div")
    private WebElement firstSearchResultFirstAndMiddleNameCell;

    @FindBy(xpath = "//div[@class='oxd-table-card']/div/div[4]/div")
    private WebElement firstSearchResultLastNameCell;

    public PimPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step("user clicked the Add Employee button")
    public PimPage goToAddEmployeePage() {
        addEmployeeButton.click();
        logger.log(Level.INFO, "Clicked the '+ Add' button");
        return this;
    }

    @Step("user clicked the search button")
    public PimPage clickSearchButton() {
        searchButton.click();
        logger.log(Level.INFO, "Clicked the search button");
        return this;
    }

    @Step("user entered employee id in the search form: {employeeId}")
    public PimPage enterEmployeeIdInput(String employeeId) {
        clearAndEnterTextInput(employeeIdInput, employeeId);
        logger.log(Level.INFO, "Cleared employee Id input field and entered employee Id: {0}", employeeId);
        return this;
    }

    @Step("user searches the database by employee id: {employeeId}")
    public PimPage searchByEmployeeId(String employeeId) {
        enterEmployeeIdInput(employeeId);
        clickSearchButton();
        waitForTextToBePresentInElement(firstSearchResultEmployeeIdCell, employeeId);
        logger.log(Level.INFO, "Waited for the first search result to have Id value of: {0}", employeeId);
        return this;
    }

    @Step("retrieving first search result's first name value")
    public String getFirstSearchResultFirstName() {
        return firstSearchResultFirstAndMiddleNameCell.getText().split("\\s")[0];
    }

    @Step("retrieving first search result's middle name value")
    public String getFirstSearchResultMiddleName() {
        return firstSearchResultFirstAndMiddleNameCell.getText().split("\\s")[1];
    }

    @Step("retrieving first search result's last name value")
    public String getFirstSearchResultLastName() {
        return firstSearchResultLastNameCell.getText();
    }
}