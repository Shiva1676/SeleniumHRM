/**
 * 
 */
package factoryProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Lenovo
 *
 */
public class ExcelTest {

	 XSSFWorkbook wb;

	public ExcelTest() {

		String path = "C:/Users/Lenovo/workspace1/com.Automation/TestData/Login.xlsx";

		try {
			File src = new File(path);

			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

			System.out.println("=========Excel Loaded==========");

		} catch (Exception e) {

			System.out.println("======Unable to load excel=======");

			System.out.println(e.getMessage());
		}

	}

	public int getRow(String sheetname) {

		return wb.getSheet(sheetname).getPhysicalNumberOfRows();

	}

	public int getcolumn(String sheetname) {

		return wb.getSheet(sheetname).getRow(0).getLastCellNum();

	}

	public String getData(String sheetname, int rows, int column) {

		System.out.println(sheetname + " " + rows + " " + column);

		System.out.println(wb.getSheet(sheetname).getRow(rows).getCell(column).getStringCellValue());

		return wb.getSheet(sheetname).getRow(rows).getCell(column).getStringCellValue();
	}

}
