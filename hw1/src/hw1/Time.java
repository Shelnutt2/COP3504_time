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
		int atime[] = {time.getDays(),time.getHours(),time.getMinutes(),time.getSeconds()};
		boolean negative = false;
		for(int i = 0; i < atime.length;i++){
			if(atime[i]<0){
				negative = true;
				atime[i] = -atime[i];
			}
		}
		if(negative){
			return subtract(new Time(atime[0],atime[1],atime[2],atime[3]));
		}
		long newmili = TimeUnit.MILLISECONDS.convert(time.getDays(), TimeUnit.DAYS) + TimeUnit.MILLISECONDS.convert(time.getHours(), TimeUnit.HOURS) +  TimeUnit.MILLISECONDS.convert(time.getMinutes(), TimeUnit.MINUTES) +  TimeUnit.MILLISECONDS.convert(time.getSeconds(), TimeUnit.SECONDS);
		long oldmili = TimeUnit.MILLISECONDS.convert(this.getDays(), TimeUnit.DAYS) + TimeUnit.MILLISECONDS.convert(this.getHours(), TimeUnit.HOURS) +  TimeUnit.MILLISECONDS.convert(this.getMinutes(), TimeUnit.MINUTES) +  TimeUnit.MILLISECONDS.convert(this.getSeconds(), TimeUnit.SECONDS);
        long diffmili = oldmili + newmili;
    	int nday = 0, nhour = 0, nmin = 0, nsec = 0;
    	while(diffmili >= 1000){
    		nsec++;
    		diffmili -=1000;
    	}
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
		int atime[] = {time.getDays(),time.getHours(),time.getMinutes(),time.getSeconds()};
		boolean negative = false;
		for(int i = 0; i < atime.length;i++){
			if(atime[i]<0){
				negative = true;
				atime[i] = -atime[i];
			}
		}
		if(negative){
			return add(new Time(atime[0],atime[1],atime[2],atime[3]));
		}
		long newmili = TimeUnit.MILLISECONDS.convert(time.getDays(), TimeUnit.DAYS) + TimeUnit.MILLISECONDS.convert(time.getHours(), TimeUnit.HOURS) +  TimeUnit.MILLISECONDS.convert(time.getMinutes(), TimeUnit.MINUTES) +  TimeUnit.MILLISECONDS.convert(time.getSeconds(), TimeUnit.SECONDS);
		long oldmili = TimeUnit.MILLISECONDS.convert(this.getDays(), TimeUnit.DAYS) + TimeUnit.MILLISECONDS.convert(this.getHours(), TimeUnit.HOURS) +  TimeUnit.MILLISECONDS.convert(this.getMinutes(), TimeUnit.MINUTES) +  TimeUnit.MILLISECONDS.convert(this.getSeconds(), TimeUnit.SECONDS);
        long diffmili = oldmili - newmili;
        if(diffmili < 0){
        	diffmili *=-1;
        }
    	int nday = 0, nhour = 0, nmin = 0, nsec = 0;
    	while(diffmili >= 1000){
    		nsec++;
    		diffmili -=1000;
    	}
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
