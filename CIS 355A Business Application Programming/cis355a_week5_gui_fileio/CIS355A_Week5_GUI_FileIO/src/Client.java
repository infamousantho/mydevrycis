/***********************************************************************
Program Name: Client.java
Programmer's Name: Student Name
Program Description: This class stored information for the client
***********************************************************************/

public class Client {

	private String ClientName;
	private String ClientId;
	private double StartingBalance;
	private double ClosingBalance;
	
	public Client(String cname,String cid,double sbal,double cbal){
		ClientName = cname;
		ClientId = cid;
		StartingBalance = sbal;
		ClosingBalance = cbal;
	}
	
	public void setClientName(String cname){
		ClientName = cname;
	}
	public String getClientName(){
		return ClientName;
	}
	public void setClientId(String cid){
		ClientId = cid;
	}
	public String getClientId(){
		return ClientId;
	}
	
	public void setStartingBalance(double bal){
		StartingBalance = bal;
	}
	public double getStartingBalance(){
		return StartingBalance;
	}
	
	public void setClosingBalance(double bal){
		ClosingBalance = bal;
	}
	public double getClosingBalance(){
		return ClosingBalance;
	}
}
