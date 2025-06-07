package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    ExtentReports extent;
    ExtentTest test;
    public WebDriver driver;


    @BeforeTest
    public void reportSetup(){
        String reportPath = System.getProperty("user.dir")+"//target//ExtentReports//ExtentReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);

    }
    @BeforeMethod
    public void driverSetup(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void reportGenerator(ITestResult result) throws IOException {
        test = extent.createTest(result.getMethod().getMethodName());
        if(result.getStatus()==ITestResult.FAILURE){
            test.log(Status.FAIL,"test case failed");
            File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(f,new File(System.getProperty("user.dir")+"//target//ExtentReports//screeshot.png"));
        }else{
            test.log(Status.PASS,"Test case passed");
        }
        driver.quit();
    }
    @AfterTest
    public void reportFlush(){
        extent.flush();
    }
}
