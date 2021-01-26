
public class SpokenTime {
	private String spokenHours;
	private String spokenMinutes;
	private String amOrPm;
	
	public SpokenTime(){
		//constructor starts as an 'am' time
		this.amOrPm = "am";
	}
	
	//setters I didn't need in the end
	public void makePm(String pm) {
		this.amOrPm = pm;
	}
	
	public void setSpokenHours(String hours) {
		this.spokenHours = hours;
	}
	
	public void setSpokenMinutes(String minutes) {
		this.spokenMinutes = minutes;
	}
	
	//takes the integer variable 'hours', passes it to the numbers
	//to text converter methods, then sets spokenHours to the returned string.
	//If "oh" is returned changes it to twelve and checks if pm.
	public void convertHoursAndSet(int hours) {	
		if (hours >= 12) {
			hours = hours - 12;
			this.amOrPm = "pm";
		}
		
		this.spokenHours = numbersToText(hours);
		if (this.spokenHours.equals("oh")) {
			this.spokenHours = "twelve";
		}
	}
	
	//Converts the integer variable 'minutes' to a string using the numbersToText
	//method, then sets spokenMinutes to the returned string.
	//Deals with if 'minutes' is 00 and adds 'oh'.
	public void convertMinutesAndSet(int minutes) {
		if (minutes == 0) {
			this.spokenMinutes = "zero";
		} else if (minutes < 10) {
			this.spokenMinutes = "oh " + numbersToText1To19(minutes);
		} else {
			this.spokenMinutes = numbersToText(minutes);
		}
	}
	
	//If the number is above 20 it is given a tens value based on the 1st
	//digit and the second digit passed to the 1to19 converter below. 
	//If it is below 20 it is just passed to the 1to19 converter.
	//00 values are aren't dealt with here because spokenHours and spokenMinutes
	//need to receive different strings
	public String numbersToText(int num) {
		
		if (num == 50) {
			return "fifty";
		}
		if (num > 50) {
			int minuteHolder = num - 50;
			String Part2 = numbersToText1To19(minuteHolder);
			return "fifty " + Part2;
		}
		if (num > 40) {
			return "forty";
		}
		if (num > 40) {
			int holder = num - 40;
			String Part2 = numbersToText1To19(holder);
		return "fourty" + Part2;
		}
		if (num == 30) {
			return "thirty";
		}
		if (num > 30) {
			int holder = num - 30;
			String Part2 = numbersToText1To19(holder);
			return "thirty " + Part2;
		}
		if (num == 20) {
			return "twenty";
		}
		if (num > 20) {
			int holder = num - 20;
			String Part2 = numbersToText1To19(holder);
			return "twenty " + Part2;
		}
		return numbersToText1To19(num);
		
	}
	
	//numbers 1 to 19 are dealt with here as they are needed for hours and minutes
	public String numbersToText1To19(int num) {
		String[] oneToNine = {"zero", "one", "two", "three", "four", "five", "six", "seven",
				"eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
				"fithteen", "sixteen", "seventeen", "eighteen", "nineteen"}; 
		return oneToNine[num];
		
	}
	
	//How I've stuck all the strings together and formatted them to be printed
	public String toString() {
		if (this.spokenMinutes.equals("zero")) {
			return "It's " + this.spokenHours + " " + this.amOrPm;
		}
		return "It's " + this.spokenHours + " " + this.spokenMinutes + " " + this.amOrPm;
	}

}
