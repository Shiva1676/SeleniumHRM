/**
 * 
 */
package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.SynElement;

/**
 * @author Lenovo
 *
 */
public class LoginPage {

	@FindBy(how = How.ID, using = "txtUsername")
	WebElement username;

	@FindBy(how = How.ID, using = "txtPassword")
	WebElement password;

	@FindBy(how = How.ID, using = "btnLogin")
	WebElement submitButton;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Welcome")
	WebElement admin;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Logout")
	WebElement logout;

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	public boolean getLoginPage(String uname, String pass) {

		/*username.sendKeys(uname);

		password.sendKeys(pass);

		submitButton.click();*/
		
		SynElement.waitForElement(driver, username).sendKeys(uname);
		
		SynElement.waitForElement(driver, password).sendKeys(pass);
		
		SynElement.waitForElement(driver, submitButton).click();

//		boolean status = false;
		
         boolean status =  SynElement.waitForElement(driver, admin).isDisplayed();
       
        /*if(status==true){
        
        	SynElement.waitForElement(driver, admin).click();
        	
        	SynElement.waitForElement(driver, logout).click();
        }else{
        	
        	System.out.println("=========Element not found========");
        }*/
        	
        	return status;
        

	/*	boolean status = false;

		WebDriverWait wait = new WebDriverWait(driver, 3);

		try {
			WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Welcome")));

			status = ele.isDisplayed();
			
			String url = driver.getCurrentUrl();
			
			boolean status_url = url.contains("dashboard");
			
			if(status_url==true){
				
				System.out.println("============URL is working as Expected=============");
			}

			} catch (Exception e) {

			System.out.println("==============Element not Found============");

			System.out.println(e.getMessage());
		}
		return status;
		}
*/	
	}
}
