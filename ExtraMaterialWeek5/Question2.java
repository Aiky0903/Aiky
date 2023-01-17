import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Question2 {
	static String name;
	static String gender;
	static String year;
	static File currentFile;
	
	static ArrayList<String> list = new ArrayList<>();

	public static void getDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the year: ");
		year = sc.nextLine();
		System.out.println("Enter the gender: ");
		gender = sc.nextLine();
		System.out.println("Enter the name: ");
		name = sc.nextLine();
		sc.close();
	}

	public static void setYearFile() throws Exception {
		String FileName = "babynamesranking" + year + ".txt";
		currentFile = new File(FileName);
	}

	public static void setPossibleNames() throws Exception {
		Scanner reader = new Scanner(currentFile);

		if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
			System.out.println("I dont know what gender you mean.");
			reader.close();
			return;
		}

		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			StringTokenizer strtoken = new StringTokenizer(line);
			String Currentname = "";
			if (gender.equalsIgnoreCase("M")) {
				for (int i = 0; i < 2; i++) {
					Currentname = strtoken.nextToken();
				}
			}else{
				for(int i = 0; i < 4; i++) {
					Currentname = strtoken.nextToken();
				}
			}
			list.add(Currentname);
		}
		reader.close();
	}
	
	public static void analyse() {
		if(list.contains(name))
			System.out.println(name + " is ranked #" + (list.indexOf(name)+ 1) + " in year " + year);
		else 
			System.out.println("The name " + name + " is not ranked in year " + year);
	}

	public static void main(String[] args) throws Exception {
		getDetails();
		setYearFile();
		setPossibleNames();
		analyse();
	}
}