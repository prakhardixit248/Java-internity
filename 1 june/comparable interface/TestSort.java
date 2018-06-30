import java.util.*;
import java.io.*;
public class TestSort
{
public static void main(String args[])
{
ArrayList<Student> al=new ArrayList<>();
al.add(new Student(1,"Prakhar",20));
al.add(new Student(2,"Paras",19));
al.add(new Student(3,"Alaukik",21));
al.add(new Student(4,"Ayush",19));
al.add(new Student(5,"Mridul",19));
Collections.sort(al);
for(Student st : al)
{
System.out.println(st.rollno+" "+st.name+" "+st.age);
}
}
}
