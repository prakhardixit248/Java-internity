import java.util.*;
import java.io.*;
class Simple
{
public static void main(String args[])
{
ArrayList<Student> al=new ArrayList<Student>();
al.add(new Student(1,"Prakhar",19));
al.add(new Student(2,"Alaukik",20));
al.add(new Student(3,"Paras",21));
al.add(new Student(4,"Ayush",22));
System.out.println("Sorting by Name...");
Collections.sort(al,new NameComparator());
Iterator itr=al.iterator();
while(itr.hasNext())
{
Student st=(Student)itr.next();
System.out.println(st.rollno+" "+st.name+" "+st.age);
}
System.out.println("Sorting by Age...");
Collections.sort(al,new AgeComparator());
Iterator itr2=al.iterator();
while(itr2.hasNext())
{
Student st=(Student)itr2.next();
System.out.println(st.rollno+" "+st.name+" "+st.age);
}
}
}