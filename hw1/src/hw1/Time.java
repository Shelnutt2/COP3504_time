/*
 * All code is released under the terms of the GNU GPL v3 or later
 * Copyrighted Seth Shelnutt 2013
 * UFID: 42941969 
 */

package hw1;

import java.util.concurrent.TimeUnit;

/** 
 * Time implements handling of time instances
 *  
 * @author Seth Shelnutt
 * @version 1.0*/
public class Time {
	
    private int  day,  hour,  min,  sec;
    /** 
     * Initializes a instance of Time with given parameters.
     * Automatically handles cases were units roll over.
     * 
     * @param day  Input number of days
     * @param hour Input number of hours
     * @param min Input number of minutes
     * @param sec Input number of seconds
     */
	public Time(int day, int hour, int min, int sec) {
		while(sec >= 60){ //Handle if the user inputs more time than each element's base 
			min++;
			sec -=60;
		}
		while(min >= 60){
			hour++;
			min -=60;
		}
		while(hour >= 24){
			day++;
			hour--;
		}
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.sec = sec;
	}
	
	/** 
	 *  
	 *  @return   current date in format “dd ‘days’, hh:mm:ss”. 
	 */
	public String toString(){
		return Integer.toString(this.day) + " days, " + Integer.toString(hour) + ":" + Integer.toString(min) + ":" + Integer.toString(sec);
	} 
	/** Returns the total number of days
	 *  In this case total days will be the same as getdays()
	 * @return Number of days as an integer.
	 */
	public int get_total_Days(){
		return this.day;
	}

    /** Returns the total number of hours in the Time instance
     *  Differs from getHours, by converting all units to hours	
     * @return total hours as an integer.
     */
	public int get_total_Hours(){
		int hours = (int) TimeUnit.HOURS.convert(this.day, TimeUnit.DAYS) + this.hour;
		return hours;
	}
	
	/** Returns the total number of minutes in the Time instance
     *  Differs from getMinutes, by converting all units to minutes	
     * @return total minutes as an integer
     */
	public int get_total_Minutes(){
		int minutes = (int) ( TimeUnit.MINUTES.convert(this.day, TimeUnit.DAYS) + TimeUnit.MINUTES.convert(this.hour, TimeUnit.HOURS) + this.min);
		return minutes;
	}
	
	/** Returns the total number of seconds in the Time instance
     *  Differs from getSeconds, by converting all units to seconds	
     * @return total second as an integer
     */
	public int get_total_Seconds(){
		int seconds = (int) ( TimeUnit.SECONDS.convert(this.day, TimeUnit.DAYS) + TimeUnit.SECONDS.convert(this.hour, TimeUnit.HOURS) + TimeUnit.SECONDS.convert(this.min, TimeUnit.MINUTES) + this.sec);
		return seconds;
	}
	
	/** returns days from Time instance
	 * 
	 * @return   Days of Time instance as an integer
	 */
	public int getDays(){
		return this.day;
	}
	
	/** returns hours from Time instance
	 * 
	 * @return   Hours of Time instance as an integer
	 */
	public int getHours(){
		return this.hour;
	}
	
	/** returns minutes from Time instance
	 * 
	 * @return   Minutes of Time instance as an integer
	 */
	public int getMinutes(){
		return this.min;
	}
	
	/** returns seconds from Time instance
	 * 
	 * @return   Seconds of Time instance as an integer
	 */
	public int getSeconds(){
		return this.sec;
	}
	
