package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//FirefoxDriver forcefully calls the MarionetteDriver
import org.openqa.selenium.firefox.FirefoxDriver;

import config.PropertiesFile;

public class FirstSeleniumTest {
	
	//public static=fixed,available for all
	public static String browser;
	static WebDriver driver;
	
	public static void main(String[] args) {
		//setBrowser();
		PropertiesFile.readPropertiesFile();
		setBrowserConfiguration();
		runTest();
		PropertiesFile.writePropertiesFile();
	}
	
	/**
	 * Select the Browser to use
	 * @author maurerpa
	 * @date 24.01.2018
	 */
	public static void setBrowser() {
		//
		browser = "Chrome";
	}
	
	public static void setBrowserConfiguration() {
		String projectLocation = System.getProperty("user.dir");
				
		// this condition block sets config for firefox browser
		if (browser.contains("Firefox")){
		System.setProperty("webdriver.gecko.driver", projectLocation+"\\lib\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		}
		
		if (browser.contains("Chrome")) {
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		driver = new ChromeDriver();
		}
	}
	
	public static void runTest() {
		driver.get("http://www.seleniumhq.org/");
		driver.quit();
	}
	
}
