package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static utils.SingletonDriver.getDriver;

public class ExplicitWaitUtils {

    private static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    public static WebElement waitForElementToBeClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static WebElement waitForElementToBeVisible(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForElementToDisappear(WebElement webElement) {
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public static void waitForElementToHaveText(WebElement webElement) {
        wait.until(ExpectedConditions.attributeToBeNotEmpty(webElement, "value"));
    }

    public static boolean waitForTextToBePresentInElement(WebElement webElement, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }
}