
public class Tester {
	public static void main(String[] args) {
		//Part 1
		Manager bob = new Manager("123456", "Bob", "Finance", 5000);
		Clerk christopher = new Clerk("654321", "Christopher", "Mass Communication", 3000);
		bob.display();
		christopher.display();
		System.out.println(christopher.addBonus());
		System.out.println(bob.addBonus());
		System.out.println(christopher.equals(christopher));
		System.out.println(christopher.equals(bob));
		
		//Part 2
		Manager harry = new Manager("321321321", "Harry", "IT", 6000);
		Clerk jessica = new Clerk("564654645", "Jessica", "Design", 3000);
		Clerk angela = new Clerk("234948239", "Angela", "Math", 2000);
		
		//Set Amount of Days Off for each Employee
		harry.setDaysOff(3); 
		jessica.setDaysOff(10);
		angela.setDaysOff(1);
		
		//Array of type Deduction
		Deduction[] lazyWorkers = {harry, jessica, angela};
		
		//Count Total
		double total = 0;
		for(int i = 0; i < lazyWorkers.length; i++) {
			lazyWorkers[i].calculateDeduction();
			//System.out.println(lazyWorkers[i].getDeduction()); > Prints out deduction for each employee for checking purposes
			total += lazyWorkers[i].getDeduction();
		}
		System.out.println("Total Deduction : " + total);
	}
}
