
public class Seat {
	private SeatingPosition position;
	private boolean taken;
	
	public Seat(SeatingPosition position) {
		this.position = position;
		taken = false;
	}

	public SeatingPosition getPosition() {
		return position;
	}

	public void setPosition(SeatingPosition position) {
		this.position = position;
	}

	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

}
