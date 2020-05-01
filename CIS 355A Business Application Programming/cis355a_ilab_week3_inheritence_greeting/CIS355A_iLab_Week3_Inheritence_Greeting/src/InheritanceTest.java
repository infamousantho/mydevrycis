/***********************************************************************
Program Name: InheritanceTest.java
Programmer's Name: Student Name
Program Description: This is the main test class 
which will test the functionalities of Account, CheckingAcct and SavingsAcct Classes
***********************************************************************/

import javax.swing.JOptionPane;


public class InheritanceTest {

	public static void main(String[] args) {
		
		String BankName = JOptionPane.showInputDialog("Enter Bank Name");
		int RoutingNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter Routing Number"));
		
		CheckingAcct Account1 = new CheckingAcct();
		SavingsAcct Account2 = new SavingsAcct();
		Account1.ProcessDeposit(1000);
		Account2.ProcessDeposit(100);
		Account1.ProcessWithdrawal(300);
		Account2.ProcessWithdrawal(500);
		double Interest1 = Account1.CalcInterest();
		double Interest2 = Account2.CalcInterest();
		
		String output = "Bank Name:"+BankName + " Routing Number:" + RoutingNumber;
		output+= "\nEnter First Account Name:" + Account1.AccountName + " Account Id:"+Account1.AccountId +" Balance:"+Account1.Balance+" Interest:"+Interest1;
		output+= "\nEnter Second Account Name:" + Account2.AccountName + " Account Id:"+Account2.AccountId +" Balance:"+Account2.Balance+" Interest:"+Interest2;
		
		JOptionPane.showMessageDialog(null, output);

	}

}
