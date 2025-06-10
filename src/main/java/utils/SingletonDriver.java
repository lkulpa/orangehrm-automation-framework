package utils;

import org.openqa.selenium.WebDriver;

public class SingletonDriver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserPicker.buildWebDriver();
            if (Boolean.parseBoolean(PropertiesReader.getProperty("maximizeWindow")) && !Boolean.parseBoolean(PropertiesReader.getProperty("headlessMode"))) {
                driver.manage().window().maximize();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        if (!PropertiesReader.getProperty("browserType").equals("firefox")) {
            driver.quit();
        }
        driver = null;
    }
}