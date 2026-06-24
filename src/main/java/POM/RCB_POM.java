package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RCB_POM {
		
	@FindBy(xpath="(//img[@loading='eager'])[9]")
	private WebElement jio;
	
	@FindBy (xpath="(//ul[@class='menu menu--main nav navbar-nav']//li)[4]")
	private WebElement team;
	
	@FindBy (xpath="//img[@alt='Venkatesh Iyer']")
	private WebElement vk_lyer;
	
	@FindBy (xpath="(//ul[@class='menu menu--main nav navbar-nav']//li)[5]")
	private WebElement fixtures;
	
	
	public RCB_POM(WebDriver driver){
		
		PageFactory.initElements(driver,this);
	}
	
	public void JioLogo(WebDriver driver) throws InterruptedException {
		Actions act=new Actions(driver);
		act.scrollToElement(jio).perform();
		Thread.sleep(2000);
	}
	
	public void TeamTab(WebDriver driver) throws InterruptedException {
		Actions act=new Actions(driver);
		act.scrollToElement(team).click().build().perform();
		Thread.sleep(2000);
		
	}
	public void VK_Lyer(WebDriver driver) throws InterruptedException {
		Actions act=new Actions(driver);
		act.moveToElement(vk_lyer).perform();
		Thread.sleep(3000);
		vk_lyer.click();
	}
	public void FixturesTab() {
		fixtures.click();
	}
	}
