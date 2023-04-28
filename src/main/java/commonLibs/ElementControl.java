package commonLibs;

import org.openqa.selenium.WebElement;

public class ElementControl {

	public void clickElement(WebElement element) {

		element.click();

	}

	public void typeText(WebElement element, String text) {

		element.sendKeys(text);

	}

	public void cleartext(WebElement element) {

		element.clear();

	}

	public String getText(WebElement element) {
		return element.getText();
	}

}
