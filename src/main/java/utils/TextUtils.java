package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextUtils {

    public static void clearAndEnterTextInput(WebElement textInputElement, String text) {
        textInputElement.click();
        textInputElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        textInputElement.sendKeys(text);
    }

    public static void copyValueFromInputBox(WebElement textInputElement) {
        textInputElement.click();
        textInputElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        textInputElement.sendKeys(Keys.chord(Keys.CONTROL, "c"));
    }

    public static void pasteValueIntoInputBox(WebElement textInputElement) {
        textInputElement.click();
        textInputElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        textInputElement.sendKeys(Keys.chord(Keys.CONTROL, "v"));
    }
}