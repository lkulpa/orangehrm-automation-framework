package tests;

import page.LoginPage;
import page.MyInfoPage;
import page.admin.AdminPage;
import page.NavigationMenuPage;
import io.qameta.allure.Severity;
import page.admin.AddEmployeePage;
import org.testng.annotations.Test;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import io.qameta.allure.Description;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.*;

public class AdminPageTests extends BaseTestConfig {

    private LoginPage loginPage;
    private AdminPage adminPage;
    private MyInfoPage myInfoPage;
    private AddEmployeePage addEmployeePage;
    private NavigationMenuPage navigationMenuPage;

    @BeforeMethod
    @Description("This method logs in with a valid account and navigates to the Admin panel in preparation for Admin Page tests.")
    public void adminPageTestsSetup() {
        loginPage = new LoginPage();
        navigationMenuPage = new NavigationMenuPage();
        myInfoPage = new MyInfoPage();
        adminPage = new AdminPage();
        addEmployeePage = new AddEmployeePage();

        loginPage
                .loginWithAdminAccount();

        navigationMenuPage
                .navigateToAdminPage();
    }

    @Test
    @Tags({@Tag("regression"), @Tag("functional"), @Tag("essentials"), @Tag("system")})
    @Description("This tests attempts to create a new account with admin privileges through the Admin Panel")
    @Severity(SeverityLevel.NORMAL)
    public void addNewAdminAccountTest() {
        navigationMenuPage
                .navigateToMyInfoPage();

        String loggedInEmployeeFirstName = myInfoPage.getEmployeeFirstName();
        String loggedInEmployeeMiddleName = myInfoPage.getEmployeeMiddleName();
        String loggedInEmployeeLastName = myInfoPage.getEmployeeLastName();
        String username = loggedInEmployeeFirstName + (int) (Math.random() * 1000000);

        navigationMenuPage.navigateToAdminPage();

        adminPage
                .goToAddEmployeePage();

        addEmployeePage
                .selectUserRoleDropdownOption(2)
                .selectStatusDropdownOption(2)
                .enterEmployeeName(loggedInEmployeeFirstName)
                .selectEmployeeNameAutocompleteOption(loggedInEmployeeFirstName + " " + loggedInEmployeeMiddleName + " " + loggedInEmployeeLastName)
                .enterUsername(username)
                .enterPassword("SecretPassword123")
                .enterPasswordConfirmation("SecretPassword123")
                .clickSaveButton();

        assertTrue(addEmployeePage.isSuccessPopupVisible(), "No appropriate success message appeared");

        addEmployeePage
                .waitForFormLoaderToDisappear();

        adminPage
                .enterSearchInput(username)
                .clickSearchButton();

        assertEquals(adminPage.getSearchResultEmployeeName(), loggedInEmployeeFirstName + " " + loggedInEmployeeLastName);
        assertEquals(adminPage.getSearchResultUserRole(), "Admin");
        assertEquals(adminPage.getSearchResultStatus(), "Enabled");
    }
}