package commonLibs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonDriver {

	private WebDriver driver;

	private int elementDetectionTimeout;

	private int pageloadTimeout;

	public CommonDriver(String browserType) throws Exception {

		elementDetectionTimeout = 10;

		pageloadTimeout = 60;

		browserType = browserType.trim();

		if (browserType.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else {
			throw new Exception("Invalid browser Type" + browserType);
		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;

	}

	public void setPageloadTimeout(int pageloadTimeout) {
		this.pageloadTimeout = pageloadTimeout;

	}

	public void navigateToURL(String baseurl) {
		baseurl = baseurl.trim();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadTimeout));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(elementDetectionTimeout));

		driver.get(baseurl);

	}

	public void closeBrowser() {
		driver.close();
	}
	public void quitBrowser() {
		driver.quit();
}
}
