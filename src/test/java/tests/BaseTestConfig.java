package tests;

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
        PropertiesReader.read(Path.of("src/main/resources/configuration.properties"));
    }

    @BeforeMethod
    public void beforeMethod() {
        getDriver().navigate().to(PropertiesReader.get("appUrl"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterMethod
    public void afterMethod() {
        closeDriver();
    }
}