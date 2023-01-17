
public enum Commands {
	ADD,
	SHOW, 
	HELP,
	QUIT;

	public static void showCommands() { // Shows are of the available Commands in the game
		String validCommands = "The List of valid Commands are : ";
		for (Commands command : Commands.values()) {
			validCommands += " | " + command;
		}
		System.out.println(validCommands);
	}

	public static boolean isValidCommand(String userCommand) { // Checks if String is a valid Command
		for (Commands command : Commands.values()) {
			if (userCommand.equalsIgnoreCase(command.toString())) {
				return true;
			}
		}
		return false;
	}

	public static Commands processinputLine(String userCommand) { // Converts String into a Command
		for (Commands command : Commands.values()) {
			if (userCommand.equalsIgnoreCase(command.toString())) {
				return command;
			}
		}
		return Commands.SHOW; // **Method doesn't reach here, only gets called when isValidCommand is true
	}
}
