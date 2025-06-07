package tests;

import org.testng.ITestResult;
import utils.PropertiesReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Path;
import java.time.Duration;

import static utils.SingletonDriver.getDriver;
import static utils.SingletonDriver.closeDriver;

public class BaseTestConfig {

    @BeforeClass
    public void beforeClass() {
        PropertiesReader.loadProperties(Path.of("src/main/resources/configuration.properties"));
    }

    @BeforeMethod
    public void beforeMethod() {
        getDriver().navigate().to(PropertiesReader.getProperty("appUrl"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(PropertiesReader.getProperty("implicitWaitDuration"))));
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        closeDriver();
    }
}