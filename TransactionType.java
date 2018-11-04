package Project5;

public class TransactionType {

	private int TransactionID;
	private String TransactionDescription;
	private int Duration;
	
	public TransactionType(int tI, String tD, int d){
		this.TransactionID = tI;
		this.setTransactionDescription(tD);
		this.setDuration(d);
		
	}
	
	public int getTransactionID(){
		return this.TransactionID;
	}
	
	public void setTransactionID(int tID){
		this.TransactionID = tID;
	}

	public String getTransactionDescription() {
		return TransactionDescription;
	}

	public void setTransactionDescription(String tDes) {
		TransactionDescription = tDes;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int dur) {
		Duration = dur;
	}
	
	
}
