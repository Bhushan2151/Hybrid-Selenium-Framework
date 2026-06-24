package TestClasses;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BaseClass;
import POM.RCB_POM;
import Utility.Screenshot;

public class RCB_Webpage {
				public WebDriver driver;
				public RCB_POM verify1;
				
			  @Parameters("browser")
			  @BeforeTest
			  public void BeforeClass() {
				  driver=new ChromeDriver();
				  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				  driver.manage().window().maximize();
				  
				  driver=new FirefoxDriver();
				  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				  driver.manage().window().maximize();
			  }
			  @org.testng.annotations.BeforeMethod
			  public void BeforeMethod(){
				  driver.get("https://www.royalchallengers.com/");
				  verify1=new RCB_POM(driver);
			  }
			  @Test
			  public void VerifyFunctions() throws IOException, InterruptedException{
				  verify1.JioLogo(driver);
				  Screenshot.captureScreenshot(BaseClass.getDriver(),"VerifyFunctions");
				  verify1.TeamTab(driver);
				  verify1.VK_Lyer(driver);
				  Screenshot.captureScreenshot(BaseClass.getDriver(),"VerifyFunctions");
				  Screenshot.navigateBack(driver);
				  //verify1.FixturesTab();
				  
			  }
}
