import java.awt.*;

import javax.swing.*;

public class Question1 extends JFrame {
	JPanel rightpanel;
	JLabel myPrinterlabel, printQuality;
	JCheckBox image, text, code, printTofile;
	JButton okbutton, cancelbutton, setupbutton, helpbutton;
	JRadioButton selection, All, Applet;
	JComboBox combobox;

	public Question1() {
		this.setTitle("Printer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 200);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.lightGray);

		myPrinterlabel = new JLabel("Printer: MyPrinter");
		myPrinterlabel.setBounds(30, 0, 100, 40);
		myPrinterlabel.setForeground(Color.blue);

		printQuality = new JLabel("Print Quality:");
		printQuality.setBounds(40, 110, 100, 40);
		printQuality.setForeground(Color.blue);

		String[] quality = { "High", "Medium", "Low" };
		combobox = new JComboBox(quality);
		combobox.setBackground(Color.lightGray);
		combobox.setBounds(130, 120, 60, 20);

		printTofile = new JCheckBox("Print to file");
		printTofile.setBounds(200, 115, 100, 30);
		printTofile.setBackground(Color.lightGray);
		
		image = new JCheckBox("Image");
		image.setBounds(70, 30, 75, 30);
		image.setBackground(Color.lightGray);

		text = new JCheckBox("Text");
		text.setBounds(70, 60, 75, 30);
		text.setBackground(Color.lightGray);

		code = new JCheckBox("Code");
		code.setBounds(70, 90, 75, 30);
		code.setBackground(Color.lightGray);

		selection = new JRadioButton("Selection");
		selection.setBounds(170, 30, 90, 30);
		selection.setBackground(Color.lightGray);

		All = new JRadioButton("All");
		All.setBounds(170, 60, 90, 30);
		All.setBackground(Color.lightGray);

		Applet = new JRadioButton("Applet");
		Applet.setBounds(170, 90, 90, 30);
		Applet.setBackground(Color.lightGray);

		rightpanel = new JPanel();
		rightpanel.setLayout(new GridLayout(4, 1, 0, 5));
		rightpanel.setBackground(Color.lightGray);
		rightpanel.setBounds(320, 0, 100, 160);

		okbutton = new JButton("Ok");
		cancelbutton = new JButton("Cancel");
		setupbutton = new JButton("Setup...");
		helpbutton = new JButton("Help");

		JButton[] rightbuttons = { okbutton, cancelbutton, setupbutton, helpbutton };
		for (JButton button : rightbuttons) {
			button.setBackground(Color.lightGray);
			button.setBorder(BorderFactory.createEtchedBorder());
			rightpanel.add(button);
		}

		this.add(printTofile);
		this.add(combobox);
		this.add(printQuality);
		this.add(All);
		this.add(Applet);
		this.add(selection);
		this.add(image);
		this.add(text);
		this.add(code);
		this.add(myPrinterlabel);
		this.add(rightpanel);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Week5Question1();
	}
}
