import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadFile {
	
	public static String getfileName() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your file directory: ");
		String fileName = input.nextLine() + ".txt";
		input.close();
		return fileName;
	}

	public static void main(String[] args) throws Exception {
		String fileName = getfileName();

		File myFile = new File(fileName);
		Scanner reader = new Scanner(myFile);

		int charAmount = 0;
		int wordAmount = 0;
		int lineAmount = 0;
		while (reader.hasNextLine()) {
			String currentLine = reader.nextLine();
			lineAmount++;
			StringTokenizer strtoken1 = new StringTokenizer(currentLine);
			while (strtoken1.hasMoreTokens()) {
				String word = strtoken1.nextToken();
				wordAmount++;
				for (int i = 0; i < word.length(); i++) {
					charAmount++;
				}
			}
		}
		reader.close();
		System.out.println("Amount of Char : " + charAmount + "\nAmount of Words : " + wordAmount
				+ "\nAmount of Lines : " + lineAmount);
	}
}
