package TestClasses;

import org.testng.annotations.Test;

import Base.BaseClass;
import POM.NaukriPOM;

public class NaukriTest extends BaseClass {
	
	NaukriPOM verify;
	
	@Test
	public void Verify() {
		
		getDriver().get(cr.getProperty("url-naukri"));
		verify=new NaukriPOM(getDriver());
		
		logger.info("Naukri Test Started");
		
		verify.LoginButton();
		verify.EnterUsername();
		verify.EnterPassword();
		verify.ClickOnLogin();
		logger.info("LogIn Successful");
		
		//verify.ClickOnCancelButton();
		verify.ClickOnSearch();
		verify.EnterDesignation();
		verify.SelectExperience();
		verify.SelectYears();
		verify.EnterLocation();
		verify.ClickOnSearchButton();
		
		logger.info("Naukri Test Completed");
	}
	
	

}
