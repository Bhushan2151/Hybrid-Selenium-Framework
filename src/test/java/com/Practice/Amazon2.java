package com.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Amazon2 {
  @Test
  public void FirstPage() throws InterruptedException {
	  
	  WebDriver driver=new ChromeDriver();
	  
	  driver.get("https://www.amazon.in/alm/storefront?almBrandId=ctnow&ref_=nav_cs_grocery");
	  	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  
	  driver.manage().window().maximize();

	  
	  driver.findElement(By.xpath("//button[@data-action='a-popover-close']")).click();
	  Thread.sleep(3000);
	  
	  WebElement fresh=driver.findElement(By.xpath("(//div[@id='nav-main']//div)[6]"));
	  
	  Actions act=new Actions(driver);
	  
	  act.moveToElement(fresh).perform();
	  
	  driver.findElement(By.xpath("(//img[@class='f3-cgi-flyout-store-img'])[2]")).click();
	  
	  driver.findElement(By.id("ap_email_login")).sendKeys("8805847482");
  }
}
