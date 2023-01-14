public class Clerk extends Employee
{

	public Clerk(String iD, String name, String department, double salary) {
		super(iD, name, department, salary);
		setDesignation("Clerk");
	}
    
	public double addBonus() {
		setSalary(getSalary() + 100);
		return getSalary();
	}
}
