package com.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
  @Test
  public void f() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.amazon.in/alm/storefront?almBrandId=ctnow&ref_=nav_cs_grocery");
	  driver.manage().window().maximize();
	  
	  
	  driver.findElement(By.xpath("//button[@data-action='a-popover-close']")).click();
	  Thread.sleep(3000);

	  WebElement fresh=driver.findElement(By.xpath("(//div[@class='nav-div']/a/span)[3]"));
	  
	  String text=fresh.getText();
	  System.out.println(text);
	  
	  Actions act=new Actions(driver);
	  act.moveToElement(fresh);
	  Thread.sleep(10000);
	  
	 //driver.findElement(By.xpath("//*[@id=\"nav-flyout-groceries\"]/div[2]/div[1]/a[2]/div")).click();
	  
	 List<WebElement> list= driver.findElements(By.tagName("*"));
	 
	list.size();
	
//	for(WebElement links : list) {
//	    System.out.println(links.getText());
//	}
	
	for(int i=0;i<21;i++) {
		WebElement index=list.get(i);
		String LinkText=index.getText();
		
		System.out.println("Links: "+index+" "+"links "+LinkText);
	}
	
	  
  }
}
