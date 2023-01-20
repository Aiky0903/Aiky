import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class CircleComponent extends JComponent {
	
	private static final int CIRCLE_X = 100;
	private static final int CIRCLE_Y = 100;
	private static final int CIRCLE_WIDTH = 100;
	private static final int CIRCLE_HEIGHT = 100;

	private Ellipse2D circle;
	
	public CircleComponent() {
		circle = new Ellipse2D.Double(CIRCLE_X, CIRCLE_Y, CIRCLE_WIDTH, CIRCLE_HEIGHT);
	}
	
	public void paintComponent(Graphics g) {
	      Graphics2D g2 = (Graphics2D) g;

	      g2.draw(circle);
	}
}
