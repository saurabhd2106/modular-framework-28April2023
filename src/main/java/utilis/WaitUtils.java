package utilis;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public void sleep(int time) throws Exception{
		
		Thread.sleep(time * 1000);
		
	}

	public static void waitTillElementVisible(WebDriver driver, WebElement element, int timeout) {
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(timeout));

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void waitTillElemenIsClickable(WebDriver driver, WebElement element, int timeout) {
		

		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(timeout));

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

}
