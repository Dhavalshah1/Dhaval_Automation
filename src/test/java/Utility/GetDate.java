package Utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDate {

	public static String getDate(int date) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

		// get current date time with Date()
		Date date1 = new Date();

		// get calendar instance
		Calendar c = Calendar.getInstance();
		// set time to calendar
		c.setTime(date1);
		// add days to calendar
		c.add(Calendar.DATE, date);
		// print the new date
		String newDate = dateFormat.format(c.getTime());		
     return newDate;

	}

}