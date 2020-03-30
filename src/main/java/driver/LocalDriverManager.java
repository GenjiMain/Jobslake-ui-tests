package driver;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LocalDriverManager implements IDriver{

	public WebDriver createInstance(String browser) {
		 WebDriver driver = null;

	        try {
	            DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
	            Class<?> driverClass = Class.forName(driverManagerType.browserClass());
	            WebDriverManager.getInstance(driverManagerType).setup();
	            driver = (WebDriver) driverClass.newInstance();
	            driver.manage().window().maximize();
	        } catch (IllegalAccessException | ClassNotFoundException e) {
	            log.error("The class could not be found", e);
	        } catch (InstantiationException e) {
	            log.error("Problem during driver instantiation", e);
	        }
	        return driver;
	}

}
