package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.WaitUtility;

public class FacebookDashboardPOM {
	
	public WebDriver driver;
	WaitUtility wait;
	
	@FindBy(xpath="(//div[@role='navigation']//span)[22]")
	private WebElement profile;
	
	@FindBy(xpath="(//div[@class='x1gslohp x1ys307a x1yztbdb xyqm7xq']//div)[7]")
	private WebElement profileName;
	
	
	public FacebookDashboardPOM(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait= new WaitUtility(driver);
	}
	
	public void clickOnProfile() {
		profile.click();
		wait.waitForVisibility(profileName);	
	}
	
	public void clickOnName() {
		profileName.click();
	}

}
