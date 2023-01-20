import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/** 	 	 	 	 	 	
   This program moves the rectangle.
*/
public class RectangleDraw
{
   private static final int FRAME_WIDTH = 500;
   private static final int FRAME_HEIGHT = 500;

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Shape drawing");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      final RectangleComponent component = new RectangleComponent();
      final CircleComponent c1 = new CircleComponent();
      frame.add(component);
      frame.setVisible(true);
      frame.add(c1);
      frame.setVisible(true);
   }
}
