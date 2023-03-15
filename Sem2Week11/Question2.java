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

public class Question2
{
	File file = new File("StudentResult.txt");
	ArrayList<Student> studentlist = new ArrayList<>();
	
	public void bubbleSort() {
		boolean swapped;
		do {
			swapped = false;
			for(int i = 0; i < studentlist.size() - 1; i++){
				if(studentlist.get(i).getResult() > studentlist.get(i + 1).getResult()){
					swapped = true;
					Student tempStudent = studentlist.get(i);
					studentlist.set(i, studentlist.get(i + 1));
					studentlist.set(i + 1, tempStudent);
				}
			}
		}while(swapped == true);
		
		for(Student student : studentlist) {
			System.out.println(student);
		}
	}
	
	public void extractData() throws Exception{
		Scanner scan = new Scanner(file);
    	while(scan.hasNext()) {
    		StringTokenizer strtoken = new StringTokenizer(scan.nextLine());
    		studentlist.add(new Student(strtoken.nextToken(), Integer.parseInt(strtoken.nextToken())));
    	}
	}
	
    public static void main(String[] args) throws Exception
    {
    	Question2 q2 = new Question2();
    	q2.extractData();
    	q2.bubbleSort();
    }
}