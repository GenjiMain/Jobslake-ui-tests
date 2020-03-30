package testutil;

import org.aeonbits.owner.ConfigCache;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import common.Browser;
import config.Configuration;
import driver.DriverFactory;
import driver.DriverManager;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BaseTest {
	
	@BeforeSuite
    @Parameters("environment")
    public void setConfiguration(@Optional("dev") String environment) {
        String env = System.getenv("environment");
        ConfigFactory.setProperty("env", env == null ? environment : env);
    }

    @BeforeTest
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
    	Configuration configuration = ConfigCache.getOrCreate(Configuration.class);

        WebDriver driver = DriverFactory.createInstance(browser);
        DriverManager.setDriver(driver);
        Browser.setDriver(driver);

        DriverManager.getDriver().get(configuration.url());
        log.debug("@BeforeTest => BaseTest");
    }

    @AfterTest
    public void postCondition() {
        //DriverManager.quit();
    }
    
    public void initialization(String browser) {
  
    }
 }
