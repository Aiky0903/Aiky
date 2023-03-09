import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TempConvert extends JFrame implements ActionListener {
	private JPanel panel;
	private JTextField field;
	private JLabel label1, label2;
	private JButton button;
	private double celcius;

	public TempConvert() {
		this.setTitle("Temp Convert");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		// Panel Settings
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		// Celcius Label Settings
		label1 = new JLabel("Please enter reading in Celcius:");
		panel.add(label1);
		// TextField Settings
		field = new JTextField();
		field.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(field);
		// Fahrenheit Label Settings
		label2 = new JLabel();
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label2);
		// Button Settings
		button = new JButton("Convert");
		button.addActionListener(this);
		panel.add(button);

		this.add(panel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		celcius = Double.parseDouble(field.getText());
		double fahrenheit = (celcius * 9 / 5) + 32;
		label2.setText(fahrenheit + " Fahrenheit");
	}

	public static void main(String[] args) {
		TempConvert tempconvert = new TempConvert();
	}
}