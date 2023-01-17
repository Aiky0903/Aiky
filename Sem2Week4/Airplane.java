
public class Airplane {
	private Parser parser;
	private Class EconomyClass;
	private Class FirstClass;

	public Airplane() {
		parser = new Parser();
		EconomyClass = new Class("Economy", 15, 6);
		FirstClass = new Class("First", 5, 4);
	}

	public void play() {
		show_seating();
		printWelcome();

		boolean quit = false;

		while (!quit) {
			Commands command = parser.getCommand();
			quit = checkCommand(command);
		}
	}

	public void show_seating() {
		System.out.println(FirstClass.getName() + " Class:\n");
		FirstClass.showSeats(); // Show Seats in First Class

		System.out.println();

		System.out.println(EconomyClass.getName() + " Class:\n");
		EconomyClass.showSeats(); // Show Seats in Economy Class

		System.out.println();
	}

	private boolean checkCommand(
			Commands command) { /*Checks the command passed it and 
								  executes the appropriate methods*/
		boolean quit = false;

		if (command.equals(Commands.SHOW)) {
			show_seating();
		} else if (command.equals(Commands.ADD)) {
			addPassenger();
		} else if (command.equals(Commands.QUIT)) {
			quit = true;
		} else if (command.equals(Commands.HELP)) {
			printHelp();
		}

		return quit;
	}

	private void addPassenger() { // Method to add passengers into the plane
		Class CurrentClass = parser.getClassType(EconomyClass, FirstClass);
		int amount = parser.getNumberofPassengers(CurrentClass);
		for (int i = 0; i < amount; i++) {
			SeatingPosition preference = parser.getPreference();
			search(CurrentClass, preference);
			int SeatNumber = parser.getSeatNumber();
			setSeat(CurrentClass, SeatNumber);
		}
	}

	private void search(Class CurrentClass, SeatingPosition preference) { /*Method to search up available seats
																			According to the passengers preference*/
		String ListofSeats = "List of available seats :";
		boolean hasSeat = false;
		int counter = 0;
		for (int row = 0; row < CurrentClass.getSeats().length; row++) {
			for (int column = 0; column < CurrentClass.getSeats()[row].length; column++) {
				Seat CurrentSeat = CurrentClass.getSeats()[row][column];
				if (CurrentSeat.isTaken() == false && CurrentSeat.getPosition().equals(preference)) {
					hasSeat = true;
					ListofSeats += " " + counter;
				}
				counter++;
			}
		}

		if (hasSeat)
			System.out.println(ListofSeats);
		else {
			System.out.println("There are no available seats");
		}
	}

	public void setSeat(Class CurrentClass, int SeatNumber) { /*Sets the seat according to passenger 
																preference and seat number*/
		int AmountofRows = CurrentClass.getSeats()[0].length;
		int row = SeatNumber / AmountofRows;
		int column = SeatNumber % AmountofRows;
		CurrentClass.getSeats()[row][column].setTaken(true);
		System.out.println(SeatNumber + " has been reserved");
		System.out.println();
	}

	private void printWelcome() {// Print Welcome messages
		System.out.println("Welcome to my Airplane Seating");
		System.out.println("My Airplane seating is a Airplane Seating simulator");
		System.out.println("Type 'help' if you need help");
	}

	private void printHelp() {// Print helpful info to the user including all available Commands
		System.out.println("Seats are numbered and labeled with W for Window, A for Aisle and C for Center");
		System.out.println("Seats labeled with XXXX are taken.");
		System.out.println();
		Commands.showCommands();
	}
}
