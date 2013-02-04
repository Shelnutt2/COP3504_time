package hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class tester {

	@Test
	public void test_print() {
		   // MyClass is tested
		   DateTime tester = new DateTime(2013, 2, 3, 10, 41, 12);
		   
		   // Check if multiply(10,5) returns 50
		   assertEquals("Result", 2013, tester.getYear());
		   assertEquals("Result", 2, tester.getMonth());
		   assertEquals("Result", 3, tester.getDay());
		   assertEquals("Result", 10, tester.getHour());
		   assertEquals("Result", 41, tester.getMinute());
		   assertEquals("Result", 12, tester.getSecond());
		   
	}
	@Test
	public void to_string() {
		   // MyClass is tested
		   DateTime tester = new DateTime(2013, 2, 3, 10, 41, 12);
		   
		   // Check if multiply(10,5) returns 50
		   assertEquals("Result", "2/3/2013, 10:41:12", tester.toString());
		   assertEquals("Result", "2/3/2012, 10:41:24", tester.subtract(new Time(365,0,0,-12)).toString());
		   assertEquals("Result", 0 + " days, " + 0 + ":" +0+ ":"+12, tester.subtract(new DateTime(2013, 2, 3, 10, 41, 0)).toString());
		   assertEquals("Result", "0 days, 0:0:12", tester.subtract(new DateTime(2013, 2, 3, 10, 41, 0)).toString());
		   
	}
	@Test
	public void time_test_print() {
		   // MyClass is tested
		   Time tester = new Time(1, 12, 13, 0);
		   
		   // Check if multiply(10,5) returns 50
		   assertEquals("Result", 1, tester.getDays());
		   assertEquals("Result", 12, tester.getHours());
		   assertEquals("Result", 13, tester.getMinutes());
		   assertEquals("Result", 0, tester.getSeconds());
		   
		   
	}
	@Test
	public void time_test_add() {
		   // MyClass is tested
		   Time tester = new Time(1, 12, 13, 0);
		   
		   // Check if multiply(10,5) returns 50
		   assertEquals("Result",35 , tester.add(new Time(-1,-12,-13,-35)).getSeconds());
		   assertEquals("Result",0 , tester.add(new Time(-1,-12,-13,-35)).getMinutes());
		   assertEquals("Result",0 , tester.add(new Time(-1,-12,-13,-35)).getHours());
		  assertEquals("Result",-0 , tester.add(new Time(-1,-12,-13,-35)).getDays());
		   
		   
	}

}
