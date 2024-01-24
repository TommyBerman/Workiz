import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test skipped");
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
