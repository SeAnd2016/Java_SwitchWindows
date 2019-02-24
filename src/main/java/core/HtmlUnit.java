package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnit {
	
	//static String browser = "HtmlUnit";
	
	public static void main(String[] args) throws InterruptedException {
		
		    String url = "http://alex.academy/exe/links";
			
			// Disable the logs
			Logger logger = Logger.getLogger("");
			logger.setLevel(Level.OFF);
			WebDriver driver;
			
			driver = new HtmlUnitDriver();
			((HtmlUnitDriver) driver).setJavascriptEnabled(true);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(url);
			
			System.out.println("01.Title:" + driver.getTitle() + ";\t URL: " + driver.getCurrentUrl() + ";\t\t Handle: " + driver.getWindowHandle());
			driver.findElement(By.id("id_link_top")).click();
			
			System.out.println("02.Title:" + driver.getTitle() + ";\t\t\t URL: " + driver.getCurrentUrl() + ";\t\t\t Handle: " + driver.getWindowHandle());
			driver.navigate().back();
			
			driver.findElement(By.xpath("//*[@id=\"id_link_blank\"]")).click(); // New tab opened
			
			//if (browser == "HtmlUnit") {
			driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
			System.out.println("Current Title:" + driver.getTitle());
			//}
			//else driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
			
			System.out.println("03.Title:" + driver.getTitle() + ";\t\t URL: " + driver.getCurrentUrl() + ";\t\t Handle: " + driver.getWindowHandle());
			//if (browser == "HtmlUnit")
			driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
			//else driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
			System.out.println("Current Title:" + driver.getTitle());
			
			System.out.println("_______________________________");
			System.out.println("All Handles: " + driver.getWindowHandles());
			
			driver.getWindowHandles().clear();
			
			driver.quit();
			
		}
		
	}
