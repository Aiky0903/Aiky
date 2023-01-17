import java.util.Scanner;
	/* 
	 * Parser is to get user input using scanner and convert user input
	 * into a commands for the game to process and use
	 */

public class Parser {
	private Scanner reader; // Scanner to scan and read the input from user

	
	public Parser() {
		reader = new Scanner(System.in);
	}

	public String getInput() { // Method to get input from user (in String format)
		String inputLine;

		System.out.print("> ");

		inputLine = reader.nextLine();

		return inputLine;
	}

	public Commands getCommand() { // Checks if user input is a valid command

		System.out.println("Please enter a command:");
		String inputLine = getInput();

		while (!Commands.isValidCommand(inputLine)) {
			System.out.println("I dont know what you mean....");
			inputLine = getInput();
		}

		Commands newCommand = Commands.processinputLine(inputLine); // Converts the inputLine to a Command object

		return newCommand;
	}

	public Class getClassType(Class Economy, Class First) { // Method to get Passengers Class type
		String Classtype;
		
		do {
			System.out.println("Please enter your class of choice (" + Economy.getName() + " / " + First.getName() + ")");
			Classtype = getInput();
		} while (!Classtype.equalsIgnoreCase(First.getName()) && !Classtype.equalsIgnoreCase(Economy.getName()));

		if (Classtype.equalsIgnoreCase(Economy.getName())) {
			return Economy;
		} else {
			return First;
		}
	}

	public int getNumberofPassengers(Class Class) { //Method to get number of Passengers 

		if (Class.getName().equalsIgnoreCase("First")) {
			return NumberofPassengers(1, 2);
		} else {
			return NumberofPassengers(1, 3);
		}
	}

	public int NumberofPassengers(int min, int max) { //Method to set Limit on Passengers according to Class
		String prompt = "Please enter the number of passengers " + min + " to " + max;
		System.out.println(prompt);
		int amount = Integer.parseInt(getInput());
		
		while (amount < min || amount > max){
			System.out.println("Invalid amount");
			amount = Integer.parseInt(getInput());
		}
		return amount;
	}

	public SeatingPosition getPreference() { //Method to get Seat Preference
		String preference;
		do {
			System.out.println("Please enter your seat preference: (Aisle / Window / Center)");
			preference = getInput();
		}while(!SeatingPosition.isValidPosition(preference));
		
		SeatingPosition Preference = SeatingPosition.processSeatingPosition(preference);
		
		return Preference;
	}
	
	public int getSeatNumber() {
		System.out.println("Please enter your prefered seat number: ");
		int SeatNumber = Integer.parseInt(getInput());
		return SeatNumber;
	}
}