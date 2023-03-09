import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.*;

public class CicleDrawer extends JFrame{
	private boolean pressed;

	private double x1, y1, x2, y2, radius, diameter;

	public CicleDrawer() {
		this.setTitle("Circle Drawer");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (pressed == false) {
					x1 = e.getX();
					y1 = e.getY();
					pressed = true;
				} else {
					x2 = e.getX();
					y2 = e.getY();
					radius = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow(y2 - y1, 2));
					diameter = radius * 2;
				}
			}
		});
		
		CicleDrawer.Circle circle = this.new Circle();
		this.add(circle);
		this.setVisible(true);

		this.setVisible(true);
	}

	class Circle extends JComponent {
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			Line2D line = new Line2D.Double(x1, y1, x2, y2);
			Ellipse2D circle = new Ellipse2D.Double(x1 - radius, y1 - radius, diameter, diameter);
			g2.drawString("x1:" + x1 + " y1:" + y1 + " x2:" + x2 + " y2:" + y2, (int) x1, (int) y1);
			g2.draw(line);
			g2.draw(circle);
		}
	}

	public static void main(String[] args) {
		CicleDrawer drawer = new CicleDrawer();
	}
}
