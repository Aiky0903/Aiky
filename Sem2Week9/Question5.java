import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Question5 extends JFrame implements ActionListener{
	
	private static final Font FONT = new Font("Times New Roman", Font.BOLD, 20);
	private static final FlowLayout LAYOUT = new FlowLayout(FlowLayout.LEADING, 10, 10);
	private static final Dimension PREFERRED_SIZE = new Dimension(450, 30);
	
	JPanel titlePanel, IDPanel, accNumPanel, balancePanel, bottomPanel;
	JLabel titleLabel, IDLabel, accNumLabel, balanceLabel;
	JTextField IDField, accNumField, balanceField;
	JButton submitButton;
	String ID, accNum, balance;

	Question5() {
		this.setSize(new Dimension(500, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(5, 1));
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		titlePanel = new JPanel();
		titleLabel = new JLabel("Bank Account");
		titleLabel.setFont(FONT);

		titlePanel.add(titleLabel);

		IDPanel = new JPanel(LAYOUT);
		IDLabel = new JLabel("Customer ID");
		IDField = new JTextField();
		IDField.setPreferredSize(PREFERRED_SIZE);

		IDPanel.add(IDLabel);
		IDPanel.add(IDField);

		accNumPanel = new JPanel(LAYOUT);
		accNumLabel = new JLabel("Account Number");
		accNumField = new JTextField();
		accNumField.setPreferredSize(PREFERRED_SIZE);

		accNumPanel.add(accNumLabel);
		accNumPanel.add(accNumField);

		balancePanel = new JPanel(LAYOUT);
		balanceLabel = new JLabel("Initial Balance");
		balanceField = new JTextField();
		balanceField.setPreferredSize(PREFERRED_SIZE);

		balancePanel.add(balanceLabel);
		balancePanel.add(balanceField);

		bottomPanel = new JPanel();
		submitButton = new JButton("Submit");
		submitButton.setPreferredSize(new Dimension(200, 30));
		submitButton.addActionListener(this);
		bottomPanel.add(submitButton);

		this.add(titlePanel);
		this.add(IDPanel);
		this.add(accNumPanel);
		this.add(balancePanel);
		this.add(bottomPanel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			ID = IDField.getText();
			accNum = accNumField.getText(); 
			balance = balanceField.getText();
			checkID(ID);
			checkAccNum(accNum);
			checkBalance(balance);
			dispose(); // Close window
			new Question6(); // If data entered is correct, start Question6
		} catch (Exception ex) { // Loops until user enters correct data
			IDField.setText("");
			accNumField.setText("");
			balanceField.setText("");
		}
	}
	
	class IDException extends Exception {
		public IDException() {
			JOptionPane.showMessageDialog(null, "Customer ID must start with a letter and should be followed by three digits.", "BANK ID ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}

	class accNumException extends Exception {
		public accNumException() {
			JOptionPane.showMessageDialog(null, "Account number must be of five digits.", "ACCOUNT NUMBER ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}

	class balanceException extends Exception {
		public balanceException() {
			JOptionPane.showMessageDialog(null, "Initial balance must be above $1000.", "BALANCE ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}

	private void checkBalance(String balance) throws Question5.balanceException {
		try {
			double amount = Double.parseDouble(balance);
			if (amount < 1000) {
				throw new balanceException();
			}
		} catch (NumberFormatException ex) {
			throw new balanceException();
		}
	}

	private void checkAccNum(String accNum) throws Question5.accNumException {
		if (accNum.length() != 5) {
			throw new accNumException();
		}

		for (int i = 0; i < accNum.length(); i++) {
			if (!Character.isDigit(accNum.charAt(i))) {
				throw new accNumException();
			}
		}
	}

	private void checkID(String ID) throws Question5.IDException {
		if (ID.length() != 4 || !Character.isLetter(ID.charAt(0))) {
			throw new IDException();
		}

		for (int i = 1; i < 4; i++) {
			if (!Character.isDigit(ID.charAt(i))) {
				throw new IDException();
			}
		}
	}
	
	public class Question6 extends JFrame implements ActionListener{
		JPanel depositPanel, withdrawPanel, bottomPanel;
		JLabel depositLabel, withdrawLabel;
		JButton submitButton;
		JTextField depositField, withdrawField;
		String withdrawAmount, depositAmount;
		double currentBalance = Double.parseDouble(balance); //Already checked for exception in Question5
		
		public Question6() {
			this.setSize(new Dimension(500, 400));
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(new GridLayout(4, 1));
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			
			depositPanel = new JPanel(LAYOUT);
			depositLabel = new JLabel("Deposit Amount");
			depositField = new JTextField();
			depositField.setPreferredSize(PREFERRED_SIZE);
			
			depositPanel.add(depositLabel);
			depositPanel.add(depositField);
			
			withdrawPanel = new JPanel(LAYOUT);
			withdrawLabel = new JLabel("Withdraw Amount");
			withdrawField = new JTextField();
			withdrawField.setPreferredSize(PREFERRED_SIZE);
			
			withdrawPanel.add(withdrawLabel);
			withdrawPanel.add(withdrawField);
			
			bottomPanel = new JPanel();
			submitButton = new JButton("Submit");
			submitButton.setPreferredSize(new Dimension(200, 30));
			submitButton.addActionListener(this);
			bottomPanel.add(submitButton);
			
			this.add(titlePanel);
			this.add(depositPanel);
			this.add(withdrawPanel);
			this.add(bottomPanel);
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				withdrawAmount = withdrawField.getText();
				depositAmount = depositField.getText();
				checkDeposit(depositAmount);
				checkWithdraw(withdrawAmount);
				dispose();
				
				JFrame details = new JFrame();
				details.setSize(new Dimension(300, 300));
				details.setLayout(new FlowLayout());
				details.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				details.setLocationRelativeTo(null);
				details.setResizable(false);
				
				JPanel detailsPanel = new JPanel();
				detailsPanel.setLayout(new GridLayout(6,1));
				
				JLabel IDdetails = new JLabel("Customer ID: " + ID);
				IDdetails.setFont(FONT);
				JLabel accNumdetails = new JLabel("Accout Number: " + accNum);
				accNumdetails.setFont(FONT);
				JLabel balancedetails = new JLabel("Initial Balance: " + balance);
				balancedetails.setFont(FONT);
				JLabel depositdetails = new JLabel("Deposit Amount: " + depositAmount);
				depositdetails.setFont(FONT);
				JLabel withdrawdetails = new JLabel("Withdraw Amount: " + withdrawAmount);
				withdrawdetails.setFont(FONT);
				JLabel finalbalancedetails = new JLabel("Final balance: " + currentBalance);
				finalbalancedetails.setFont(FONT);
				
				detailsPanel.add(IDdetails);
				detailsPanel.add(accNumdetails);
				detailsPanel.add(balancedetails);
				detailsPanel.add(depositdetails);
				detailsPanel.add(withdrawdetails);
				detailsPanel.add(finalbalancedetails);
				
				details.add(titlePanel);
				details.add(detailsPanel);
				details.setVisible(true);
			}catch(Exception ex) {
				withdrawField.setText("");
				depositField.setText("");
			}
		}
		
		public class depositException extends Exception{
			public depositException() {
				JOptionPane.showMessageDialog(null, "The maximum balance in the account must not be more than $5000.", "DEPOSIT ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		public class withdrawException extends Exception{
			public withdrawException() {
				JOptionPane.showMessageDialog(null, "The available balance after the withdrawal does not go below $1000.", "WITHDRAW ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		private void checkDeposit(String amount) throws Question5.Question6.depositException {
			try {
				double temp = Double.parseDouble(amount);
				if(currentBalance + temp > 5000) {
					throw new depositException();
				}
				currentBalance += temp;
			}
			catch (NumberFormatException ex) {
				throw new depositException();
			}
			
		}
		
		private void checkWithdraw(String amount) throws Question5.Question6.withdrawException{
			try {
				double temp = Double.parseDouble(amount);
				if(currentBalance - temp < 1000) {
					throw new withdrawException();
				}
				currentBalance -= temp;
			} catch (NumberFormatException ex) {
				throw new withdrawException();
			}
		}
	}
	
	public static void main(String[] args) {
		new Question5();
	}
}