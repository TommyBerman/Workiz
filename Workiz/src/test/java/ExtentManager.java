import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance() {
        String reportFileName = "Test-Report" + ".html";
        String filePath = System.getProperty("user.dir") + "/target/TestNG-outputs/" + reportFileName;

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(filePath);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }
}
