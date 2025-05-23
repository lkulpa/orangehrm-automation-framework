package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;

public class BrowserPicker {

    public static WebDriver buildWebDriver() {
        ArrayList<String> options = new ArrayList<>();
        String browserType = System.getenv("browserType");
        if (browserType == null) {
            browserType = PropertiesReader.getProperty("browserType");
        }

        if (Boolean.parseBoolean(PropertiesReader.getProperty("headlessMode"))) {
            options.add("--headless=new");
        }

        switch (browserType) {
            case "chrome" -> {
                ChromeOptions optionsObject = new ChromeOptions();
                optionsObject.addArguments(options);
                return new ChromeDriver(optionsObject);
            }
            case "firefox" -> {
                FirefoxOptions optionsObject = new FirefoxOptions();
                optionsObject.addArguments(options);
                return new FirefoxDriver(optionsObject);
            }
            case "edge" -> {
                EdgeOptions optionsObject = new EdgeOptions();
                optionsObject.addArguments(options);
                return new EdgeDriver(optionsObject);
            }
            default -> {
                return new ChromeDriver();
            }
        }
    }
}