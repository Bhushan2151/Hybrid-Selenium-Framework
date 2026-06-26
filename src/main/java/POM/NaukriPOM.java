package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ConfigReader;
import Utility.WaitUtility;

public class NaukriPOM {
	
	public WebDriver driver;
	WaitUtility wait;
	ConfigReader cr=new ConfigReader();
	
		@FindBy(xpath="//a[text()='Login']")
		private WebElement login;
		
		@FindBy(xpath="//input[@placeholder='Enter your active Email ID / Username']")
		private WebElement username;
		
		@FindBy (xpath="//input[@type='password']")
		private WebElement password;
		
		@FindBy(xpath="//button[text()='Login']")
		private WebElement loginbutton;
		
		@FindBy(xpath="(//div[@class='nI-gNb-sb__main']//span)[3]")
		private WebElement search;
		
		@FindBy(xpath="//input[@placeholder='Enter keyword / designation / companies']")
		private WebElement designation;
		
		@FindBy(xpath="//input[@placeholder='Select experience']")
		private WebElement experience;
		
		@FindBy (xpath="//span[text()='3 years']")
		private WebElement years;
		
		@FindBy(xpath="//input[@placeholder='Enter location']")
		private WebElement location;
		
		@FindBy(xpath="//span[text()='Search']")
		private WebElement searchbutton;
		
		@FindBy(xpath="//div[@class='crossIcon chatBot chatBot-ic-cross']")
		private WebElement cancelIcon;
			
		
		public NaukriPOM(WebDriver driver) {
			
			this.driver=driver;
			
			PageFactory.initElements(driver,this);
			
			wait=new WaitUtility(driver);
		}
		
		
		public void LoginButton() {
			login.click();
		}
		
		public void EnterUsername() {
			username.sendKeys(cr.getProperty("email-naukri"));
		}
		
		public void EnterPassword() {
			password.sendKeys(cr.getProperty("password-naukri"));
		}
		
		public void ClickOnLogin() {
			loginbutton.click();
		}
		
		public void ClickOnSearch() {
			wait.waitForVisibility(search);
			search.click();
		}
		
		public void EnterDesignation() {
			designation.sendKeys("manual tester, manual functional testing, automation tester, selenium");
		}
		
		public void SelectExperience() {
			experience.click();
		}
		
		public void SelectYears() {
			years.click();
		}
		
		public void EnterLocation() {
			location.sendKeys("Pune");
		}
		
		public void ClickOnSearchButton() {
			searchbutton.click();
		}
		
		public void ClickOnCancelButton() {
			if(cancelIcon.isDisplayed()) {
				cancelIcon.click();
			}else {
				search.click();
			}
		}
}
