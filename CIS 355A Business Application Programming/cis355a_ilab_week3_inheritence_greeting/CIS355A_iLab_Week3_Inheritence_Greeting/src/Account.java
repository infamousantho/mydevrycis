import javax.swing.JOptionPane;


public class Account {
	public String AccountName;
	public int AccountId;
	public double Balance;
	
	public void ProcessDeposit(double depositAmount){
		Balance += depositAmount;
	}
	
	public void ProcessWithdrawal(double withdrawalAmount){
		Balance -= withdrawalAmount;
	}
	
	public double CalcInterest(){
		return 0;
		
	}
	
	public Account(){
		String AcctName = JOptionPane.showInputDialog("Enter Account Name");
		int AcctId = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Id"));
		double balance = Double.parseDouble(JOptionPane.showInputDialog("Enter Initial Account Balance"));
		AccountName=AcctName;
		AccountId=AcctId;
		Balance = balance;
	}
	

}
