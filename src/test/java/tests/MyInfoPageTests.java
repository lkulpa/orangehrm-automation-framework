package tests;

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