package com.capgemini.datetest;
import java.time.LocalDate;
import java.time.Period;

/*class which has instance members as day, month and year & has behaviour which checks which date object is small,
also calculate the difference between two date objects and the store the difference of years, months & days in an
integer array*/
public class Date {
	
	private int day;
	private int month;
	private int year;
	
	// C'tor with arguments
	public Date(int day, int month, int year) {

		this.day = day;
		this.month = month;
		this.year = year;
	}

	//C'tor without any arguments
	public Date() {
		
	}
	
	@Override
	public String toString() {
		return "Date: " + day + "/" + month + "/" + year;
	}
	
	// method to find the smaller date between two dates
	public boolean isSmaller(Date date) {
		
		if(year < date.year) 
			return true;
		
		else if(year == date.year) {
			
			if(month < date.month)
				return true;
			else if(month == date.month) {
				
				if(day < date.day)
					return true;
				else
					return false;
			}
			else
				return false;
		}
		else 
			return false;
	}

	// method to get the difference between two dates and return an integer array
	public int[] difference(Date date) {
		
		int[] dateGap = new int[3];
		
		LocalDate previous = LocalDate.of(day, month, year);
		LocalDate current = LocalDate.of(date.day, date.month, date.year);
		
		if(year > date.year) {
			
			Period age = Period.between(previous, current);
			dateGap[0] = age.getDays();
			dateGap[1] = age.getMonths();
			dateGap[2] = age.getYears();
		}
		
		else {
			
			Period age = Period.between(current, previous);
			dateGap[0] = age.getDays();
			dateGap[1] = age.getMonths();
			dateGap[2] = age.getYears();
		}
		
		return dateGap;
	}
}
