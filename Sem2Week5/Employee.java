public abstract class Employee extends Deduction {
	private String ID;
	private String name;
	private String department;
	private double salary;
	private String designation;
	
	public Employee(String iD, String name, String department, double salary) {
		ID = iD;
		this.name = name;
		this.department = department;
		this.salary = salary;										
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Override
	public void calculateDeduction() {
		double deduction = (salary / 20) * this.getDaysOff();
		this.setDeduction(deduction);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj.toString().equalsIgnoreCase(this.toString()))
			return true;
		else
			return false;
	}

	public double addBonus() {
		salary += 200;
		return salary;
	}

	public void display() {
		System.out.println("ID: " + ID + "\nName: " + name + "\nDeparment: " + department + "\nSalary : " + salary
				+ "\nDesignation: " + designation + "\n");
	}
	
	public String toString() {
		return getDesignation();
	}
}
