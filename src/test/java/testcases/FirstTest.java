package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSData;

public class FirstTest extends BaseTest {

	@Test(dataProviderClass= ReadXLSData.class, dataProvider="testDataProvider")
	public static void loginTest(String username, String password) {

		// Perform your test actions here...
		driver.findElement(By.xpath(locators.getProperty("login_button"))).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.getProperty("loginId_field"))));
		driver.findElement(By.xpath(locators.getProperty("loginId_field"))).sendKeys(username);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locators.getProperty("next_button"))));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("load-bg")));
		driver.findElement(By.xpath(locators.getProperty("next_button"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.getProperty("password_field"))));
		driver.findElement(By.xpath(locators.getProperty("password_field"))).sendKeys(password);
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.className(locators.getProperty("loadBackground"))));
		driver.findElement(By.xpath(locators.getProperty("signIn_next_button"))).click();
	}

//	@DataProvider(name = "data")
//	public Object[][] testdata() {
//		return new Object[][] { { "pg20000703@gmail.com", "ZohoPassword@#$2023" },
//				{ "pg03@gmail.com", "Zoho@#$2023" } };
//	}
}