package com.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTrip {
  @Test
  public void Trip() throws InterruptedException {
	  
	  WebDriver driver=new ChromeDriver();
	  
	  driver.get("https://www.makemytrip.com/");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  
	  driver.manage().window().maximize();
	  
//	  driver.findElement(By.xpath("(//input[@type='text' or class='font14 fullWidth'])[2]")).sendKeys("8805847482");
//	  
//	  driver.findElement(By.xpath("//span[text()='Continue']")).click();
//	  Thread.sleep(3000);
//	  
//	  driver.findElement(By.xpath("//span[text()='Back']")).click();
	  
	  driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
  }
}
