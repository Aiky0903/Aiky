
public class Class {
	private String name;
	private Seat[][] Seats; // A Class is a 2D Array(Table) of Seats

	public Class(String name, int row, int column) { //Initializes the Class with given name, row and column
		this.name = name;
		Seats = new Seat[row][column];
		initializeSeats(Seats); // Fills in the 2D Array with Seat Objects
	}

	public void showSeats() {
		int counter = 0; //Counter for Seat Numbering
		for (int i = 0; i < Seats.length; i++) { //For each Row
			for (int j = 0; j < Seats[i].length; j++) { //For each Column
				if (Seats[i][j].isTaken() == true) { //If Seat is taken print out XXXX
					System.out.printf("%9S", "xxxx");
				} else { //Else print out the Seat number and the position
					System.out.printf("%7d %.1s", counter, Seats[i][j].getPosition());
				}
				counter++; //Increment the counter
			}
			System.out.println();
		}
	}

	public void initializeSeats(Seat[][] Seats) {
		for (int i = 0; i < Seats.length; i++) { // For each row

			final int LeftWindow = 0; // First index is most left seat i.e Window Seat
			final int RightWindow = Seats[i].length - 1; // Last index is most right seat

			final int RightAisle = Seats[i].length / 2; // Middle Seat is next to aisle 
			final int LeftAisle = RightAisle - 1; // Seat to the left of the Middle Seat is also next to the aisle

			for (int j = 0; j < Seats[i].length; j++) {
				if (j == LeftWindow || j == RightWindow) { // Assign Position according to index number
					Seats[i][j] = new Seat(SeatingPosition.WINDOW);
				}

				else if (j == RightAisle || j == LeftAisle) {
					Seats[i][j] = new Seat(SeatingPosition.AISLE);
				}

				else { //If is neither Window or Aisle seat then has to be a center seat
					Seats[i][j] = new Seat(SeatingPosition.CENTER);
				}
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Seat[][] getSeats() {
		return Seats;
	}

	public void setSeats(Seat[][] seats) {
		Seats = seats;
	}

}