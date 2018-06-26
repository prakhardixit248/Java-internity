import java.util.*;
import java.io.*;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class Bank
{
    static HashMap<Integer,AAccount> Account=new HashMap<>();
    Date d=new Date();
    String date=new SimpleDateFormat("dd/mm/yyyy").format(d);
    String time=new SimpleDateFormat("hh:mm:ss").format(d);
    public void credit(int acno)
    {
        Scanner in=new Scanner(System.in);
        AAccount acc=Account.get(acno);
        System.out.println("Enter the ammont to be credit");
        int ca=in.nextInt();
        if(ca>0)
        {
        int b=ca+acc.acBal;
        Account.put(acno,acc);
        System.out.println("Amount Credited");
        System.out.println("New balance :"+acc.acBal);
        Account.ms.add("Amount "+ca+"has been credited to Account"+acno);
        }
        else
        System.out.println("Invalid Entry");
    }
    public void debit(int acno)
    {
        Scanner in=new Scanner(System.in);
        AAccount acc=Account.get(acno);
        System.out.println("Enter the amount to be credit");
        int da=in.nextInt();
        if(da>0)
        {
        int b=acc.acBal-da;
        Account.put(acno,acc);
        System.out.println("Amount Debiited");
        System.out.println("New balance :"+acc.acBal);
        Account.ms.add("Amount "+da+"has been debited to Account"+acno);
        }
        else
        System.out.println("Invalid Entry");
    }
}