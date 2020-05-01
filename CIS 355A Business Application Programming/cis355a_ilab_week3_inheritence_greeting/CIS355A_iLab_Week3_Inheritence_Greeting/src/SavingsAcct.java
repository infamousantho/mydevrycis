
public class SavingsAcct extends Account {

	public double CalcInterest(){
		if(super.Balance >= 5000)
		{
			return super.Balance + (0.04*super.Balance);
		}
		if(super.Balance >= 3000)
		{
			return super.Balance + (0.03*super.Balance);
		}
		return super.Balance + (0.02*super.Balance);
		
	}
	
}
