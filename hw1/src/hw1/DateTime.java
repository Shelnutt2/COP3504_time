package hw1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTime {

    private int year, month,  day,  hour,  min,  sec;
    private GregorianCalendar gregorianCalendar;
    
	public DateTime(){
		gregorianCalendar=new GregorianCalendar();
		
	}
	
	public DateTime(int year, int month, int day, int hour, int min, int sec){
		gregorianCalendar=new GregorianCalendar(year, month, day,  hour,  min, sec); 
		
	}
	
	public String toString(){
		//mm/dd/yyyy, hh:mm:ss”.
		String smonth = Integer.toString(this.gregorianCalendar.get(Calendar.MONTH));
		String sday = Integer.toString(this.gregorianCalendar.get(Calendar.DAY_OF_MONTH));
		String syear = Integer.toString(this.gregorianCalendar.get(Calendar.YEAR));
		String shour = Integer.toString(this.gregorianCalendar.get(Calendar.HOUR));
		String sminute = Integer.toString(this.gregorianCalendar.get(Calendar.MINUTE));
		String ssecond =Integer.toString(this.gregorianCalendar.get(Calendar.SECOND));
		
		return smonth + "/" + sday + "/" + syear + ", " + shour + ":" + sminute + ":" + ssecond;
	}
	
	public int getYear(){
		return this.gregorianCalendar.get(Calendar.YEAR);
		
	}
	
	public int getMonth(){
		return this.gregorianCalendar.get(Calendar.MONTH);
		
	}
	
	public int getDay(){
		return this.gregorianCalendar.get(Calendar.DAY_OF_MONTH);
	
	}
	
	public int getHour(){
		return this.gregorianCalendar.get(Calendar.HOUR);
	
	}
	
	public int getMinute(){
		return this.gregorianCalendar.get(Calendar.MINUTE);	
	}
	
	public int getSecond(){
		return this.gregorianCalendar.get(Calendar.SECOND);	
	}
	
	public DateTime add(Time time){		
		
	}
	
	public DateTime subtract(Time time){
		
	}
	
	public Time subtract(DateTime dateTime){
		
	}

}
