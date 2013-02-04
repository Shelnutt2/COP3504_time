package hw1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class DateTime {

    private int year, month,  day,  hour,  min,  sec;
    private GregorianCalendar gregorianCalendar;
    
	public DateTime(){
		gregorianCalendar=new GregorianCalendar();
	}
	public DateTime(GregorianCalendar calendar){
		gregorianCalendar=calendar;
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
		GregorianCalendar newcal = (GregorianCalendar) this.gregorianCalendar.clone();
		newcal.add(Calendar.DAY_OF_YEAR, time.getDays());
		newcal.add(Calendar.HOUR, time.getHours());
		newcal.add(Calendar.MINUTE, time.getMinutes());
		newcal.add(Calendar.SECOND, time.getSeconds());
		return new DateTime(newcal);
	}
	
	public DateTime subtract(Time time){
		GregorianCalendar newcal = (GregorianCalendar) this.gregorianCalendar.clone();
		newcal.add(Calendar.DAY_OF_YEAR, time.getDays());
		newcal.add(Calendar.HOUR, time.getHours());
		newcal.add(Calendar.MINUTE, time.getMinutes());
		newcal.add(Calendar.SECOND, time.getSeconds());
		return new DateTime(newcal);
	}
	
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
