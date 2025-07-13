package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import io.qameta.allure.Description;
import io.qameta.allure.SeverityLevel;

import page.LoginPage;
import page.pim.PimPage;
import page.NavigationMenuPage;
import page.pim.AddEmployeePage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.*;
import static utils.DataGenerator.generateLastName;
import static utils.DataGenerator.generateFirstName;

public class PimPageTests extends BaseTestConfig {

    private PimPage pimPage;
    private LoginPage loginPage;
    private AddEmployeePage addEmployeePage;
    private NavigationMenuPage navigationMenuPage;

    @BeforeMethod
    @Description("This method logs in with a valid account and navigates to PIM Page in preparation for PIM Page tests.")
    public void pimPageTestsSetup() {
        loginPage = new LoginPage();
        navigationMenuPage = new NavigationMenuPage();
        pimPage = new PimPage();
        addEmployeePage = new AddEmployeePage();

        loginPage
                .loginWithAdminAccount();

        navigationMenuPage
                .navigateToPimPage();
    }

    @Test
    @Tags({@Tag("regression"), @Tag("functional"), @Tag("essentials"), @Tag("system")})
    @Description("This test attempts to add a new employee to the database. Fails if the newly added employee cannot be found in the database.")
    @Severity(SeverityLevel.NORMAL)
    public void addEmployeeTest() {
        pimPage.goToAddEmployeePage();

        String firstName = generateFirstName();
        String middleName = generateFirstName();
        String lastName = generateLastName();

        String employeeId = addEmployeePage.getEmployeeIdValue();

        addEmployeePage
                .enterFirstNameInput(firstName)
                .enterMiddleNameInput(middleName)
                .enterLastNameInput(lastName)
                .clickSaveButton()
                .waitForSuccessPopup();

        navigationMenuPage
                .navigateToPimPage();

        pimPage
                .searchByEmployeeId(employeeId);

        String searchResultFirstName = pimPage.getFirstSearchResultFirstName();
        String searchResultMiddleName = pimPage.getFirstSearchResultMiddleName();
        String searchResultLastName = pimPage.getFirstSearchResultLastName();

        assertEquals(searchResultFirstName, firstName, "First name does not match the search result");
        assertEquals(searchResultMiddleName, middleName, "Middle name does not match the search result");
        assertEquals(searchResultLastName, lastName, "Last name does not match the search result");
    }
}