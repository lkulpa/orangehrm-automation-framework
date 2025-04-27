package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import io.qameta.allure.Description;
import io.qameta.allure.SeverityLevel;

import page.LoginPage;
import page.DashboardPage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import utils.PropertiesReader;

import static org.testng.Assert.*;
import static utils.SingletonDriver.getDriver;

public class LoginPageTests extends BaseTestConfig {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void loginPageTestsSetup() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }

    @Test(testName = "Valid login attempt verification")
    @Tags({@Tag("regression"), @Tag("functional"), @Tag("authentication")})
    @Description("This test attempts to log into the website using valid login and password of an existing account. Fails if doesn't end up on the Dashboard page after clicking the Login button.")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginTest() {

        loginPage
                .enterUsernameInput(PropertiesReader.get("validUsername"))
                .enterPasswordInput(PropertiesReader.get("validPassword"))
                .clickLoginButton();

        assertTrue(dashboardPage
                        .isUserDropdownDisplayed(),
                "FAIL: login attempt with valid credentials failed - cannot locate user dropdown menu");
    }

    @Test
    @Tags({@Tag("regression"), @Tag("functional"), @Tag("authentication")})
    @Description("This test attempts to log into the website using invalid login and password. Fails if ends up on the Dashboard page or an incorrect error message appears.")
    @Severity(SeverityLevel.CRITICAL)
    public void invalidLoginTest() {
        loginPage
                .login("invalidusername", "badpassword123");

        assertEquals(loginPage
                        .getLoginErrorMessageText(),
                "Invalid credentials",
                "FAIL: Appropriate error message was not found");

        assertNotEquals(getDriver()
                        .getCurrentUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",
                "FAIL: logged in with invalid credentials");
    }
}