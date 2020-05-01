import javax.swing.JOptionPane;


public class CheckingAcct extends Account{

	public double overDraftFee;
	
	public CheckingAcct(){
		super();
		overDraftFee= Double.parseDouble(JOptionPane.showInputDialog("Enter Overdraft Fees"));
	}
	
	public double CalcInterest(){
		if((super.Balance-overDraftFee) >= 3000)
		{
			return (super.Balance-overDraftFee) + (0.01*(super.Balance-overDraftFee));
		}
		return 0;
		
	}
	
}
