package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import io.qameta.allure.Description;
import io.qameta.allure.SeverityLevel;

import page.LoginPage;
import page.MyInfoPage;
import page.NavigationMenuPage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.*;
import static utils.DataGenerator.generateLastName;
import static utils.DataGenerator.generateFirstName;

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
    @Tags({@Tag("regression"), @Tag("functional"), @Tag("essentials"), @Tag("system")})
    @Description("This tests attempts to edit employee's Personal Details and save the changes. Fails if a success popup does not appear after clicking the Save button.")
    @Severity(SeverityLevel.NORMAL)
    public void editPersonalDetailsTest() {

        myInfoPage
                .waitForFormToLoad()
                .enterFirstNameInput(generateFirstName())
                .enterMiddleNameInput(generateFirstName())
                .enterLastNameInput(generateLastName())
                .clickFirstCheckBox()
                .clickGenderRadioButton(0)
                .selectNationalityDropdownOption("Polish")
                .clickSavePersonalDetailsButton();

        assertEquals(myInfoPage
                        .getToastMessageTitleText(),
                "Success",
                "Error: unexpected toast message title.");
    }
}