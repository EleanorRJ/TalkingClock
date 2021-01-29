
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
			//Check the input is valid
			if (!(digitalTime.length() == 5 && digitalTime.charAt(2) == ':')) {
				System.out.println("Incorrect input format. Use the 24hr digital format e.g. 09:05, 21:47");
			}
			
			//Split hours and minutes
			String[] splits = digitalTime.split(":");
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
	
}
