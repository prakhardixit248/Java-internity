import java.util.*;
class TREESET{
public static void main(String args[]){
TreeSet<Integer> ts=new TreeSet<>();
ts.add(1);
ts.add(2);
ts.add(3);
ts.add(4);
ts.add(5);
ts.add(6);
ts.add(7);
ts.add(8);
ts.add(9);
ts.add(10);
ts.add(11);
ts.add(12);
Iterator itr=ts.iterator();
while(itr.hasNext())
{
System.out.println(itr.next());
}
}
}
