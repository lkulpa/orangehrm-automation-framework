package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;

import static utils.ScreenshotTaker.takeScreenshot;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        LocalDateTime now = LocalDateTime.now();
        String dayOfMonth = Integer.toString(now.getDayOfMonth());
        String month = Integer.toString(now.getMonthValue());
        String year = Integer.toString(now.getYear());
        takeScreenshot(result.getName() + "Failure" + "_" + dayOfMonth + "_" + month + "_" + year);
    }
}