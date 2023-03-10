import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class Question1 extends JFrame {
	
	CircleResizerComponent resizer;
	
	public class CircleResizerComponent extends JPanel implements ActionListener{
		JButton enlargeButton, shrinkButton;
		Ellipse2D circle;
		double x = 135, y = 60, size = 30;
		
		CircleResizerComponent(){
		setPreferredSize(new Dimension(300,200));
		setLayout(null);
		
		enlargeButton = new JButton("Enlarge");
		enlargeButton.setFocusable(false);
		enlargeButton.setBounds(50, 150, 100, 30);
		add(enlargeButton);
		enlargeButton.addActionListener(this);
		
		shrinkButton = new JButton("Shrink");
		shrinkButton.setFocusable(false);
		shrinkButton.setBounds(155, 150, 100, 30);
		add(shrinkButton);
		shrinkButton.addActionListener(this);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics2D g2 = (Graphics2D) g;
			
			circle = new Ellipse2D.Double(x, y, size, size);
			g2.draw(circle);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == enlargeButton) {
				x -= 10;
				y -= 10;
				size += 10;
				size += 10;
			}
			
			if(e.getSource() == shrinkButton) {
				x += 10;
				y += 10;
				size -= 10;
				size -= 10;
			}
			repaint();
		}
	}
	
	Question1() {
		resizer = new CircleResizerComponent();
		add(resizer);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Question1();
	}
}
