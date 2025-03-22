package tests;

import page.LoginPage;
import page.DashboardPage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

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

    @Test
    public void verifyLoginTest() {
        loginPage
                .enterUsernameInput("Admin")
                .enterPasswordInput("admin123")
                .clickLoginButton();

        assertTrue(dashboardPage
                        .isUserDropdownDisplayed(),
                "FAIL: login attempt with valid credentials failed - cannot locate user dropdown menu");
    }

    @Test
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