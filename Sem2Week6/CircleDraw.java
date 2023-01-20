import javax.swing.JFrame;

public class CircleDraw {
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Shape drawing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final CircleComponent c1 = new CircleComponent();
		frame.add(c1);
		frame.setVisible(true);
	}
}
