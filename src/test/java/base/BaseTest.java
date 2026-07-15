package base;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {

    public WebDriver driver;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeClass
    public void setup() {

        // Report path
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")
                + "/reports/ExtentReport.html");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        // Browser launch
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open website
        driver.get("https://blazedemo.com/");
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
        extent.flush();
    }
}