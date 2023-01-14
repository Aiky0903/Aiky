import java.util.Random;

public class Tester3 
{
	public static void printDiceRolls(Random randGenerator) 
	{
		for(int i = 0; i < 100; i ++) {
			System.out.println(randGenerator.nextInt(6) + 1);
		}
	}
	
	public static void main(String[] agrs) 
	{
		LoadedDice myDice = new LoadedDice();
		printDiceRolls(myDice);
	}
}
