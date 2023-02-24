import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.*;

public class Question2 extends JComponent {
	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 700;
	private static final int XAxis = 75;
	private static final int YAxis = 600;
	
	String[] month = { "January", "February", "March", "April", "May" };
	double[] amount = { 230.7, 220.8, 110.6, 380.6, 209.8 };

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		Line2D Xaxis = new Line2D.Double(XAxis, 50, XAxis, YAxis);
		Line2D Yaxis = new Line2D.Double(XAxis, YAxis, 625, YAxis);
		
		int X = 150;
		for(int i = 0; i < month.length; i++) {
			Rectangle2D rectangle = new Rectangle2D.Double(X, YAxis - amount[i], 50, amount[i]);
			g2.drawString(month[i], X, 620);	
			g2.draw(rectangle);
			X += 80;
		}

		g2.draw(Yaxis);
		g2.draw(Xaxis);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Bar Chart");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		Question2 question2 = new Question2();

		frame.add(question2);
		frame.setVisible(true);
	}
}