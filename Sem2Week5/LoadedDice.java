import java.util.Random;

public class LoadedDice extends Random
{
    LoadedDice(){
    	new Random();
    }
    
    @Override
    public int nextInt(int num) {
    	int number;
    	int random = super.nextInt(2);
    	
    	if(random == 0) {
    		number = num - 1;
    		return number;
    	}else {
    		number = super.nextInt(num);
    		return number;
    	}
    }
}
