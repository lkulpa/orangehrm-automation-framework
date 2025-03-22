package page.pim;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.SingletonDriver.getDriver;
import static utils.TextUtils.clearAndEnterTextInput;

public class PimPage {

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

    public PimPage goToAddEmployeePage() {
        addEmployeeButton.click();
        return this;
    }

    public PimPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public PimPage enterEmployeeIdInput(String employeeId) {
        clearAndEnterTextInput(employeeIdInput, employeeId);
        return this;
    }

    public String getFirstSearchResultEmployeeId() {
        return firstSearchResultEmployeeIdCell.getText();
    }

    public String getFirstSearchResultFirstName() {
        return firstSearchResultFirstAndMiddleNameCell.getText().split("\\s")[0];
    }

    public String getFirstSearchResultMiddleName() {
        return firstSearchResultFirstAndMiddleNameCell.getText().split("\\s")[1];
    }

    public String getFirstSearchResultLastName() {
        return firstSearchResultLastNameCell.getText();
    }
}