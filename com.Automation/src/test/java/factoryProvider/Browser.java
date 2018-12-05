/**
 * 
 */
package factoryProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Lenovo
 *
 */
public class Browser {

	static WebDriver driver;
	
	public static WebDriver getBrowserURL(String browser, String url){
		
		if(browser.equalsIgnoreCase("chrome")){
			
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			System.out.println("The following script is running on:"+browser);
		}
		
		driver.get(url);
		
		return driver;
	}
	
}
