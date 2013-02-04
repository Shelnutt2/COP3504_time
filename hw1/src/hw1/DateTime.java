/*
 * All code is released under the terms of the GNU GPL v3 or later
 * Copyrighted Seth Shelnutt 2013
 * UFID: 42941969 
 */
 
package hw1;

import java.util.Calendar;
import java.util.GregorianCalendar;

/** 
 * DateTime implements handling of dates using the GregorianCalendar class
 * built into java. 
 * 
 * @author Seth Shelnutt
 * @version 1.0*/
public class DateTime {

    private GregorianCalendar gregorianCalendar;
    
    /** 
     * Initializes a instance of DateTime based on the current date
     */
	public DateTime(){
		gregorianCalendar=new GregorianCalendar();
	}
	/** 
     * Initializes a instance of DateTime based on the current date
     * 
     * @param calendar Takes input of GregorianCalendar instance
     */
	public DateTime(GregorianCalendar calendar){
		gregorianCalendar=calendar;
	}
	
	/** 
     * Initializes a instance of DateTime based on the current date
     * 
     * @param year   Year for calendar as an integer
     * @param month   Month for calendar as an integer
     * @param day   Day for calendar as an integer
     * @param hour   Hour for calendar as an integer
     * @param min   Minute for calendar as an integer
     * @param sec   Second for calendar as an integer
     * 
     */
	public DateTime(int year, int month, int day, int hour, int min, int sec){
		gregorianCalendar=new GregorianCalendar(year, month, day,  hour,  min, sec); 
	}
	
	/** 
	 *  
	 *  @return   current date in format mm/dd/yyyy, hh:mm:ss”. 
	 */
	public String toString(){
		String smonth = Integer.toString(this.gregorianCalendar.get(Calendar.MONTH));
		String sday = Integer.toString(this.gregorianCalendar.get(Calendar.DAY_OF_MONTH));
		String syear = Integer.toString(this.gregorianCalendar.get(Calendar.YEAR));
		String shour = Integer.toString(this.gregorianCalendar.get(Calendar.HOUR));
		String sminute = Integer.toString(this.gregorianCalendar.get(Calendar.MINUTE));
		String ssecond =Integer.toString(this.gregorianCalendar.get(Calendar.SECOND));
		
		return smonth + "/" + sday + "/" + syear + ", " + shour + ":" + sminute + ":" + ssecond;
	}
	/** 
	 * 
	 * @return   year of calendar as an integer
	 */
	public int getYear(){
		return this.gregorianCalendar.get(Calendar.YEAR);
		
	}
	
	/** 
	 * 
	 * @return   month of calendar as an integer
	 */
	public int getMonth(){
		return this.gregorianCalendar.get(Calendar.MONTH);
		
	}
	
	/** 
	 * 
	 * @return   Day of calendar as an integer
	 */
	public int getDay(){
		return this.gregorianCalendar.get(Calendar.DAY_OF_MONTH);
	
	}
	
	/** 
	 * 
	 * @return   Hour of calendar as an integer
	 */
	public int getHour(){
		return this.gregorianCalendar.get(Calendar.HOUR);
	
	}
	
	/** 
	 * 
	 * @return   Minute of calendar as an integer
	 */
	public int getMinute(){
		return this.gregorianCalendar.get(Calendar.MINUTE);	
	}
	
	/** 
	 * 
	 * @return   Seconds of calendar as an integer
	 */
	public int getSecond(){
		return this.gregorianCalendar.get(Calendar.SECOND);	
	}
	
	/** 
	 * Add an instance of time to the current calendar and returns new calendar
	 * 
	 * @param time  Takes Time instance
	 * @return   new calendar with added time
	 */
	public DateTime add(Time time){		
		GregorianCalendar newcal = (GregorianCalendar) this.gregorianCalendar.clone();
		newcal.add(Calendar.DAY_OF_YEAR, time.getDays());
		newcal.add(Calendar.HOUR, time.getHours());
		newcal.add(Calendar.MINUTE, time.getMinutes());
		newcal.add(Calendar.SECOND, time.getSeconds());
		return new DateTime(newcal);
	}
	
	/** 
	 * Subtracts an instance of time from the current calendar and returns new calendar
	 * 
	 * @param time  Takes Time instance
	 * @return   new calendar with subtracted time
	 */
	public DateTime subtract(Time time){
		GregorianCalendar newcal = (GregorianCalendar) this.gregorianCalendar.clone();
		newcal.add(Calendar.DAY_OF_YEAR, time.getDays());
		newcal.add(Calendar.HOUR, time.getHours());
		newcal.add(Calendar.MINUTE, time.getMinutes());
		newcal.add(Calendar.SECOND, time.getSeconds());
		return new DateTime(newcal);
	}
	
	/** 
	 * Subtracts an instance of dateTime from the current calendar and returns an instance of time
	 * 
	 * @param dateTime  Takes dateTime instance
	 * @return   new Time instance with subtracted time
	 */
	public Time subtract(DateTime dateTime){
		int day = 0, hour = 0, min = 0, sec = 0;
		long datemili = this.gregorianCalendar.getTimeInMillis() - dateTime.gregorianCalendar.getTimeInMillis();
		while(datemili >=1000){
			sec +=1;
			datemili -=1000;
		}
		while(sec >= 60){
			min +=1;
			sec -=60;
		}
		while(min >=60){
			hour +=1;
			min -=60;
		}
		while(hour >=24){
			day +=1;
			hour -=1;
		}
		return new Time(day,hour,min,sec);
	}

}
