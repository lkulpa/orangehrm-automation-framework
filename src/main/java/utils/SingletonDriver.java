package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SingletonDriver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            boolean headlessMode = Boolean.parseBoolean(PropertiesReader.get("headlessMode"));
            boolean maximizeWindow = Boolean.parseBoolean(PropertiesReader.get("maximizeWindow"));

            if (headlessMode) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
            if (maximizeWindow && !headlessMode) {
                driver.manage().window().maximize();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver.quit();
        driver = null;
    }
}