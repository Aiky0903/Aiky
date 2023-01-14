public class Manager extends Employee {

	public Manager(String iD, String name, String department, double salary) {
		super(iD, name, department, salary);
		this.setDesignation("Manager");
	}

	public double addBonus() {
		setSalary(getSalary() + 300);
		return getSalary();
	}
}
