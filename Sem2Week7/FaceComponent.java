import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class FaceComponent extends JComponent
{
    public void paintComponent(Graphics g) {
    	Graphics2D g2 = (Graphics2D) g;
    	
    	Ellipse2D head =  new Ellipse2D.Double(0, 0, 300, 300);
    	Ellipse2D righteye = new Ellipse2D.Double(75,100,20,20);
    	Ellipse2D lefteye = new Ellipse2D.Double(200,100,20,20);
    	
    	g2.drawLine(75, 200, 225,200); //Mouth
    	g2.draw(head);
    	g2.draw(righteye);
    	g2.draw(lefteye);
    }
}
