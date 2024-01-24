package HomeExam;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class WorkizHomeAssignment {
    public static WebDriver driver;
    public static WebElement searchInput;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));




    }

    @Test
    public void WorkizHomeAssignment() {
        driver.get("https://homeassessment.tests.workiz.com/");

        WebElement userEl = driver.findElement(By.id("email"));
        WebElement passEl = driver.findElement(By.id("password"));

        userEl.sendKeys("MobileTesting@workiz.com");
        passEl.sendKeys("MobileTesting");

        driver.findElement(By.className("button")).click();

        driver.findElement(By.linkText("Clients")).click();

        searchInput = driver.findElement(By.id("searchString"));

        UtilityMethods utilMetObj = new UtilityMethods();

        utilMetObj.findClientName(searchInput, "Timothy Clarke");

        driver.findElement(By.className("rt-tr-group")).click();

        driver.findElement(By.className("iFfWBzvt7RjPTzzA73jT")).click();

        driver.findElement(By.linkText("Create Job")).click();

        WebElement jobType = driver.findElement(By.className("react-select__value-container css-g1d714-ValueContainer"));

        jobType.click();
        jobType.sendKeys("Service");

        jobType.sendKeys(Keys.RETURN);


        driver.findElement(By.id("job_date")).click();

        driver.findElement(By.cssSelector("div[aria-label=day-25]")).click();

        driver.findElement(By.className("newJob-module__createBtn___15l3R iFfWBzvt7RjPTzzA73jT")).click();



    }




    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
