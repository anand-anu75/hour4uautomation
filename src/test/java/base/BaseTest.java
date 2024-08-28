package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader frprop;
	public static FileReader frloc;
	public static SoftAssert softAssert;
	public static WebDriverWait wait;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static ExtentSparkReporter sparkReporter;
	public static ThreadLocal<String> assertionMessage;

	@BeforeSuite
	public void setupReport() {
		// Initialize ExtentSparkReporter
		sparkReporter = new ExtentSparkReporter("extent-report.html");
		// Initialize ExtentReports
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);

		// Additional configurations if needed
		sparkReporter.config().setDocumentTitle("Test Report");
		sparkReporter.config().setReportName("Selenium Test Report");
	}

	@BeforeMethod
	public void setup() throws IOException {

		if (driver == null) {

			frprop = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties");
			prop.load(frprop);

			frloc = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\locators.properties");
			loc.load(frloc);

			softAssert = new SoftAssert();
			assertionMessage = new ThreadLocal<>();

		}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if (prop.getProperty("browser").equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("testURL"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public static String getAssertionMessage() {
		return assertionMessage.get();
	}

	@AfterMethod
	public void tearDown() {
	//	driver.close();

	}

	@AfterSuite
	public void tearDownReport() {
		// Flush the report
		extentReports.flush();
	}

}
