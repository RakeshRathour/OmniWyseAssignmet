package com.omniwyse.task.ReadingExcelFileStoreSeparateTable;

	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Date;
import java.util.TimeZone;

	public class TimeCheck {
		
		private static Date getInTimeFromInput(String tempInDate) {
			String token[] = tempInDate.split("\\(");
			if (token == null || token.length == 0) {
			} else {
				// means SE is there
				tempInDate = token[0];
			}
			DateFormat df = new SimpleDateFormat("HH:mm:ss");
			df.setTimeZone(TimeZone.getTimeZone("UTC"));
			Date inTmeDate = null;
			try {
				inTmeDate = df.parse(tempInDate);
			} catch (java.text.ParseException e) {
				e.printStackTrace();
				inTmeDate = new Date();
			}
			return inTmeDate;
		}
		public static void main(String[] args) {
			Date indate = getInTimeFromInput("00:00:01");
			System.out.println(indate);
		}
	}

