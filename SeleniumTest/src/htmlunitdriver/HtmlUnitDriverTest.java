package htmlunitdriver;

import java.lang.reflect.Field;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

public class HtmlUnitDriverTest {

	private static String strTitle;
	
	public static void main(String[] args) throws Exception {
		
		//HtmlUnitDriver driver = new HtmlUnitDriver();
		HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.EDGE);
		
		driver.get("http://seleniumhq.org/");
		
		System.out.println("Title is : " +driver.getTitle());
		strTitle = driver.getTitle();
		
		//How to confirm and validate that your test ran on some specific browser 
		WebClient webClient = (WebClient) get(driver, "webClient"); 
		
		System.out.println("Browser ver is : "+webClient.getBrowserVersion());
		System.out.println("Is browser Edge: "+webClient.getBrowserVersion().isEdge());
		System.out.println("Is browser Firefox: "+webClient.getBrowserVersion().isFirefox());
		
		driver.quit();
	}
	
	//How to confirm and validate that your test ran on some specific browser 
	private static Object get(Object object, String field) throws Exception {
		Field f = object.getClass().getDeclaredField(field);
		f.setAccessible(true); 
		return f.get(object); 
	} 
	
}
