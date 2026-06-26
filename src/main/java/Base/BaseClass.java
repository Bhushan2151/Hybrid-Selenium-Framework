package Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utility.ConfigReader;

public class BaseClass {
	
	public static Logger logger =LogManager.getLogger(BaseClass.class);
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public ConfigReader cr;
    
    public static WebDriver getDriver() {

        return driver.get();
    }
   
    
    @BeforeClass @Parameters("browser")
    public void setup(@Optional("chrome")String browser) {

        logger.info("Framework Execution Started");

        cr = new ConfigReader();

        if(browser.equalsIgnoreCase("chrome")) {

            logger.info("Launching Chrome Browser");

            driver.set(new ChromeDriver());
        }

        else if(browser.equalsIgnoreCase("firefox")) {

            logger.info("Launching Firefox Browser");

            driver.set(new FirefoxDriver());
        }

        getDriver().manage().window().maximize();

        logger.info("Browser Maximized");

    }
    
    @AfterClass
    public void tearDown() {

        if(getDriver() != null) {

            //getDriver().quit();

            driver.remove();
        }
    }
}
