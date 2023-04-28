package commonLibs;

import org.openqa.selenium.WebDriver;

public class WindowControl {
	WebDriver driver;

	public WindowControl(WebDriver driver) {

		this.driver = driver;

	}

	public void switchTWindow(String windowControl) {

		driver.switchTo().window(windowControl);

	}

	public void switchToChildWindow() {

		String childwindowHandle = driver.getWindowHandles().toArray()[1].toString();

		driver.switchTo().window(childwindowHandle);

	}

	public void switcToNthWindow(int childWindowindex) {

		String childwindowHandle = driver.getWindowHandles().toArray()[childWindowindex].toString();

		driver.switchTo().window(childwindowHandle);
	}

}
