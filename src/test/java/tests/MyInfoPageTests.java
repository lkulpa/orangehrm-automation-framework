package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import page.LoginPage;
import page.MyInfoPage;
import page.NavigationMenuPage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.*;

public class MyInfoPageTests extends BaseTestConfig {

    private LoginPage loginPage;
    private MyInfoPage myInfoPage;
    private NavigationMenuPage navigationMenuPage;

    @BeforeMethod
    @Description("This method logs in with a valid account and navigates to My Info Page in preparation for My Info Page tests.")
    public void myInfoPageTestsSetup() {
        loginPage = new LoginPage();
        myInfoPage = new MyInfoPage();
        navigationMenuPage = new NavigationMenuPage();

        loginPage
                .login("Admin", "admin123");

        navigationMenuPage
                .navigateToMyInfoPage();
    }

    @Test
    @Description("This tests attempts to edit employee's Personal Details and save the changes. Fails if a success popup does not appear after clicking the Save button.")
    @Severity(SeverityLevel.NORMAL)
    public void editPersonalDetailsTest() {
        myInfoPage.enterFirstNameInput("Janna2")
                .enterMiddleNameInput("Janina2")
                .enterLastNameInput("Kowalska2")
                .clickFirstCheckBox()
                .clickGenderRadioButton(1)
                .selectNationalityDropdownOption("Polish")
                .clickSavePersonalDetailsButton();

        assertEquals(myInfoPage
                        .getToastMessageTitleText(),
                "Success",
                "Error: unexpected toast message title.");
    }
}