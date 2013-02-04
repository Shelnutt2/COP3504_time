package hw1;

import java.util.concurrent.TimeUnit;

public class Time {
	
    private int  day,  hour,  min,  sec;
	public Time(int day, int hour, int min, int sec) {
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.sec = sec;
	}
	public String toString(){
		return Integer.toString(this.day) + " days, " + Integer.toString(hour) + ":" + Integer.toString(min) + ":" + Integer.toString(sec);
	} 
	
	public int get_total_Days(){
		return this.day;
	}
	
	public int get_total_Hours(){
		int hours = (int) TimeUnit.HOURS.convert(this.day, TimeUnit.DAYS) + this.hour;
		return hours;
	}
	
	public int get_total_Minutes(){
		int minutes = (int) ( TimeUnit.MINUTES.convert(this.day, TimeUnit.DAYS) + TimeUnit.MINUTES.convert(this.hour, TimeUnit.HOURS) + this.min);
		return minutes;
	}
	
	public int get_total_Seconds(){
		int seconds = (int) ( TimeUnit.SECONDS.convert(this.day, TimeUnit.DAYS) + TimeUnit.SECONDS.convert(this.hour, TimeUnit.HOURS) + TimeUnit.SECONDS.convert(this.min, TimeUnit.MINUTES) + this.sec);
		return seconds;
	}
	
	public int getDays(){
		return this.day;
	}
	
	public int getHours(){
		return this.hour;
	}
	
	public int getMinutes(){
		return this.min;
	}
	
	public int getSeconds(){
		return this.sec;
	}
	
	public Time add(Time time){
		int nday =  this.getDays() + time.getDays();
		int nhour = this.getHours() + time.getHours();
		int nmin = this.getMinutes() + time.getMinutes();
		int nsec = this.getSeconds() + time.getSeconds();
		while(nsec >= 60){
			nmin++;
			nsec -=60;
		}
		while(nmin >= 60){
			nhour++;
			nmin -=60;
		}
		while(nhour >= 24){
			nday++;
			nhour--;
		}
		return new Time(nday,nhour,nmin,nsec);
	}
	public Time subtract(Time time){
		int nday =  this.getDays() - time.getDays();
		int nhour = this.getHours() - time.getHours();
		int nmin = this.getMinutes() - time.getMinutes();
		int nsec = this.getSeconds() - time.getSeconds();
		while(nsec >= 60){
			nmin++;
			nsec -=60;
		}
		while(nmin >= 60){
			nhour++;
			nmin -=60;
		}
		while(nhour >= 24){
			nday++;
			nhour--;
		}
		return new Time(nday,nhour,nmin,nsec);
	}
	
}
