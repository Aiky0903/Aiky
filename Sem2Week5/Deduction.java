public abstract class Deduction
{ 
	private double deduction;
	private int daysOff;
	
	public Deduction() {
		deduction = 0;
		daysOff = 0;
	}
	
	abstract public void calculateDeduction();

	public double getDeduction() {
		return deduction;
	}

	public void setDeduction(double amount) {
		this.deduction = amount;
	}

	public int getDaysOff() {
		return daysOff;
	}

	public void setDaysOff(int daysOff) {
		this.daysOff = daysOff;
	}
}
