import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Question4 extends JFrame implements ActionListener {
	JLabel label;
	JTextField field;
	JButton submitButton, doneButton;
	ArrayList<Float> numberList;
	boolean chance;

	Question4() {
		this.setSize(new Dimension(550, 130));
		this.setResizable(false);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.setLocationRelativeTo(null);
		numberList = new ArrayList<>();

		label = new JLabel("Enter a set of floating-point values");
		this.add(label);

		field = new JTextField();
		field.setPreferredSize(new Dimension(200, 30));
		this.add(field);

		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		this.add(submitButton);

		doneButton = new JButton("Done");
		doneButton.setPreferredSize(new Dimension(400, 30));
		doneButton.addActionListener(this);
		this.add(doneButton);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submitButton) {
			try {
				float value = Float.parseFloat(field.getText());
				numberList.add(value);
			} catch (NumberFormatException ex) {
				if (chance) {
					doneButton.doClick();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Input. Please Enter a Number", "ERROR", JOptionPane.ERROR_MESSAGE);
					chance = true;
				}
			}
			field.setText("");
		}

		if (e.getSource() == doneButton) {
			float sum = 0;
			for (float number : numberList) {
				sum += number;
			}
			dispose();
			JOptionPane.showMessageDialog(null, "The sum of the data entered is " + sum, "Total", JOptionPane.PLAIN_MESSAGE);
		}
	}

	public static void main(String[] args) {
		new Question4();
	}
}
