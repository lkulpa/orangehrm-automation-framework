package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static utils.SingletonDriver.closeDriver;
import static utils.SingletonDriver.getDriver;

public class BaseTestConfig {

    @BeforeMethod
    public void beforeMethod() {
        getDriver().manage().window().maximize();
        getDriver().navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterMethod
    public void afterMethod() {
        closeDriver();
    }
}