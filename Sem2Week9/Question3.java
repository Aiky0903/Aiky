import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Question3 extends JFrame implements ActionListener{
	JLabel userLabel, fontLabel, sizeLabel;
	JButton previewButton;
	JTextField stringField, sizeField, outputField;
	JComboBox fontbox;
	JRadioButton boldButton, italicsButton;
	String[] fonts = {"SansSerif", "Arial", "Serif"};
	
	Font font;
	int style, size;

	public Question3() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,10,8));
		this.setSize(new Dimension(250,300));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		userLabel = new JLabel("Enter your String here");
		this.add(userLabel);
		
		stringField = new JTextField();
		stringField.setPreferredSize(new Dimension(170,30));
		this.add(stringField); 
		
		fontLabel = new JLabel("Choose your Font: ");
		this.add(fontLabel);
		
		fontbox = new JComboBox(fonts);
		this.add(fontbox);
		
		sizeLabel = new JLabel("Enter your preffered size: ");
		this.add(sizeLabel);
		
		sizeField = new JTextField();
		sizeField.setPreferredSize(new Dimension(30,30));
		this.add(sizeField);
		
		boldButton = new JRadioButton("BOLD");
		boldButton.setFocusable(false);
		boldButton.setFont(new Font("", Font.BOLD, 15));
		
		italicsButton = new JRadioButton("ITALICS");
		italicsButton.setFocusable(false);
		italicsButton.setFont(new Font("", Font.ITALIC, 15));
		
		ButtonGroup group = new ButtonGroup();
		group.add(boldButton);
		group.add(italicsButton);
		
		this.add(boldButton);
		this.add(italicsButton);
		
		outputField = new JTextField();
		outputField.setPreferredSize(new Dimension(170,30));
		this.add(outputField);
		
		previewButton = new JButton("Preview");
		previewButton.setPreferredSize(new Dimension(200,30));
		this.add(previewButton);
		previewButton.addActionListener(this);
		
		this.setVisible(true);
	} 

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == previewButton) {
			size = Integer.parseInt(sizeField.getText());
			if(boldButton.isSelected()) {
				style = Font.BOLD;
			}else if(italicsButton.isSelected()) {
				style = Font.ITALIC;
			}
			font = new Font("" + fontbox.getSelectedItem(), style, size);
			outputField.setFont(font);
			outputField.setText(stringField.getText());
		}
	}
	
	public static void main(String[] args) {
		new Week5Question3();
	}
}