import java.util.*;
import java.io.*;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
interface Account
{
final int cap=100000;
void debit(int acno);
void credit(int acno);
}
class Bank implements Account
{
    static HashMap<Integer,AAccount> Account=new HashMap<>();
    Date d=new Date();
    String date=new SimpleDateFormat("dd/mm/yyyy").format(d);
    String time=new SimpleDateFormat("hh:mm:ss").format(d);
    public void credit(int acno)
    {
        try
        {
             Scanner in=new Scanner(System.in);
             AAccount acc=Account.get(acno);
             System.out.println("Enter the amount to be credit");
             int ca=in.nextInt();
             if(ca>0)
             {
                  int b=ca+acc.acBal;
                  acc.acBal=b;
                  Account.put(acno,acc);
                  System.out.println("Amount Credited");
                  System.out.println("New balance :"+acc.acBal);
                  AAccount.ms.add(date+" "+time+"  "+ca+"         has been credited to      "+acno);
             }
             else
                  throw new Exception("Negative Number Entered");
        }
        catch(Exception e)
        {
             System.out.println(e.getMessage());
        }
    }
    public void debit(int acno)
    {
        try
        {
             Scanner in=new Scanner(System.in);
             AAccount acc=Account.get(acno);
             System.out.println("Enter the amount to be debit");
             int da=in.nextInt();
             if((da>0)&&(da<acc.acBal))
             {
                  int b=acc.acBal-da;
                  acc.acBal=b;
                  Account.put(acno,acc);
                  System.out.println("Amount Debiited");
                  System.out.println("New balance :"+acc.acBal);
                  AAccount.ms.add(date+time+da+"has been debited from"+acno);
             }
             else
                  throw new Exception("Negative Number Entered");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

public class AAccount extends Bank
{
    String accname;
    int acno;
    int acBal;
    static ArrayList<String> ms;
    AAccount(String name,int no,int bal)
    {
        accname=name;
        acBal=bal;
        acno=no;
        
        Account.put(acno,this);
    }
    public void call()
    {
        
            
        while(true)
        {                               
                                    
                Scanner in=new Scanner(System.in);
                Bank bank = new Bank();
            
                System.out.println("\nYour Current Balance is Rs"+this.acBal+"\n");
                System.out.println("Enter 1 to credit");
                System.out.println("Enter 2 to debit");
                System.out.println("Enter 3 to generate mini statement");
                System.out.println("Enter 4 to exit");
                int ch = in.nextInt();
                
                switch(ch)
                {
                    case 1:
                            bank.credit(acno);
                            break;
                            
                    case 2: 
                            bank.debit(acno);
                            break;
                            
                    case 3: for(int i=0;i<AAccount.ms.size();i++)
                                System.out.println(AAccount.ms.get(i));
                    
                            System.out.println("--------------------------------------");
                            break;
                    
                    case 4: System.exit(0);
                            break;
                            
                    default: System.out.println("Please Enter the valid number");       
                    
               }               
    
        }                  
    }
    public static void main(String... args) 
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		ms = new ArrayList<String>();

                 ms.add("   DATE   "+"   TIME  "+"   AMOUNT  "+"           ACTION         "+"   ACCOUNT NUMBER   ");

		
		char y='y';
		while(y=='y')                    
		{								
			try 
			{
                                System.out.println(".....*****BANK*****.....");

				System.out.println("Enter the Account Holder Name");
				String name = br.readLine();
				
				System.out.print("Your  Account No. Is");
				int num =(int) (Math.random()*cap);
                                System.out.println(" "+num);
				
				System.out.println("Enter the Current Balance");
				int bal = Integer.parseInt(br.readLine());
				
				if(bal<0)
                                {
					System.out.println("Amount can't be negative");
                                        throw new Exception("Negative Number Entered");
				}
				else
				{
					y='n';				
					
					AAccount accob = new AAccount(name,num,bal);
					accob.call();
				}
			} 
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
			
		}
	}
}
