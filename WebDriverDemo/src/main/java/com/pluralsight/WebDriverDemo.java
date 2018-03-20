package com.pluralsight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo {
	
	public static void main(String[] args) {
		
		//System.setProperty("webdriver.gecko.driver", "E:/IT/eclipse/workspace/WebDriverDemo/lib/geckodriver/geckodriver.exe");
		
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("http://pluralsight.com");
	}
}
