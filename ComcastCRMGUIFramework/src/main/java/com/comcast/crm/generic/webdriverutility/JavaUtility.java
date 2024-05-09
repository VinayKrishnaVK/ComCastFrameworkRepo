package com.comcast.crm.generic.webdriverutility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random Value=new Random();
		int RanValue = Value.nextInt(5000);
		return RanValue;
	}
	
	public String getStartDateYYYYMMDD() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String startDate=sdf.format(date);
		return startDate;
	}
	
	public String getEndDateYYYYMMDD(int days) {
		Date dref = new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dref);
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String endDate = sim.format(cal.getTime());		
		return endDate;
		
	}
}
