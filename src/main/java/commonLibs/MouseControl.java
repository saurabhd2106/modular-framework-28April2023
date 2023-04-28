package commonLibs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseControl {

	private Actions action;

	public MouseControl(WebDriver driver) {

		action = new Actions(driver);

	}

	public void moveToElement(WebElement element) {

		action.moveToElement(element).build().perform();

	}

	public void dragAndDrop(WebElement source, WebElement target) {

		action.dragAndDrop(source, target).build().perform();

	}

}
