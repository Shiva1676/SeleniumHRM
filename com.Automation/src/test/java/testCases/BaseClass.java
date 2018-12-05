/**
 * 
 */
package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;

import factoryProvider.Browser;
import factoryProvider.ConfigProvider;
import factoryProvider.ExcelInformation;
import utility.CustomDateFormat;

/**
 * @author Lenovo
 *
 */
public class BaseClass {

	WebDriver driver;

	ExtentReports reports;

	@BeforeSuite
	public void startReport() {

		String path = System.getProperty("user.dir") +"/Reports/HRM"+ " "+ CustomDateFormat.getDateAndTime()+ ".html";

		reports = new ExtentReports(path);
	}

	@AfterSuite
	public void closeReport() {

		reports.flush();
	}

	@BeforeTest
	public void setUpBrowser() {

		driver = Browser.getBrowserURL(ConfigProvider.getConfig().getBrowser(), ConfigProvider.getConfig().getURL());

	}

	@AfterTest
	public void closeBrowser() {

		driver.quit();

	}

	public Object[][] getExcelFromFactory(String excelLocation, String sheetname) {

		ExcelInformation excel = new ExcelInformation();

		return excel.getExcelData(excelLocation, sheetname);
	}

}
