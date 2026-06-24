package Utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

    public static void selectByVisibleText(WebElement element,String text) {

        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element,String value) {

        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectByIndex(WebElement element,int index) {

        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static void scrollBy(WebDriver driver,int x,int y) {

        JavascriptExecutor js =(JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(arguments[0],arguments[1]);",x,y);
    }

    public static void scrollToElement(WebDriver driver,WebElement element) {

        JavascriptExecutor js =(JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public static void acceptAlert(WebDriver driver) {

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void dismissAlert(WebDriver driver) {

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
}
