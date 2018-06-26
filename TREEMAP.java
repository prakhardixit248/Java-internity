import java.util.*;
class TREEMAP{
public static void main(String args[]){
TreeMap<Integer,String> tm=new TreeMap<>();
tm.put(1,"Prakhar");
tm.put(2,"Rachit");
tm.put(3,"Saurabh");
tm.put(4,"Shashank");
tm.put(5,"Alaukik");
tm.put(6,"Apurv");
tm.put(7,"Rishabh");
tm.put(8,"Mridul");
tm.put(9,"Ayush");
tm.put(10,"Ishan");
tm.put(11,"Paras");
tm.put(12,"Rajat");
for(Map.Entry m : tm.entrySet())
{
System.out.println(m.getKey()+" "+m.getValue());
}
}
}