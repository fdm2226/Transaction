package Project5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import BS_Practice_2.customer;
import Project3.InventorySystem;
import Project3.SalesData;

public class Bank {
	private String customerPath = "C:/Users/Owner/Desktop/Comp182/Comp182Project_5/Bank.csv";
	private String TransactionPath = "C:/Users/Owner/Desktop/Comp182/Comp182Project_5/TransactionTypes.csv";

	private ArrayList<Customer> customerData;
	private ArrayList<TransactionType> transactionData;
	
	public Bank(){
		customerData = new ArrayList<Customer>();
		transactionData = new ArrayList<TransactionType>();
		readCustomerData(customerPath);
		readTransactionType(TransactionPath);
		simulate();
	}


	

	private void readTransactionType(String tp) {
		
		String line = "";
		try{
			BufferedReader br = new BufferedReader(new FileReader(tp));
			br.readLine();
			while((line = br.readLine()) != null && !line.isEmpty()){
				String[] data  = line.split(",");
				int TID = Integer.parseInt(data[0]);
				String TD = (data[1]);
				int D = Integer.parseInt(data[2]);
				this.transactionData.add(new TransactionType(TID, TD, D));
					}//end of while loop
				br.close();
			}
			catch(Exception e){
				
	}
		
		
	}


	//read customer csv file
	private void readCustomerData(String cp) {
		String line = "";
		try{
			BufferedReader br = new BufferedReader(new FileReader(cp));
			br.readLine();
			while((line = br.readLine()) != null && !line.isEmpty()){
				int AT;
				String[] data  = line.split(",");
				int TN = Integer.parseInt(data[0]);
				int CI = Integer.parseInt(data[1]);
				if(!data[2].isEmpty()){
					 AT = Integer.parseInt(data[2]);
				}else{
					 AT = 0;
				}
				String TT = data[3];
				this.customerData.add(new Customer(TN, CI, AT, TT));
			}//end of while loop
			br.close();
		}
		catch(Exception e){
				System.out.println("Anything");
		}
		
	}//end of readCustomerData
	
	//
	
	public void simulate() {
			String output = "";
			int current = 1;
			System.out.println("Customer Data: ");
			for(int t = 0; t < customerData.size(); t++){
				if(current == this.customerData.get(t).getTransactionnumber()){
					int counter = 0;
					int tempCustomerId = customerData.get(t).getCustomerId();
					int tempArrival = customerData.get(t).getArrivalTime();
					int tempTransactionTime = findTransaction(customerData.get(t).getTransactionType());
					Queue<Integer> q = new LinkedList();
					int totalTime = tempArrival + tempTransactionTime;
					q.add(totalTime);
						output += "Customer: " + tempCustomerId + " Arrived: " + tempArrival + " TransacionTime: " + tempTransactionTime +  " total time: " + q + "\n"; 	
				}//end of if loop
				
				else{
					current++;
					t--;
				}
			}//end of for loop
			
			System.out.println(output);

	}//end of simulate
	
	
	
	//finds trascation and gets duration
	private int findTransaction(String temp){
		int tempDuration = 0;
		for(int a = 0; a < transactionData.size(); a++){
			String tempTransact = transactionData.get(a).getTransactionDescription();
			if(temp.compareTo(tempTransact) == 0)
				tempDuration = transactionData.get(a).getDuration();

		}
		return tempDuration;
		
		
	}

	
	
	public static void main(String[] args){
		new Bank();
}

	
}

