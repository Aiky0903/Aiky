import java.io.FileReader;
import java.util.Scanner;

public class Question3 {
	
	static long FacultyTotal, AssistantTotal, AssociateTotal, FullTotal;
	static int Faculty, Associate, Assistant, Full;

	public static void analyse() throws Exception{
		FileReader f1 = new FileReader("UniversitySalary.txt");
		Scanner reader = new Scanner (f1);
		
		while(reader.hasNextLine()) {
			String currentLine = reader.nextLine();
			String[] tokens = currentLine.split(" ");
			String rank = tokens[2];
			double salary = Double.parseDouble(tokens[3]);
			
			if(rank.equals("assistant")) {
				AssistantTotal += salary;
				Assistant++;
			}else if(rank.equals("associate")) {
				AssociateTotal += salary;
				Associate++;
			}else {
				FullTotal += salary;
				Full++;
			}
			FacultyTotal += salary;
			Faculty++;
		}
		reader.close();
	}
	
	public static void display() {
		System.out.println("Total salary for Assistant Professors: " + AssistantTotal);
		System.out.println("Total salary for Associate Professors: " + AssociateTotal);
		System.out.println("Total salary for Full Professors: " + FullTotal);
		System.out.println("Total salary for Faculty: " + FacultyTotal);
		System.out.println();
		System.out.println("Average salary for Assistant Professors: " + (AssistantTotal / Assistant));
		System.out.println("Average salary for Associate Professors: " + (AssociateTotal / Associate));
		System.out.println("Average salary for Full Professors: " + (FullTotal / Full));
		System.out.println("Average salary for Faculty: " + (FacultyTotal / Faculty));
	}
	
	public static void main(String[] args)throws Exception {
		analyse();
		display();
	}
}
