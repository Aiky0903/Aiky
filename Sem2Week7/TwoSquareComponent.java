import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class TwoSquareComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      Rectangle box = new Rectangle(0, 0, 100, 100);
      Color pink = new Color(255, 175, 175);
      g2.setColor(pink);
      g2.fill(box);
      g2.draw(box);
      
      Rectangle box2 = new Rectangle(0,100,100,100);
      Color magenta = new Color(255,0,255);
      g2.setColor(magenta);
      g2.fill(box2);
      g2.draw(box2);
   }
}
