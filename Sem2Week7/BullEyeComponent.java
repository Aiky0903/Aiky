import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class BullEyeComponent extends JComponent
{
    public void paintComponent(Graphics g) 
    {
    	Graphics2D g2 = (Graphics2D) g;
    	
    	Color black = new Color(0,0,0);
    	Color white = new Color(255,255,255);
    	
    	for(int i = 200; i > 0; i = i - 25) {
    		int center = 100 - i/2;
        	Ellipse2D circle = new Ellipse2D.Double(center,center,i,i);
        	if(i % 2 == 0) {
        		g2.setColor(black);
        	}else {
        		g2.setColor(white);
        	}
        	g2.fill(circle);
        	g2.draw(circle);
    	}
    }
}
