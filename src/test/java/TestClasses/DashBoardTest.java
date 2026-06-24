package TestClasses;

import org.testng.annotations.Test;

import Base.BaseClass;
import POM.FacebookDashboardPOM;

public class DashBoardTest extends BaseClass {
	
	FacebookDashboardPOM verify;
	
  @Test
  public void f() {
	  
	  getDriver().get(cr.getProperty("url-dashboard"));
	  logger.info("Navigated to URL");
	  verify=new FacebookDashboardPOM(getDriver());
	  
	  verify.clickOnProfile();
	  verify.clickOnName();
	  
  }
}
