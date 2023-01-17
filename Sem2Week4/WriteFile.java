import java.io.PrintWriter;
import java.util.Scanner;

public class WriteFile
{
    public static String getInput() {
    	Scanner sc = new Scanner(System.in);
    	String input = sc.nextLine() + ".txt";
    	sc.close();
    	return input;
    }

    public static void main(String []args) throws Exception
    {
    	String fileName = getInput();
    	
    	PrintWriter w1 = new PrintWriter(fileName);
    	
    	w1.println("Hello, My first program in File");
    	
    	w1.close();
    }
    
    
}
