package com.Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ESPN {
	
  @Test
  public void Player() throws IOException {
	  
	  WebDriverManager.chromedriver().setup();
	  
	  WebDriver driver=new ChromeDriver();
	  
	  driver.get("https://www.espncricinfo.com/");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  
	  driver.manage().window().maximize();
	  
	  //driver.findElement(By.xpath("//button[@id=\"cx-btn-0\"]")).click();
	  
	  driver.findElement(By.xpath("//button[@id=\"wzrk-confirm\"]")).click();
	  
	  driver.findElement(By.xpath("(//div[@class=\"lg:ds-container lg:ds-mx-auto lg:ds-px-5\"]//div)[20]")).click();
	  
	  driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("virat kohli"+Keys.ENTER);
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  
	  js.executeScript("window.scrollBy(0,300)");
	  
	  driver.findElement(By.xpath("//a[@href=\"https://www.espncricinfo.com/cricketers/virat-kohli-253802\"]")).click();
	  
	  File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  
	  File dest=new File("E:\\SeleniumScreenshots\\ScreenshotbySelenium.jpg");
	  
	  FileHandler.copy(source, dest);
	  
	  
  }
}
