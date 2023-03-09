import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class RandomLine extends JFrame
{
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	
	public RandomLine() 
	{
		this.setTitle("Random Line Generator");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class RandomLineComponent extends JComponent
	{
		Random ran = new Random();
		
		public void paintComponent(Graphics g) 
		{
			Graphics2D g2 = (Graphics2D) g;
			
			for(int i = 0; i < ran.nextInt(5,20); i++) {
				int x = ran.nextInt(FRAME_WIDTH);
				int y = ran.nextInt(FRAME_HEIGHT);
				Line2D line = new Line2D.Double(x,y,ran.nextInt(),ran.nextInt());
				g2.setStroke(new BasicStroke(ran.nextInt(10)));
				g2.setColor(new Color(ran.nextInt()));
				g2.draw(line);
			}
		}
	}
	
    public static void main(String[]args) 
    {
    	RandomLine RandomLineFrame = new RandomLine();
    	RandomLine.RandomLineComponent component = RandomLineFrame.new RandomLineComponent();
    	RandomLineFrame.add(component);
    	RandomLineFrame.setVisible(true);
    }
}