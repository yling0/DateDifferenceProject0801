package datedifference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateDifference {
	
	/**
	 * date2 > date1
	 * @param date1	
	 * @param date2
	 * @return	
	 */
	public static int differentDays(Date date1,Date date2)
	{
		Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        
        
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
		
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        
		
		
     // date 1 and date 2 in same year
		if(year1 != year2)   
		{
			int timeDistance = 0 ;
			for(int i = year1 ; i < year2 ; i ++)
			{
				// leap year
				if(i%4==0 && i%100!=0 || i%400==0)          
				{
					timeDistance += 366;
				}
				// not leap year
				else	
				{
					timeDistance += 365;
				}
			}
			
			return timeDistance + (day2-day1) ;
		}
		// date 1 and date 2 in different year
		else	
		{
			return day2-day1;
		}
	}
	
	
	public static void main(String[] args) 
	{
		String dateToday;
		System.out.println("Ente the date: (yyyy-mm-dd)");
		Scanner dateToday1 = new Scanner(System.in);
		dateToday = dateToday1.nextLine();
		
		
		String dateBirth;
		System.out.println("Enter your date of birth: (yyyy-mm-dd)");
		Scanner dateBirth1 = new Scanner (System.in);
		dateBirth = dateBirth1.nextLine();
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		try 
		{
			Date date1 = format.parse(dateBirth);
			Date date2 = format.parse(dateToday);
			
			System.out.println("The date difference：" + differentDays(date1,date2) + " Days");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}	
	
}
