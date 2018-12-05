/**
 * 
 */
package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Lenovo
 *
 */
public class LoginLocators {

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

	public LoginLocators(WebDriver driver) {

		this.driver = driver;
	}

	public boolean getLoginDetails(String uname, String pass) {

		username.sendKeys(uname);

		password.sendKeys(pass);

		submitButton.click();

		boolean status = false;

		WebDriverWait wait = new WebDriverWait(driver, 3);

		try {
			WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Welcome")));

			status = ele.isDisplayed();

			admin.click();

			Thread.sleep(500);

			logout.click();

		} catch (Exception e) {

			System.out.println("==============Element not Found============");

			System.out.println(e.getMessage());
		}

		/*
		 * try {
		 * 
		 * if (status == true) {
		 * 
		 * admin.click();
		 * 
		 * Thread.sleep(500);
		 * 
		 * logout.click();
		 * 
		 * }
		 * 
		 * } catch (Exception e) {
		 * 
		 * System.out.println("=========Element not found===========");
		 * 
		 * System.out.println(e.getMessage());
		 * 
		 * }
		 */
		return status;
	}
}
