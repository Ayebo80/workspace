package com.pluralsight;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverDemo {
	
	public static void main(String[] args) throws Exception {
		
		//System.setProperty("webdriver.gecko.driver", "E:/IT/eclipse/workspace/WebDriverDemo/lib/geckodriver/geckodriver.exe");
		
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), 
				new DesiredCapabilities("chrome", "", Platform.WINDOWS));
		
		
		driver.get("http://www.google.com");
		
		WebElement searchField = driver.findElement(By.id("lst-ib"));
		searchField.sendKeys("pluralisght");
		//get rid of that Type-Ahead AJAX Call
		searchField.submit();
		
		//Implicit Wait will wait for each Elements
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Explicit Wait will only wait on a specified Element
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Bilder")));
		
		WebElement imagesLink = driver.findElements(By.linkText("Bilder")).get(0);
		imagesLink.click();
		
		WebElement imageElement = driver.findElements(By.cssSelector("a[class = rg_l]")).get(0);
		WebElement imageLink = imageElement.findElements(By.tagName("img")).get(0);
		imageLink.click();
		
		//driver.getPageSource().contains("Whatever Sring you want to search for");
		
		//searchField.sendKeys(Keys.RETURN);
		//WebElement searchBtn = driver.findElement(By.id("gsr"));
		//searchBtn.click();
				
	}
}
