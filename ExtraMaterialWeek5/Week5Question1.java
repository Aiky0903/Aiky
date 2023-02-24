import java.io.PrintWriter;
import java.util.Random;

public class Week5Question1 {
	static Random ran = new Random();

	public static String generateRank() {
		String[] ranks = { "assistant", "associate", "full" };
		int random = ran.nextInt(ranks.length);
		return ranks[random];
	}

	public static int generateSalary(String rank) {
		switch (rank) {
		case "assistant":
			return ran.nextInt(50000, 80000);
		case "associate":
			return ran.nextInt(6000, 110000);
		case "full":
			return ran.nextInt(75000, 130000);

		default:
			return 0;
		}
	}
	
	public static void print() throws Exception{
		PrintWriter out = new PrintWriter("Salary.txt");
		
		for(int i = 0; i < 10; i++) {
			String rank = generateRank();
			out.println("FirstName" + i + " LastName" + i + " " + rank + " " + generateSalary(rank));
		}
		out.close();
	}

	public static void main(String[] args)throws Exception {
		print();
	}
}
