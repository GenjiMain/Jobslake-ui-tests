package driver;

import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.WebDriver;

import config.Configuration;
import driver.DriverFactory.Target;
import driver.LocalDriverManager;

public class DriverFactory {

	public static WebDriver createInstance(String browser) {
        Configuration configuration = ConfigCache.getOrCreate(Configuration.class);
        Target target = Target.valueOf(configuration.target().toUpperCase());
        WebDriver webdriver;

        switch (target) {

            case LOCAL:
                webdriver = new LocalDriverManager().createInstance(browser);
                break;
            //case GRID:
               
            default:
                throw new IllegalStateException("Unexpected value: " + target);
        }

        return webdriver;
    }

    enum Target {
        LOCAL, GRID
    }
}
