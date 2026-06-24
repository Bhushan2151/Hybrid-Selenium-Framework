package com.Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class RCB {
  @Test
  public void Webpage() throws InterruptedException, IOException {
	  
	  WebDriver driver=new ChromeDriver();
	  
	  driver.get("https://www.royalchallengers.com/");
	  
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  
	  //driver.findElement(By.xpath("(//div[@id='onetrust-button-group-parent']//div)[2]//button")).click();
	  
	  WebElement jio=driver.findElement(By.xpath("(//img[@loading='eager'])[9]"));
	  Actions act=new Actions(driver);
	  act.scrollToElement(jio).perform();
	  Thread.sleep(2000);
	  
	  File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File Dest=new File("E:\\SeleniumScreenshots\\RCB.jpg");
	  FileHandler.copy(source, Dest);
	  
	  
	  WebElement team=driver.findElement(By.xpath("(//ul[@class='menu menu--main nav navbar-nav']//li)[4]"));
	  act.scrollToElement(team).perform();
	  team.click();
	  Thread.sleep(2000);

	  WebElement lyer=driver.findElement(By.xpath("//img[@alt='Venkatesh Iyer']"));
	  act.scrollToElement(lyer).perform();
	  lyer.click();
	  
	  
	  File source1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File dest1=new File("E:\\SeleniumScreenshots\\VKI.jpg");
	  FileHandler.copy(source1, dest1);
	  
	  driver.navigate().back();
	  driver.findElement(By.xpath("(//ul[@class='menu menu--main nav navbar-nav']//li)[5]")).click();
  }
}
