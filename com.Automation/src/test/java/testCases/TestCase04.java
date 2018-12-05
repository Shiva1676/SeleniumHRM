/**
 * 
 */
package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factoryProvider.ExcelTest;
import pageObjectModel.LoginPage;
import utility.Helper;
import utility.SynElement;

/**
 * @author Lenovo
 *
 */
public class TestCase04 extends BaseClass {
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

	/*
	 * @DataProvider(name = "Generator") public Object[][] dataGenerator() {
	 * 
	 * ExcelInformation excel = new ExcelInformation();
	 * 
	 * String excelLocation = System.getProperty("user.dir") +
	 * "/TestData/Login.xlsx";
	 * 
	 * String sheetname = "Sheet2";
	 * 
	 * return excel.getExcelData(excelLocation, sheetname);
	 * 
	 * String excelLocation = System.getProperty("user.dir") +
	 * "/TestData/Login.xlsx";
	 * 
	 * String sheetname = "Sheet2";
	 * 
	 * return getExcelFromFactory(excelLocation, sheetname);
	 * 
	 * }
	 */

	@Test
	public void verifyLogin() {

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		ExcelTest excel = new ExcelTest();

		int rows = excel.getRow("Sheet1");

		int columns = excel.getcolumn("Sheet1");

		for (int i = 0; i < rows; i++) {
			String uName = "";
			String passWord = "";
			for (int j = 0; j < columns; j++) {
				if (j == 0)
					uName = excel.getData("Sheet1", i, j);
				if (j == 1)
					passWord = excel.getData("Sheet1", i, j);

				 
				
			}
			System.out.println(uName + "--" + passWord);
			
			boolean status = false;

			 try {
				
				 status = login.getLoginPage(uName, passWord);
				 
				 if(status==true){
					 
					  driver.findElement(By.partialLinkText("Welcome")).click();
					 
					 Thread.sleep(500);
					 
					 driver.findElement(By.partialLinkText("Logout")).click();
					 
					 
					
				 }
				
			} catch (Exception e) {
				
				System.out.println("==============Unable to find Element=============");
			}
			
			

		}

	}
}
