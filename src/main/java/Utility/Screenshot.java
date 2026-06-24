package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	public static String captureScreenshot(WebDriver driver,String testName)throws IOException {

		File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String path =System.getProperty("user.dir")+ "/Screenshots/"+ testName + ".png";
		File dest = new File(path);
		FileUtils.copyFile(src, dest);

		return path;
	}
	
	public static void captureScreenshot(WebDriver driver) throws IOException {
		
		Date d=new Date();
		SimpleDateFormat set=new SimpleDateFormat("(dd-MM-yyyy)_(HH-mm-ss)");
		String date=set.format(d);
		
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("E:\\SeleniumScreenshots\\TestScreenshot"+date+".jpg");
		FileHandler.copy(source, destination);
	}
	
	 public static void navigateBack(WebDriver driver) {

	        driver.navigate().back();
	    }
}
