package com.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSignin {
  @Test
  public void Facebook() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  
	  WebDriver driver=new ChromeDriver();
	  
	  driver.get("https://business.facebook.com/signup");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  
	  driver.manage().window().maximize();
	  
	  String title=driver.getTitle();
	  
	  System.out.println(title);
	  
	  driver.findElement(By.xpath("(//input[@type=\"text\"])[1]")).sendKeys("Haribhau");
	  
	  driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys("Chaudhari");
	  
	  WebElement day=driver.findElement(By.xpath("//select[@id=\"day\"]"));
	  
	  Select s=new Select(day);
	  
	  s.selectByIndex(0);
	  
	  WebElement month=driver.findElement(By.xpath("//select[@aria-label=\"Month\"]"));
	  
	  Select s1=new Select(month);
	  
	  s1.selectByVisibleText("Aug");
	  
	  WebElement year=driver.findElement(By.xpath("//select[@aria-label=\"Year\"]"));
	  
	  Select s2=new Select(year);
	  
	  s2.selectByValue("1997");
	  
	  WebElement gender= driver.findElement(By.xpath("(//label[@class=\"_58mt\"])[2]"));
	  
	  gender.click();
	  
	  Thread.sleep(3000);
	  
	  boolean result=gender.isSelected();
	  
	  if(result) {
		  
		  System.out.println("Button is selected");
	  }
	  else {
		  System.out.println("Button is not selected");
	  }
	  
	  
  }
}
