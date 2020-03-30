package page;

import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import config.Configuration;
import driver.DriverManager;

public class AbstractPageObject {

	 protected AbstractPageObject() {
	        Configuration configuration = ConfigCache.getOrCreate(Configuration.class);
	        int timeout = Integer.parseInt(configuration.timeout());
	        
	        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), timeout), this);
	    }
}
