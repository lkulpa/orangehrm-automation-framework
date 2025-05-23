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

        if (Boolean.parseBoolean(PropertiesReader.getProperty("headlessMode"))) {
            options.add("--headless=new");
        }

        switch (System.getenv("browserType")) {
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