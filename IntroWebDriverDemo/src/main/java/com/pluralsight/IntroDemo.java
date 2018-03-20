package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IntroDemo {

	public static void main(String[] args) {
		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectLocation+"\\lib\\geckodriver\\geckodriver.exe");
		
		String baseUrl = "http://www.seleniumhq.org";
		WebDriver driver = new FirefoxDriver();
		// open | / |
		driver.get(baseUrl + "/");
		// click | //img[@alt='Selenium IDE Logo'] |
		driver.findElement(By.xpath("//img[@alt='Selenium IDE Logo']")).click();
		// assertTitle | Selenium IDE Plugins |
		assert("Selenium IDE Plugins".equals(driver.getTitle()));
	}
}
