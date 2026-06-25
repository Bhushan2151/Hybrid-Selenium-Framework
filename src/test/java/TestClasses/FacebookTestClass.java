package TestClasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Base.BaseClass;
import POM.FacebookPOM;
import Utility.ExcelUtility;


public class FacebookTestClass extends BaseClass {
	
	FacebookPOM verify;
	
	@DataProvider(name="facebookData")
	public Object[][] getData() throws Exception {

	    System.out.println("DataProvider Started");

	    Object[][] data = ExcelUtility.getExcelData(
	        "C:\\Users\\bhush\\eclipse-workspace\\com.bhushan\\HCLME\\Practice\\src\\test\\resources\\TestData\\FacebookData.xlsx",
	        "SignupData");

	    System.out.println("DataProvider Completed");

	    return data;
	}
	
	
	@Test (dataProvider="facebookData",retryAnalyzer = retry.RetryAnalyzer.class)
    public void facebookSignUp(String fname, String lname, String pass, String number)  {
		
		getDriver().get(cr.getProperty("url"));
		logger.info("Navigated to URL");

    	logger.info("Facebook SignUp Test Started");
        verify = new FacebookPOM(getDriver());
        
        logger.info("LogIn With="+ fname+lname);
        verify.Firstname(fname);
        verify.Familyname(lname);

        verify.Day();

        verify.Month();

        verify.Year();

        verify.MaleRadio();

        verify.MobileNumber(number);

        verify.Password(pass);
        
        logger.info("Clicking Sign Up");
        verify.SignUp();
        logger.info("Facebook SignUp Test Completed");
        logger.info("Thank You");
        
//        String Nav="Bhushan";
//        
//        SoftAssert soft=new SoftAssert();
//        soft.assertEquals(fname, Nav);
//        soft.assertAll();
    } 
	}
