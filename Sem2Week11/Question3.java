import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Student{
	private String name;
	private int result;
	
	public Student(String name, int result) {
		this.result = result;
		this.name = name;
	}

	public int getResult() {
		return result;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return getName() + "		" + getResult();
	}
}

public class Question3 {
	File file = new File("StudentResult.txt");
	ArrayList<Student> studentlist = new ArrayList<>();

	public void selectionSort() {
		int lowestIndex;
		for(int i = 0; i < studentlist.size() - 1; i++) {
			Student lowestStudent = studentlist.get(i);
			lowestIndex = i;
			for(int j = i + 1; j < studentlist.size(); j++) {
				Student otherStudent = studentlist.get(j);
				if(lowestStudent.getResult() > otherStudent.getResult()) {
					lowestStudent = otherStudent;
					lowestIndex = j;
				}
			}
			
			Student temp = studentlist.get(i);
			studentlist.set(i, lowestStudent);
			studentlist.set(lowestIndex, temp);
		}
		for (Student student : studentlist) {
			System.out.println(student);
		}
	}

	public void extractData() throws Exception {
		Scanner scan = new Scanner(file);
		while (scan.hasNext()) {
			StringTokenizer strtoken = new StringTokenizer(scan.nextLine());
			studentlist.add(new Student(strtoken.nextToken(), Integer.parseInt(strtoken.nextToken())));
		}
		scan.close();
	}

	public static void main(String[] args) throws Exception {
		Question3 q2 = new Question3();
		q2.extractData();
		q2.selectionSort();
	}
}