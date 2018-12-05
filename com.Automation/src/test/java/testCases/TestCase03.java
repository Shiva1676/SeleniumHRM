/**
 * 
 */
package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factoryProvider.ExcelInformation;
import pageObjectModel.AdminPage;
import pageObjectModel.LoginPage;
import utility.Helper;

/**
 * @author Lenovo
 *
 */
public class TestCase03 extends BaseClass {
	ExtentTest logger;

	@BeforeMethod
	public void setUpReport() {

		logger = reports.startTest("===========Welcome to OrangeHRM Application===========");
		
	}

	@AfterMethod
	public void closeSetUpResport(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			logger.log(LogStatus.FAIL, logger.addScreenCapture(Helper.getScreenshots(driver)));

		}

		reports.endTest(logger);

	}

	@DataProvider(name = "Generator")
	public Object[][] dataGenerator() {

		ExcelInformation excel = new ExcelInformation();
		
		String excelLocation = System.getProperty("user.dir") + "/TestData/Login.xlsx";

		String sheetname = "Sheet2";
		
		return excel.getExcelData(excelLocation, sheetname);
		
		/*String excelLocation = System.getProperty("user.dir") + "/TestData/Login.xlsx";

		String sheetname = "Sheet2";

		return getExcelFromFactory(excelLocation, sheetname);*/

	}

	@Test(dataProvider = "Generator")
	public void verifyLogin(String lv_uname, String lv_pass, String lv_employeeName, String lv_userName,
			String lv_passWord, String lv_confirmPassWord) {

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
//		LoginLocators login = PageFactory.initElements(driver, LoginLocators.class);

		AdminPage adminPage = PageFactory.initElements(driver, AdminPage.class);

		boolean status = login.getLoginPage(lv_uname, lv_pass);
		
//		boolean status = login.getLoginDetails(lv_uname, lv_pass);
		
		if(status){
			
			logger.log(LogStatus.PASS, Helper.getScreenshots(driver));
			
			try {
				
				boolean status_admin = adminPage.getAddUser(lv_employeeName, lv_userName, lv_passWord, lv_confirmPassWord);
				
				System.out.println(status_admin);
				
				logger.log(LogStatus.PASS, logger.addScreenCapture(Helper.getScreenshots(driver)));
				
			} catch (Exception e) {
				
				logger.log(LogStatus.FAIL, logger.addScreenCapture(Helper.getScreenshots(driver)));
				
			}
			
			
			
		}else{
			
			System.out.println("==========User is not able to login=========");
		}

		

	}

}
