import java.util.*;
class ARRAYDEQUE
{
public static void main(String args[])
{
ArrayDeque<String> d=new ArrayDeque<>();
d.add("Prakhar");
d.add("Rachit");
d.add("Saurabh");
d.add("Shashank");
d.add("Alaukik");
d.add("Apurv");
d.add("Rishabh");
d.add("Mridul");
d.add("Ayush");
d.add("Ishan");
d.add("Paras");
d.add("Rajat");
for(String str : d)
{
System.out.println(str);
}
}
}