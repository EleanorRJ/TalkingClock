
import java.util.Scanner;
public class ClockMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Enter time in 24hr digital format:");
			System.out.println("Press return to end");
			String digitalTime = scanner.nextLine();
			
			if (digitalTime.isEmpty()) {
				break;
			}
			//Check the input is in the correct format
			if (!(digitalTime.length() == 5 && digitalTime.charAt(2) == ':')) {
				System.out.println("Incorrect input format. Use the 24hr digital format e.g. 09:05, 21:47");
				continue;
			}
			
			//Split hours and minutes
			String[] splits = digitalTime.split(":");
			
			//Check if hours and minutes are strings containing numbers
			if (isItNumeric(splits[0]) == false) {
				System.out.println("You must not enter any letters.");
				continue;
			}
			if (isItNumeric(splits[1]) == false) {
				System.out.println("You must not enter any letters.");
				continue;
			}
			
			//Convert strings to integers
			int hours = Integer.valueOf(splits[0]);
			int minutes = Integer.valueOf(splits[1]);
			
			//Initiate SpokenTime object ready to use its methods and add values
			SpokenTime outputTime = new SpokenTime();
		
			//Pass the hours and minutes variables to the object.
			//All the converting happens there.
			outputTime.convertHoursAndSet(hours);
			outputTime.convertMinutesAndSet(minutes);
		
			System.out.println(outputTime);
		}
		
	}
	
	public static boolean isItNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
}
