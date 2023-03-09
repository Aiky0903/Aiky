import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class MyScreen extends JFrame {
	
	public interface MyShape {
		public void draw(Graphics g);
	}

	public class ScreenSaverComponent extends JComponent {
		ArrayList<MyShape> list = new ArrayList<>();

		public void paintComponent(Graphics g) {
			for (MyShape shape : list) {
				shape.draw(g);
			}
		}

		public void update(ArrayList<MyShape> list) {
			this.list = list;
			repaint();
		}
	}

	public class RecComponent implements MyShape {
		int rx1;
		int ry1;
		int rx2;
		int ry2;
		Color c1;
		int stk;

		public RecComponent(int rx1, int ry1, int rx2, int ry2, Color c1, int stk) {
			this.rx1 = rx1;
			this.ry1 = ry1;
			this.rx2 = rx2;
			this.ry2 = ry2;
			this.c1 = c1;
			this.stk = stk;
		}

		public void draw(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			Rectangle rec = new Rectangle(rx1, rx2, ry1, ry2);
			g2.setColor(this.c1);
			g2.setStroke(new BasicStroke(this.stk));
			g2.draw(rec);
		}
	}

	public class LineComponent implements MyShape {
		int rx1;
		int ry1;
		int rx2;
		int ry2;
		Color c1;
		int stk;

		public LineComponent(int rx1, int ry1, int rx2, int ry2, Color c1, int stk) {
			this.rx1 = rx1;
			this.ry1 = ry1;
			this.rx2 = rx2;
			this.ry2 = ry2;
			this.c1 = c1;
			this.stk = stk;
		}

		public void draw(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			Random rand = new Random();
			Line2D.Double line = new Line2D.Double(rx1, rx2, ry1, ry2);
			g2.setColor(c1);
			g2.setStroke(new BasicStroke(this.stk));
			g2.draw(line);
		}
	}

	MyScreen() {
		Random r1 = new Random();
		ArrayList<MyShape> list = new ArrayList<MyShape>();
		JFrame f1 = new JFrame();
		f1.setSize(500, 500);
		ScreenSaverComponent s1 = new ScreenSaverComponent();
		class timerlistener implements ActionListener {
			Random rand = new Random();

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int rx1 = rand.nextInt(500);
				int rx2 = rand.nextInt(500);
				int ry1 = rand.nextInt(500 - rx1);
				int ry2 = rand.nextInt(500 - rx2);
				Color c1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
				int stk = rand.nextInt(10);
				int num = r1.nextInt(2);
				if (list.size() <= 100) {
					if (num == 0) {
						RecComponent r1 = new RecComponent(rx1, ry1, rx2, ry2, c1, stk);
						list.add(r1);
						s1.update(list);
					} else {
						LineComponent r1 = new LineComponent(rx1, ry1, rx2, ry2, c1, stk);
						list.add(r1);
						s1.update(list);
					}
				} else {
					list.removeAll(list);
				}
			}
		}
		f1.add(s1);
		f1.setVisible(true);
		timerlistener tt = new timerlistener();
		Timer t1 = new Timer(1000, tt);
		t1.start();
	}
	
	public static void main(String[] args) {
		new MyScreen();
	}
}