	/**
	 * Add a given time instance to current time instance.
	 * @param time Takes input of time to be added to current time instance
	 * @return  New instance of time class with time addition
	 */
	public Time add(Time time){
		int atime[] = {time.getDays(),time.getHours(),time.getMinutes(),time.getSeconds()}; 
		boolean negative = false; //Boolean for negative check
		for(int i = 0; i < atime.length;i++){  //Iterate through array to check if we are adding negative time
			if(atime[i]<0){
				negative = true;
				atime[i] = -atime[i]; //Convert to positive integers for computation
			}
		}
		if(negative){ //adding a negative is just subtraction
			return subtract(new Time(atime[0],atime[1],atime[2],atime[3]));
		}
		long newseconds = TimeUnit.SECONDS.convert(time.getDays(), TimeUnit.DAYS) + TimeUnit.SECONDS.convert(time.getHours(), TimeUnit.HOURS) +  TimeUnit.SECONDS.convert(time.getMinutes(), TimeUnit.MINUTES) +  TimeUnit.SECONDS.convert(time.getSeconds(), TimeUnit.SECONDS); //Convert to seconds
		long oldseconds = TimeUnit.SECONDS.convert(this.getDays(), TimeUnit.DAYS) + TimeUnit.SECONDS.convert(this.getHours(), TimeUnit.HOURS) +  TimeUnit.SECONDS.convert(this.getMinutes(), TimeUnit.MINUTES) +  TimeUnit.SECONDS.convert(this.getSeconds(), TimeUnit.SECONDS); //Convert to seconds
        long diffseconds = oldseconds + newseconds; //Add time in milliseconds to get new time.
    	int nday = 0, nhour = 0, nmin = 0;
		while(diffseconds >= 60){ //Convert from seconds to minutes
			nmin++;
			diffseconds -=60;
		}
		while(nmin >= 60){ //Convert minutes to hours
			nhour++;
			nmin -=60;
		}
		while(nhour >= 24){ //Convert hours to days.
			nday++;
			nhour-=24;
		}
		return new Time(nday,nhour,nmin,(int)diffseconds);
	}
	
	/**
	 * Subtract a given time instance from current time instance.
	 * @param time Takes input of time to be subtracted from the current time instance
	 * @return  New instance of time class with time subtracted
	 */
	public Time subtract(Time time){
		int atime[] = {time.getDays(),time.getHours(),time.getMinutes(),time.getSeconds()}; //Create an array of the inputed time
		boolean negative = false; //Boolean for negative check
		for(int i = 0; i < atime.length;i++){ //Iterate through array to check if we are subtracting negative time
			if(atime[i]<0){
				negative = true;
				atime[i] = -atime[i]; //Convert to positive integers for computation
			}
		}
		if(negative){ //Subtracting negative time is just addition.
			return add(new Time(atime[0],atime[1],atime[2],atime[3]));
		}
		long newseconds = TimeUnit.SECONDS.convert(time.getDays(), TimeUnit.DAYS) + TimeUnit.SECONDS.convert(time.getHours(), TimeUnit.HOURS) +  TimeUnit.SECONDS.convert(time.getMinutes(), TimeUnit.MINUTES) +  TimeUnit.SECONDS.convert(time.getSeconds(), TimeUnit.SECONDS); //Convert to seconds
		long oldseconds = TimeUnit.SECONDS.convert(this.getDays(), TimeUnit.DAYS) + TimeUnit.SECONDS.convert(this.getHours(), TimeUnit.HOURS) +  TimeUnit.SECONDS.convert(this.getMinutes(), TimeUnit.MINUTES) +  TimeUnit.SECONDS.convert(this.getSeconds(), TimeUnit.SECONDS); //Convert to seconds
        long diffseconds = oldseconds - newseconds; //Subtract time in milliseconds to get new time.
    	int cday = 1, nday = 0, nhour = 0, nmin = 0;
    	if(diffseconds < 0){ //If out difference is 
    		diffseconds *= -1;
    		cday = -1; //Multiply days by negative 1 in return to signal negative time difference.
    	}
		while(diffseconds >= 60){  //Convert from seconds to minutes
			nmin++;
			diffseconds -=60;
		}
		while(nmin >= 60){ //Convert minutes to hours.
			nhour++;
			nmin -=60;
		}
		while(nhour >= 24){ //Convert hours to days.
			nday++;
			nhour -=24;
		}
		return new Time(cday*nday,nhour,nmin,(int)diffseconds);
	}
	
}
