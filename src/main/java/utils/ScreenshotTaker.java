package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.*;

import static utils.SingletonDriver.getDriver;

public class ScreenshotTaker {

    public static InputStream takeScreenshot(String testName) {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File destFile = new File("./screenshots/" + testName + ".png");
        InputStream screenshotIS;
        try {
            screenshotIS = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotIS;
    }
}