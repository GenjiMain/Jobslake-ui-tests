package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Browser {

	private static WebDriver driver = null;
	
	public static void setDriver(WebDriver wDriver) {
		driver = wDriver;
	}
	
	public static void waitForElementToBeVisible(WebElement webElement, long timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
	}
}
