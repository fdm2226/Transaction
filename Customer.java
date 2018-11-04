package Project5;

public class Customer {

	private int transactionNumber;
	private int customerId;
	private int arrivalTime;
	private String transactionType;
	
	public Customer(int tN, int cI, int aT, String tT){
		transactionNumber = tN;
		customerId = cI;
		arrivalTime = aT;
		transactionType = tT;
		
	}
	
	public int getTransactionnumber(){
		return this.transactionNumber;
	}
	
	public void setTransactionNumber(int tNum){
		this.transactionNumber = tNum; 
	}
	
	
	public int getCustomerId(){
		return this.customerId;
	}
	
	public void setcustomerId(int cID){
		this.customerId = cID;
	}
	
	public int getArrivalTime(){
		return this.arrivalTime;
	}
	
	public void setArrivalTime(int ATime){
		this.arrivalTime = ATime;
	}
	
	public String getTransactionType(){
		return this.transactionType;
	}
	
	public void setTransactionType(String tType){
		this.transactionType = tType;
	}
	
}
