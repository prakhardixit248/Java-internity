import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Transactions extends ATM
{
	
	//Every Transaction performed will have following details
	Date d = new Date();
	String date = new SimpleDateFormat("dd/MMM/yyyy").format(d);
	String time = new SimpleDateFormat("HH:mm:ss").format(d);	
	
	String particulars;
	int chequeNo;
	int damount;
	int camount;
	int finalBal;
	
	Transactions(String particulars, int cno, int damt, int camt,int fbal)
	{
		this.particulars = particulars;
		chequeNo = cno;
		damount = damt;
		camount = camt;
		finalBal = fbal;
		
	}	
}


public class ATM 
{

	static HashMap<Integer,Transactions> Passbook = new HashMap<>();
	static int sno=1;
	int currentBal;
	
	Date d = new Date();
	String date = new SimpleDateFormat("dd/MMM/yyyy").format(d);
	String time = new SimpleDateFormat("HH:mm:ss").format(d);
	
	static Queue<String> miniStatement = new LinkedList<>();
	public void credit()
	{
		try 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter the particulars");
			String p = br.readLine();
			
			System.out.println("Enter the checque number(If any else enter '0') ");
			int cno = Integer.parseInt(br.readLine());
			
			System.out.println("Enter the amount to be credited");
			int camount = Integer.parseInt(br.readLine());
			
			if(camount>0)
			{
				int fbal=0;
				  //current operation
				fbal = this.currentBal + camount;
				this.currentBal = fbal;

				System.out.println("Your new amount= "+this.currentBal);
				ATM.Passbook.put(sno, new Transactions(p,cno,0,camount,fbal));
				ATM.sno++;

				int size = ATM.miniStatement.size();
				if(size==5)
					ATM.miniStatement.remove();

				ATM.miniStatement.add("This Account is credited with Rs" +camount+" on date "+date+" at "+time+". Final Balance= Rs"+fbal);

			}
			else
				System.out.println("No negative transactions are allowed");
			
		} 
		catch (NumberFormatException | IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void debit()
	{
		try 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter the particulars");
			String p = br.readLine();
			
			System.out.println("Enter the checque number(If any else enter '0') ");
			int cno = Integer.parseInt(br.readLine());
			
			System.out.println("Enter the amount to be debited");
			int damount = Integer.parseInt(br.readLine());
			
			if(damount > 0)
			{
				if(this.currentBal>=damount)
				{
					int fbal=0;
					
					fbal = this.currentBal - damount;
					this.currentBal = fbal;
						
					System.out.println("Your new amount= "+this.currentBal);
					ATM.Passbook.put(sno, new Transactions(p,cno,damount,0,fbal));
					sno++;
					
					int size = ATM.miniStatement.size();
					if(size==5)
						ATM.miniStatement.remove();
					
					ATM.miniStatement.add("This Account is debited with Rs" +damount+" on date "+date+" at "+time+". Final Balance= Rs"+fbal);
				}
				else
					System.out.println("Not enough balance to withdraw");
			}
			else
				System.out.println("No Negative Transactions allowed");
			
		} 
		catch (NumberFormatException | IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	//code that prints passbook
	public void generatePassbook()
	{
		 if(ATM.Passbook.isEmpty())
		 {
			 System.out.println("No Transactions Done!");
		 }
		 else
		 {
			 System.out.println("S. no.   Perticulars   Cheque No.   Debit amt   Credit amt   Final Bal   Date");
			 for(HashMap.Entry<Integer,Transactions> m:Passbook.entrySet())
			 {
				 Transactions t = m.getValue();
					
				 System.out.print("   "+m.getKey()+"         "+t.particulars+"      ");
				 if(t.chequeNo==0)
					System.out.print("     -"+"   ");
			     else
					System.out.print("   "+t.chequeNo+"   ");
					
				 if(t.damount==0)
					System.out.print("        -          ");
				 else
					System.out.print("       "+t.damount+"           ");
					
				 if(t.camount==0)
					System.out.println("-         "+t.finalBal+"     "+t.date+"     "+t.time);
				 else
					System.out.println(t.camount+"         "+t.finalBal+"     "+t.date+"     "+t.time);
				 
				
				}
		}
		 
	}
	
	
	//code to print mini statements
	public void generateMiniStatement()
	{
		
		Iterator<String> it = ATM.miniStatement.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	
	public static void main(String[] args) 
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		ATM atmob = new ATM();
		
		while(true)        //if a user enters wrong input,  the program won't terminate.
		{				   //this loop will enable user to enter input again.
			try 
			{
				System.out.println("Enter current balance");
				atmob.currentBal = Integer.parseInt(br.readLine());
				break;      //break the loop if user enters correct input
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		while(true)				//if a user enters wrong input,  the program won't terminate.
		{				   		//this loop will enable user to enter input again.
			try 
			{
				System.out.println("\n");
				System.out.println("Enter 1 to credit money");
				System.out.println("Enter 2 to debit money");
				System.out.println("Enter 3 to generate passbook");

				System.out.println("Enter 4 to generate mini statements");
				System.out.println("Enter 5 to exit");
					
				int choice = Integer.parseInt(br.readLine());
				switch(choice)
				{
					case 1: atmob.credit();
							break;
								
					case 2: atmob.debit();		
							break;
								
					case 3: atmob.generatePassbook();
							break;
								
					case 4: atmob.generateMiniStatement();
							break;
							
					case 5: System.exit(0);								
				}	
			} 
			catch (NumberFormatException |IOException e) 
			{
				System.out.println("Give Valid Input Please.");
			}
		}
			
	}
		
}
