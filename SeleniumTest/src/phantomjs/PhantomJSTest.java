// PhantomJS needs selenium2 as Referenced Library (Build Path->Add to Build Path)
// Remove selenium3-server-standalone-*.jar from Build Path

package phantomjs;

import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomJSTest {
	
	public static void main(String[] args) {
		
		System.setProperty("phantomjs.binary.path", "E:\\IT\\eclipse\\workspace\\SeleniumTest\\lib\\phantomjs\\phantomjs.exe");
		
		//Create object for PhantomJSDriver class 
		PhantomJSDriver driver = new PhantomJSDriver();
		
		driver.get("http://seleniumhq.org/");
		
		System.out.println("Title of the web page is : " +driver.getTitle());
		
		driver.quit();
	}
}
