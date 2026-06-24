package POM;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.WaitUtility;
import Utility.WebDriverUtility;

public class FacebookPOM {
	
	public WebDriver driver;
	WaitUtility wait;
	
	
	@FindBy (xpath="(//input[@type='text'])[1]")
	private WebElement firstname;
	
	@FindBy (xpath="(//input[@type='text'])[2]")
	private WebElement familyname;
	
	@FindBy(xpath="//select[@id='day']")
	private WebElement day;
	
	@FindBy(xpath="//select[@aria-label='Month']")
	private WebElement month;
	
	@FindBy(xpath="//select[@aria-label='Year']")
	private WebElement year;
	
	@FindBy(xpath="(//label[@class='_58mt'])[2]")
	private WebElement male;
	
	@FindBy(xpath="(//input[@type='text'])[5]")
	private WebElement MoNo;
	
	@FindBy(xpath="//input[@id='password_step_input']")
	private WebElement pass;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement button;
	
	public FacebookPOM(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
		wait = new WaitUtility(driver);
		
	}
	
	public void Firstname(String fname) {
		firstname.sendKeys(fname);
		}
	
	public void Familyname(String lname) {
		familyname.sendKeys(lname);
		}
	
	public void Day() {
//		Select s=new Select(day);
//		
//		s.selectByIndex(0);
		WebDriverUtility.selectByIndex(day,0);
	}
	
	public void Month() {
//		Select s1=new Select(month);
//		
//		s1.selectByVisibleText("Aug");
		WebDriverUtility.selectByVisibleText(month,"Aug");
	}
	
	public void Year() {
//		Select s2=new Select(year);
//		s2.selectByValue("1997");
		WebDriverUtility.selectByValue(year,"1997");
	}
	
	public void MaleRadio() {
		
		male.click();
	}
	
	public void MobileNumber(String monumber) {
		MoNo.sendKeys(monumber);
	}
	
	public void Password(String passw) {
		pass.sendKeys(passw);
		
	}
	
	public void SignUp() {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,300)");
//		button.click();
		WebDriverUtility.scrollBy(driver,0,300);
	}
	
	
	
}
