import javax.swing.JFrame;

public class BullEye
{
    public static void main(String[]args)
    {
    	JFrame frame = new JFrame();
    	frame.setSize(300, 400);
    	frame.setTitle("Bulleye Viewer");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	BullEyeComponent bulleye = new BullEyeComponent();
    	frame.add(bulleye);
    	frame.setVisible(true);
    }
}
