package com.Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChildWindow {
  @Test
  public void PopUp() throws InterruptedException, IOException {
	  
	  WebDriverManager.chromedriver().setup();
	  
	  WebDriver driver=new ChromeDriver();
	  
	  driver.get("https://www.leafground.com/window.xhtml");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
	  
	  Thread.sleep(3000);
	  
	  ArrayList<String> address=new ArrayList<String>(driver.getWindowHandles());
	  
	  for(int i=0; i<address.size();i++) {
	  
		  String text=address.get(i);
		  
		  driver.switchTo().window(text);
		  
		  System.out.println("Address:-"+i+" "+text);
	  
	  }
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  
	  js.executeScript("window.scrollBy(0,300)");
	  
	  driver.findElement(By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[2]")).click();
	  
	  driver.findElement(By.id("email")).sendKeys("bhushanchaudhari@gmail.com");
	  
	  driver.findElement(By.name("message")).sendKeys("Testing");
	  
	  driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
	  
	  File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  
	  File dest=new File("E:\\SeleniumScreenshots\\Window.jpg");
	  FileHandler.copy(source, dest);
	  
	  System.out.println("Thank You");
	  
  }
}
