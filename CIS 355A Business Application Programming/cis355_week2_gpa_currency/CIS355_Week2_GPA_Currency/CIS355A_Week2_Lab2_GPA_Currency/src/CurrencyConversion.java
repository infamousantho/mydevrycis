/***********************************************************************
 Program Name: CurrencyConversion.java
 Programmer's Name: Student Name
 Program Description: This program will input a source currency and convert the amount into the target currency.
 ***********************************************************************/
import java.text.DecimalFormat;

import javax.swing.JOptionPane;


public class CurrencyConversion {

	
	public static void main(String[] args) {
		String SourceCurrency = JOptionPane.showInputDialog("Enter Currency Code for the Input Amount");
		double Amount = Double.parseDouble(JOptionPane.showInputDialog("Enter Amount to be Converted"));
		String TargetCurrency = JOptionPane.showInputDialog("Enter Currency Code for the Currency you are converting to");
		double ConvertedAmount = ConvertCurrency(Amount,SourceCurrency,TargetCurrency);
		DecimalFormat df = new DecimalFormat("#.00");
		if(ConvertedAmount == -1){
			JOptionPane.showMessageDialog(null, "Unable to calculate conversion. Please enter the valid inputs");			
		}
		else{
		JOptionPane.showMessageDialog(null, SourceCurrency + " Converted " + TargetCurrency + " Amount(" + Amount + ")="+ df.format(ConvertedAmount));
		}
	}
	
	public static double ConvertCurrency(double Amount, String SourceCurrency, String TargetCurrency){
		
		double convertedAmount = -1;
		SourceCurrency = SourceCurrency.trim().toUpperCase();
		TargetCurrency = TargetCurrency.trim().toUpperCase();
			switch(SourceCurrency){
		case "USD":
			if(TargetCurrency.equals("POUND")){
				convertedAmount = Amount * 0.6;
			}
			else if(TargetCurrency.equals("JPY")){
				convertedAmount = Amount * 103.73;
			}			
			break;
		case "POUND":
			if(TargetCurrency.equals("USD")){
				convertedAmount = Amount / 0.6;
			}
			else if(TargetCurrency.equals("JPY")){
				convertedAmount = Amount * 178.13;
			}
			
			break;
		case "JPY":
			if(TargetCurrency.equals("USD")){
				convertedAmount = Amount / 103.73;
			}
			else if(TargetCurrency.equals("POUND")){
				convertedAmount = Amount / 178.13;
			}
			break;
		}
	
		return convertedAmount;	
		
	}
	

}
