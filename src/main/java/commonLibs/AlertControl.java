package commonLibs;

import org.openqa.selenium.WebDriver;

public class AlertControl {

	WebDriver driver;

	public AlertControl(WebDriver driver) {

		this.driver = driver;

	}

	public void acceptAlert() {

		driver.switchTo().alert().accept();

	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();

	}

	public void getTextFromAlert(WebDriver driver) {
		driver.switchTo().alert().getText();

	}

}
