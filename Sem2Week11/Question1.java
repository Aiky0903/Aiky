import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Question1
{
	String sentence;
	Stack<String> wordStack = new Stack<>();
	
	public void getInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a sentence : ");
		sentence = sc.nextLine();
		sc.close();
	}
	
	public void breakSentence() {
		StringTokenizer strtoken = new StringTokenizer(sentence);
		while(strtoken.hasMoreTokens()) {
			wordStack.add(strtoken.nextToken());
		}
	}
	
	public void reverseSentence() {
		String output = "After reversed using stack : ";
		while(!wordStack.empty()) {
			output += wordStack.pop() + " ";
		}
		System.out.println(output);
	}
	
    public static void main(String[] args) 
    {
    	Question1 q1 = new Question1();
    	q1.getInput();
    	q1.breakSentence();
    	q1.reverseSentence();
    }
}
