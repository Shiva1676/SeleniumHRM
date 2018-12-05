/**
 * 
 */
package factoryProvider;

/**
 * @author Lenovo
 *
 */
public class ConfigProvider {

	public static ConfigurationDataProvider getConfig(){
		
		ConfigurationDataProvider config = new ConfigurationDataProvider();
		
		return config;
	}
	
	public static ExcelTest getExcel(){
		
		ExcelTest excelTest = new ExcelTest();
		
		return excelTest;
	}
	
}
