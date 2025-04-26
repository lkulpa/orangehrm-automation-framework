package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertiesReader;

import java.nio.file.Path;
import java.time.Duration;

import static utils.SingletonDriver.closeDriver;
import static utils.SingletonDriver.getDriver;

public class BaseTestConfig {

    @BeforeMethod
    public void beforeMethod() {
        PropertiesReader.read(Path.of("src/main/resources/configuration.properties"));
        String homeUrl = PropertiesReader.get("appUrl");

        getDriver().manage().window().maximize();
        getDriver().navigate().to(homeUrl);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterMethod
    public void afterMethod() {
        closeDriver();
    }
}