import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class Question2B extends JFrame implements ActionListener {
	private static final int IMAGE_WIDTH = 210;
	private static final int IMAGE_HEIGHT = 100;
	
	ImageIcon countryFlag;
	JComboBox countryBox;
	JScrollPane scroll;
	JLabel flagLabel, countryBoxLabel;
	JTextArea countryField;
	JPanel topPanel, centerPanel;
	String[] countries = { "Malaysia", "Singapore", "Thailand", "Philippines" };
	HashMap<String, String> countryDescription = new HashMap<>();

	Question2B() {
		setSize(new Dimension(450, 200));
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		/* HashMap (Country, Description)*/
		countryDescription.put("Philippines",
				"The national flag of the Philippines is a horizontal bicolor flag with equal bands of royal blue and crimson red, with a white, equilateral triangle at the hoist. In the center of the triangle is a golden-yellow sun with eight primary rays, each representing a province.");
		countryDescription.put("Malaysia",
				"The national flag of Malaysia, also known as the Stripes of Glory, is composed of a field of 14 alternating red and white stripes along the fly and a blue canton bearing a crescent and a 14-point star known as the Bintang Persekutuan.");
		countryDescription.put("Singapore",
				"The design is a horizontal bicolour of red above white, overlaid in the canton (upper-left quadrant) by a white crescent moon facing a pentagon of five small white five-pointed stars. The elements of the flag denote a young nation on the ascendant, universal brotherhood and equality, and national ideals.");
		countryDescription.put("Thailand",
				"The flag of Thailand shows five horizontal stripes in the colours red, white, blue, white and red, with the central blue stripe being twice as wide as each of the other four. The design was adopted on 28 September 1917, according to the royal decree issued by Rama VI.");
		
		/** Top Panel Start **/
		topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());

		/* CountryBoxLabel */
		countryBoxLabel = new JLabel("Select a country: ");
		topPanel.add(countryBoxLabel);

		/* Country Combo Box */
		countryBox = new JComboBox<>(countries);
		countryBox.setPreferredSize(new Dimension(300, 30));
		countryBox.setFocusable(false);
		countryBox.addActionListener(this);
		topPanel.add(countryBox);

		/** Center Panel Start **/
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 2));

		/* Flag Label */
		flagLabel = new JLabel();
		flagLabel.setHorizontalTextPosition(JLabel.CENTER);
		flagLabel.setVerticalTextPosition(JLabel.BOTTOM);
		centerPanel.add(flagLabel);

		/* Country Text Area */
		countryField = new JTextArea();
		countryField.setLineWrap(true);
		countryField.setWrapStyleWord(true);
		centerPanel.add(countryField);
		
		/* Scroll Pane */
		scroll = new JScrollPane(countryField, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		centerPanel.add(scroll);
		/** Center Panel Done **/
		
		/* Initial Country Output */
		String selectedCountry = (String) countryBox.getSelectedItem();
		countryFlag = new ImageIcon(scaleImage(selectedCountry + ".png"));
		flagLabel.setIcon(countryFlag);
		flagLabel.setText(selectedCountry);
		countryField.setText(countryDescription.get(selectedCountry));

		add(centerPanel, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == countryBox) {
			String selectedCountry = (String) countryBox.getSelectedItem();
			countryFlag = new ImageIcon(scaleImage(selectedCountry + ".png"));
			flagLabel.setIcon(countryFlag);
			flagLabel.setText(selectedCountry);
			countryField.setText(countryDescription.get(selectedCountry));
		}
	}

	public Image scaleImage(String path) { /* Method to scale Flags to be Constant Size */
		return new ImageIcon(path).getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH);
	}

	public static void main(String[] args) {
		new Question2B();
	}
}
