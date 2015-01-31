package webdriver.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example {

	protected WebDriver webDriver;

	@BeforeMethod
	public void setup() {
		setChromeDriver();
		webDriver = new ChromeDriver();
	}

	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}

	@Test
	public void simpleWebDriverTest() {
		webDriver.get("http://www.lits.com.ua");
		webDriver
				.findElement(By.xpath("//a[contains(@class,'red-btn-small')]"))
				.click();
		webDriver.switchTo().frame(webDriver.findElement(By.id("JotFormIFrame")));
		Assert.assertTrue(webDriver.findElement(By.id("input_4_area"))
				.getAttribute("placeholder").equals("067"));
	}

	private void setChromeDriver() {
		String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
		String chromeBinary = "src/drivers/chromedriver"
				+ (os.equals("win") ? ".exe" : "");
		System.setProperty("webdriver.chrome.driver", chromeBinary);
	}
}
