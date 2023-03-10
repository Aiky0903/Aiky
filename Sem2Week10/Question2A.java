import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Question2A extends JFrame implements ActionListener {
	Random ran = new Random();
	JPanel labelPanel = new JPanel(), buttonPanel = new JPanel();
	JLabel label = new JLabel();
	JButton[][] buttons = new JButton[3][3];
	boolean player1Turn = true; /* Player 1 is X */

	Question2A() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);

		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 40));
		label.setText("Tic-Tac-Toe");
		label.setOpaque(true);

		labelPanel.setLayout(new BorderLayout());
		labelPanel.setBounds(0, 0, 800, 100);

		buttonPanel.setLayout(new GridLayout(3, 3));
		buttonPanel.setBackground(new Color(150, 150, 150));

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new JButton();
				buttonPanel.add(buttons[i][j]);
				buttons[i][j].setFont(new Font("", Font.BOLD, 60));
				buttons[i][j].setFocusable(false);
				buttons[i][j].addActionListener(this);
			}
		}

		labelPanel.add(label);
		add(labelPanel, BorderLayout.NORTH);
		add(buttonPanel);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				if (e.getSource() == buttons[i][j]) {
					if (buttons[i][j].getText() == "") {
						if (player1Turn) {
							buttons[i][j].setForeground(Color.red);
							buttons[i][j].setText("X");
							label.setText("O Turn");
							check();
							player1Turn = false;
						} else {
							buttons[i][j].setForeground(Color.blue);
							buttons[i][j].setText("O");
							label.setText("X turn");
							check();
							player1Turn = true;
						}
					}
				}
			}
		}
	}

	public void check() {
		/* Check Rows and Columns */
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				if (!buttons[i][j].getText().equals("")) {
					/* Check Rows */
					if (
						buttons[i][0].getText().equals(buttons[i][1].getText()) &&
						buttons[i][0].getText().equals(buttons[i][2].getText()) &&
						buttons[i][1].getText().equals(buttons[i][2].getText())
						) 
						win(buttons[i][0], buttons[i][1], buttons[i][2]);
					
					/* Check Columns */
					if (
						buttons[0][j].getText().equals(buttons[1][j].getText()) &&
						buttons[0][j].getText().equals(buttons[2][j].getText()) &&
						buttons[1][j].getText().equals(buttons[2][j].getText())
						)
						win(buttons[0][j], buttons[1][j], buttons[2][j]);
					
					/* Check Diagonal */
					if(i == 1 && j == 1) { /* When is the middle Button */
						/* Check Top left and Bottom Right */
						if(buttons[i][j].getText().equals(buttons[i - 1][j - 1].getText()) && buttons[i][j].getText().equals(buttons[i + 1][j + 1].getText())) 
							win(buttons[i][j], buttons[i - 1][j - 1], buttons[i + 1][j + 1]);
						/* Check Top right and Bottom Left */
						if(buttons[i][j].getText().equals(buttons[i - 1][j + 1].getText()) && buttons[i][j].getText().equals(buttons[i + 1][j - 1].getText()))
							win(buttons[i][j], buttons[i - 1][j + 1], buttons[i + 1][j - 1]);
					}
				}
			}
		}
	}

	public void win(JButton button1, JButton button2, JButton button3) {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j].setEnabled(false);
			}
		}
		
		button1.setBackground(Color.green);
		button2.setBackground(Color.green);
		button3.setBackground(Color.green);
		
		if(player1Turn)
			label.setText("X Wins");
		else 
			label.setText("O Wins");
		
	}

	public static void main(String[] args) {
		new Question2A();
	}

}
