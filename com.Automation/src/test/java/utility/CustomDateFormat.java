/**
 * 
 */
package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lenovo
 *
 */
public class CustomDateFormat {

	
	public static String getDateAndTime(){
		
		DateFormat dateFormat =  new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		
		Date date = new Date();
		
		return dateFormat.format(date);
		
		
	}
	
}
