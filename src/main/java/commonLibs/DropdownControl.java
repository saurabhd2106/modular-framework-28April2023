package commonLibs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownControl {
	

	
	public void selectViaVisibleText(WebElement element, String text) {
		
		Select  select = new Select(element);
		
		select.selectByVisibleText(text);
		
	}



}
