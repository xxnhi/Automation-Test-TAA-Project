package anhtester.base;

import anhtester.common.helpers.CaptureHelpers;
import anhtester.common.ultilities.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onFinish(ITestContext result) {
        Log.info("Kết thúc auto test");
    }

    @Override
    public void onStart(ITestContext result) {
        Log.info("Đây là đoạn khởi động auto test");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.error("Đây là test case bị fail: " + result.getName());
        // chụp mh khi test case bị fail
        try {
            CaptureHelpers.captureScreenshot(new BaseSetup().getDriver(),result.getName());
        } catch (Exception e) {
            System.out.print("Exception while taking screenshot " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("Đây là test case bị bỏ qua: " + result.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info("Đây là test case chạy thành công: " + result.getName());

    }
}