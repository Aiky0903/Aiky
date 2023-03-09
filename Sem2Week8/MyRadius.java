import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class MyRadius extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton button;
	private JTextField XField, YField, RadiusField;
	private JLabel XLabel, YLabel, RadiusLabel;
	int x, y;
	private double radius, diameter, circumference, area;

	public MyRadius() {
		this.setTitle("MyRadius");
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Panel Settings
		panel = new JPanel();
		panel.setLayout(null);
		// X-Coordinate Settings
		XLabel = new JLabel("X-Coordinate");
		XLabel.setBounds(10, 20, 80, 25);
		panel.add(XLabel);

		XField = new JTextField();
		XField.setBounds(100, 20, 165, 25);
		panel.add(XField);
		// Y-Coordinate Settings
		YLabel = new JLabel("Y-Coordinate");
		YLabel.setBounds(10, 50, 80, 25);
		panel.add(YLabel);

		YField = new JTextField();
		YField.setBounds(100, 50, 165, 25);
		panel.add(YField);
		// Radius Settings
		RadiusLabel = new JLabel("Radius");
		RadiusLabel.setBounds(10, 80, 80, 25);
		panel.add(RadiusLabel);

		RadiusField = new JTextField();
		RadiusField.setBounds(100, 80, 165, 25);
		panel.add(RadiusField);
		// Button Settings
		button = new JButton("Submit");
		button.setBounds(100, 120, 80, 25);
		button.addActionListener(this);
		panel.add(button);

		this.add(panel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		x = Integer.parseInt(XField.getText());
		y = Integer.parseInt(YField.getText());
		radius = Float.parseFloat(RadiusField.getText());
		diameter = radius * 2;
		circumference = 2 * Math.PI * radius;
		area = Math.PI * radius;
		this.setVisible(false);

		JFrame frame = new JFrame();
		frame.setTitle("Radius");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyRadius.CircleComponent circle = this.new CircleComponent();
		frame.add(circle);
		frame.setVisible(true);
	}

	class CircleComponent extends JComponent {
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			Ellipse2D circle = new Ellipse2D.Double(x, y, diameter, diameter);
			g2.setStroke(new BasicStroke(4));
			g2.setColor(Color.magenta);
			g2.draw(circle);
			g2.drawString("Area =" + area, 10, 100);
			g2.drawString("Diameter = " + diameter, 10, 120);
			g2.drawString("Circumference = " + circumference, 10, 140);
		}
	}

	public static void main(String[] args) {
		MyRadius radius = new MyRadius();
	}
}
