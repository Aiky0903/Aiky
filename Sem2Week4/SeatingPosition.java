
public enum SeatingPosition {
	NULL, //For when unknown variable is entered
	AISLE,
	CENTER,
	WINDOW;
	
	
	public static boolean isValidPosition(String input) { // To Check is String passed in actually a valid position
		for(SeatingPosition position : SeatingPosition.values()) {
			if(input.equalsIgnoreCase(position.name())) {
				return true;
			}
		}
		return false;
	}
	
	public static SeatingPosition processSeatingPosition(String input) { // Converts String into a SeatingPosition
		for(SeatingPosition position : SeatingPosition.values()) {
			if(input.equalsIgnoreCase(position.name())) {
				return position;
			}
		}
		return SeatingPosition.NULL;
	}
}
