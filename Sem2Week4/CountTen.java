import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CountTen {
	public static void main(String[] args) throws Exception {
		File myFile = new File("C:\\Users\\Aiky\\Downloads\\CountTen.txt");
		Scanner reader = new Scanner(myFile);
		int occurance = 0;
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			StringTokenizer strtoken1 = new StringTokenizer(line);
			
			while (strtoken1.hasMoreTokens()) {
				if (Integer.parseInt(strtoken1.nextToken()) == 10)
					occurance++;
			}
		}
		System.out.println(occurance);
		reader.close();
	}
}
