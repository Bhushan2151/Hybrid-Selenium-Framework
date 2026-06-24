package com.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VersionCheck {
  @Test
  public void Checkingversion () throws InterruptedException {
	  
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://mvnrepository.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
	  
  }
}
