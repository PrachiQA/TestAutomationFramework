package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static FileReader fileReader;
	public static Properties properties = new Properties();
	public static Properties locators = new Properties();

	@BeforeMethod
	public static void Setup() throws IOException {

		if (driver == null) {
			String userDirectoryPath = System.getProperty("user.dir");
			FileReader PropertiesFileReader = new FileReader(
					userDirectoryPath + "\\src\\test\\resources\\configfiles\\config.properties");
			FileReader LocatorsFileReader = new FileReader(
					userDirectoryPath + "\\src\\test\\resources\\configfiles\\locators.properties");
			properties.load(PropertiesFileReader);
			locators.load(LocatorsFileReader);
		}
		if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			// Set up WebDriverManager to manage the WebDriver binaries
			WebDriverManager.chromedriver().setup();
			// Instantiate ChromeDriver
			driver = new ChromeDriver();
			// Navigate to a website
			driver.get(properties.getProperty("testurl"));
			driver.manage().window().maximize();
		} else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			// Set up WebDriverManager to manage the WebDriver binaries
			WebDriverManager.firefoxdriver().setup();
			// Instantiate ChromeDriver
			driver = new FirefoxDriver();
			// Navigate to a website
			driver.get(properties.getProperty("testurl"));
			driver.manage().window().maximize();
		}

	}

	@AfterMethod
	public static void tearDown() {
		System.out.println("Teardown successful");

		driver.close();

	}

}
