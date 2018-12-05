/**
 * 
 */
package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjectModel.LoginLocators;

/**
 * @author Lenovo
 *
 */
public class TestCase01 extends BaseClass {

	ExtentTest logger;

	@BeforeMethod
	public void setUpReport() {

		logger = reports.startTest("===========Welcome to OrangeHRM Application===========");
	}

	@AfterMethod
	public void closeSetUpResport() {

		reports.endTest(logger);

	}

	@DataProvider(name = "Generator")
	public Object[][] dataGenerator() {

		String excelLocation = System.getProperty("user.dir") + "/TestData/Login.xlsx";

		String sheetname = "Sheet1";

		return getExcelFromFactory(excelLocation, sheetname);

	}

	@Test(dataProvider = "Generator")
	public void verifyLogin(String lv_uname, String lv_pass) {

		LoginLocators login = PageFactory.initElements(driver, LoginLocators.class);

		logger.log(LogStatus.INFO, "Automating OrangeHRM Application");

		boolean status = login.getLoginDetails(lv_uname, lv_pass);

		if(status){
			
			logger.log(LogStatus.PASS, "User is able to login");
			
		}else{
			
			System.out.println("==============User is not able to login============");
			
			logger.log(LogStatus.FAIL, "User is not able to login");
		}

	}

}
