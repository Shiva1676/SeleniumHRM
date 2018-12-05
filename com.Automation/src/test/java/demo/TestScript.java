/**
 * 
 */
package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import factoryProvider.ExcelTest;
import pageObjectModel.LoginLocators;
import testCases.BaseClass;

/**
 * @author Lenovo
 *
 */
/*public class TestScript extends BaseClass{

	WebDriver driver;
	
	@Test
	public  void test1(){
		
	LoginLocators login = PageFactory.initElements(driver, LoginLocators.class);
		
		ExcelTest excel = new ExcelTest();
		
		int rows = excel.getRow("Sheet1");
		
		int columns = excel.getcolumn("Sheet1");
		
		for(int i=0; i<rows ; i++){
			String uName ="";
			String passWord = "";
			for(int j=0; j<columns; j++){
				if (j ==0)
					uName = ExcelTest.getData("Sheet1", i, j);
				if (j ==1)
					passWord = ExcelTest.getData("Sheet1", i, j);
			}
			System.out.println(uName+"--"+ passWord);
			
			boolean status = login.getLoginDetails(uName, passWord);
			
			if(status==true){
				
			System.out.println("PASS");
				
			}else{
				System.out.println("FAIL");
			}
		}
	}
	
	
}*/
