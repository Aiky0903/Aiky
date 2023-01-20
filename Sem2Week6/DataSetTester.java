/**
 * This program tests the DataSet class.
 */
public class DataSetTester {
	public static void main(String[] args) {
		DataSet bankData = new DataSet();

		bankData.add(new BankAccount(0));
		bankData.add(new BankAccount(1000));
		bankData.add(new BankAccount(5000));

		System.out.println("Average balance: " + bankData.getAverage());
		System.out.println("Expected: 2000");
		Measurable max = bankData.getMaximum();
		System.out.println("Highest balance: " + max.getMeasure());
		System.out.println("Expected: 5000");

		DataSet coinData = new DataSet();

		coinData.add(new Coin(0.25, "quarter"));
		coinData.add(new Coin(0.1, "dime"));
		coinData.add(new Coin(0.05, "nickel"));

		System.out.println("Average coin value: " + coinData.getAverage());
		System.out.println("Expected: 0.133");
		max = coinData.getMaximum();
		System.out.println("Highest coin value: " + max.getMeasure());
		System.out.println("Expected: 0.25");
		
		//Question 2
		DataSet quizData = new DataSet();
		quizData.add(new Quiz(90, "A+"));
		quizData.add(new Quiz(65, "B+"));
		quizData.add(new Quiz(55, "C+"));

		System.out.println("Average score: " + quizData.getAverage());
		System.out.println("Expected: " + ((90 + 65 + 55) / 3));
		Measurable min = quizData.getMinimum();
		max = quizData.getMaximum();
		System.out.println("Highest score: " + max.getMeasure() + " " + max.toString());
		System.out.println("Expected: 90 A+");
		System.out.println("Lowest score: " + min.getMeasure() + " " + min.toString());
		System.out.println("Expected: 55 C+");

		//Question 3
		DataSet personData = new DataSet();
		
		personData.add(new Person(170, "Harry"));
		personData.add(new Person(160, "Jessica"));
		personData.add(new Person(150, "Christopher"));
		
		System.out.println("Average height: " + personData.getAverage());
		System.out.println("Expected: " + ((170 + 160 + 150) / 3));
		max = personData.getMaximum();
		min = personData.getMinimum();
		System.out.println("Highest height: " + max.getMeasure() + " " + max.toString());
		System.out.println("Expected: 170 Harry");
		System.out.println("Lowest height: " + min.getMeasure() + " " + min.toString());
		System.out.println("Expected: 150 Christopher");
	}
}
