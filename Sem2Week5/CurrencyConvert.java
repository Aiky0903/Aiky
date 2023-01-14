import javax.swing.*;

public class CurrencyConvert
{
    public static void main(String[]args) {
    	String dollars = JOptionPane.showInputDialog("Please enter USD amount");
    	double ringgit = Double.parseDouble(dollars) * 4.2;
    	JOptionPane.showMessageDialog(null, "That is " + ringgit + " Ringgit.");
    }
}
