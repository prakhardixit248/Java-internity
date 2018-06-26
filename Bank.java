import java.util.*;
public class Bank 
{
    long amt,money[];
    int c=0,cap=1000 ;boolean cr[];
    Bank b;int ch;
    public static void main(String args[])
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter 0 to make account 1 to access account");
       ch=sc.nextInt();
       b=new Bank();
       switch(ch){
                    case 0 :
                            b.Create();
                            break;
                    case 1 :
                    	    System.out.println("Enter the Account NO.");
                    	    int acc=sc.nextInt();
                            b.trans(acc);
                            break;
                    default :
                              System.out.println("Wrong Choice");
                 }
     }
    
    void Create()
     { 
          Scanner in=new Scanner(System.in);
         if(c>cap)
        {
             System.out.println("Bank Capacity Full");
        }
        else
        {
             c++;
             money=new long[c+1];
             cr=new boolean[c+1];
             System.out.println("Enter the amount of money more than 5000 ");
             amt=in.nextLong();
             if(amt>5000)
             {
                money[c]=amt;
                cr[c]=true;
                System.out.println("Account created ");
                System.out.println("Account no. : "+c);
                amt=amt-500;
                System.out.println("Current Balance : "+amt);
             }
        }
    }
    void trans(int acc)
    {   
        int ch;
        Scanner in=new Scanner(System.in);
        if((acc>c)||(cr[acc]==false))
        {
            System.out.println("Account Does Not Exist");
        }
        else 
        {
            System.out.println("Enter 0 for debit and 1 for credit ");
            ch=in.nextInt(); 
            switch(ch){
                         case 0 :
                                  System.out.println("Enter amount of money to be debited not more than 30000");
                                  amt=in.nextLong();
                                  if((amt<money[acc])&&(amt<30000))
                                  {
                                     money[acc]=money[acc]-amt;
                                     System.out.println("Money Debited Successfully");
                                  }
                                  else 
                                  {
                                      System.out.println("Amount Cannot be debited");
                                  }
                                  if(money[acc]==0)
                                  cr[acc]=false;
                                   break;
                         case 1 :
                                  System.out.println("Enter amount of money to be credited");
                                  amt=in.nextLong();
                                  money[acc]=money[acc]+amt;
                                  System.out.println("Money Credited Successfully");
                                  break;
                        default :
                                 System.out.println("Wrong Choice");
                         }
         }
       }
 }