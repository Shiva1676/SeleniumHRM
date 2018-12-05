/**
 * 
 */
package factoryProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Lenovo
 *
 */
public class ExcelInformation {

	XSSFWorkbook wb;

	public Object[][] getExcelData(String excelLocation, String sheetname) {

		try {
			File src = new File(excelLocation);

			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			
			System.out.println("========Unable to load excel=========");
			
			System.out.println(e.getMessage());
			
		} 
		
		int rows = wb.getSheet(sheetname).getPhysicalNumberOfRows();
		
		int columns = wb.getSheet(sheetname).getRow(0).getLastCellNum();
		
		Object[][] arr = new Object[rows][columns];
		
		for(int i=0; i<rows; i++){
			
			for(int j=0; j<columns; j++){
				
				XSSFCell cell = wb.getSheet(sheetname).getRow(i).getCell(j);
				
				if(cell == null){
					
					continue;
					
				}
				
				DataFormatter df = new DataFormatter();
				
				arr[i][j] = df.formatCellValue(cell);
			}
		}
		
		return arr;

	}

}
