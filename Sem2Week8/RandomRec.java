import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;

import javax.swing.*;

public class RandomRec extends JFrame {
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;

	public RandomRec() {
		this.setTitle("Random Rectangle Generator");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class RandomRecComponent extends JComponent {
		Random ran = new Random();

		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			for (int i = 0; i < ran.nextInt(5,20); i++) {
				int x = ran.nextInt(FRAME_WIDTH);
				int y = ran.nextInt(FRAME_HEIGHT);
				Rectangle2D rectangle = new Rectangle2D.Double(x,y,ran.nextInt(FRAME_WIDTH - x), ran.nextInt(FRAME_HEIGHT - y));
				g2.setStroke(new BasicStroke(ran.nextInt(10)));
				g2.setColor(new Color(ran.nextInt()));
				g2.draw(rectangle);
			}
		}
	}

	public static void main(String[] args) {
		RandomRec frame = new RandomRec();
		RandomRec.RandomRecComponent randomrec = frame.new RandomRecComponent();
		frame.add(randomrec);
		frame.setVisible(true);
	}
}
