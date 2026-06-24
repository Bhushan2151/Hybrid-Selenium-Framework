package com.Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTable {
  @Test
  public void webTable() {
	  
	  WebDriver driver=new ChromeDriver();
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  
	  driver.get("https://demo.guru99.com/");
	  
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.xpath("(//a[@href='#'])[1]")).click();
	  
	  driver.findElement(By.xpath("//a[text()='Table Demo']")).click();
	  
	  List<WebElement> list= driver.findElements(By.xpath("//table[@cellspacing='1']//tr"));
	  
	  for(int i=0;i<list.size();i++) {
		  
		  String text=list.get(i).getText();
		  
		  System.out.println(i+" ="+text);
		   }
	  driver.findElement(By.xpath("(//a[@href='#'])[1]")).click();
	  driver.findElement(By.xpath("//a[text()='Selenium DatePicker Demo']")).click();
  }
}
