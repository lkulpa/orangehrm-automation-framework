package utils;

import org.testng.ITestResult;
import io.qameta.allure.Allure;
import org.testng.ITestListener;

import java.io.InputStream;
import java.time.LocalDateTime;

import static utils.ScreenshotTaker.takeScreenshot;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String now = LocalDateTime.now().toString();
        InputStream screenshotIS = takeScreenshot(result.getName() + "Fail" + "_" + now.replace(":", "_").split("\\.")[0]);
        Allure.getLifecycle().addAttachment("Screenshot", "image/png", ".png", screenshotIS);
    }
}