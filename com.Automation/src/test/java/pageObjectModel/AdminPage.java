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
import org.testng.Assert;

/**
 * @author Lenovo This script is used to store all the locators Created By:
 *         Ganesh Created On: 15-11-2018
 *
 */
public class AdminPage {

	@FindBy(how = How.XPATH, using = ".//b[text()= 'Admin']")
	WebElement adminTab;

	@FindBy(how = How.ID, using = "searchBtn")
	WebElement searchButton;

	@FindBy(how = How.ID, using = "btnAdd")
	WebElement addButton;

	@FindBy(how = How.ID, using = "resetBtn")
	WebElement resetButton;

	@FindBy(how = How.ID, using = "btnDelete")
	WebElement deleteButton;

	@FindBy(how = How.ID, using = "systemUser_employeeName_empName")
	WebElement employeeName;

	@FindBy(how = How.ID, using = "systemUser_userName")
	WebElement userName;

	@FindBy(how = How.ID, using = "systemUser_password")
	WebElement passWord;

	@FindBy(how = How.ID, using = "systemUser_confirmPassword")
	WebElement confirmPassWord;

	@FindBy(how = How.ID, using = "btnSave")
	WebElement adminSaveButton;

	WebDriver driver;

	public AdminPage(WebDriver driver) {

		this.driver = driver;
	}

	public boolean getAddUser(String lv_employeeName, String lv_userName, String lv_passWord, String lv_confirmPassWord) throws InterruptedException {

		adminTab.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("btnAdd")));

		String adminURL = driver.getCurrentUrl();
		
		Assert.assertTrue(adminURL.contains("admin/viewSystemUsers"));

		/*if (adminURL.contains("admin/viewSystemUsers")) {

			System.out.println("=============Logged to expected url===========");

		} else {

			System.out.println("========You have not logged to expected url. Please check!==========");
		}*/
		
		boolean status_add = addButton.isDisplayed();
		
		Assert.assertTrue(status_add);
		
		addButton.click();
		
		String addURL = driver.getCurrentUrl();
		
		Assert.assertTrue(addURL.contains("saveSystemUser"), "URL does not exist. Please check");
		
		employeeName.sendKeys(lv_employeeName);
		
		userName.sendKeys(lv_userName);
		
		passWord.sendKeys(lv_passWord);
		
		confirmPassWord.sendKeys(lv_confirmPassWord);
		
		Thread.sleep(500);
		
		adminSaveButton.click();
		
		boolean status1= false;
		
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		
		WebElement ele = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//a[text()= 'Kishore']")));
		
		status1 = ele.isDisplayed();
		
		Assert.assertTrue(status1);
		
		return status1;

	}

}
