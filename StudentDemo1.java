/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import java.util.Scanner;
class stud
{
    String name,address;
    int rollno,sem;
    void readdata(Scanner sc)
    {
        System.out.println("Enter name");
        name=sc.nextLine();
        System.out.println("Enter sem");
        sem=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter rollno");
        rollno=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter address");
        address=sc.nextLine();
    }
    void displayData()
    {
        System.out.println("name: " +name);
        System.out.println("sem: " +sem);
        System.out.println("rollno: " +rollno);
        System.out.println("address: " +address);
    }
}
public class StudentDemo1 {
    public static void main(String []args)
    {
        Scanner sc= new Scanner(System.in);
        stud[]s=new stud[5];
        for(int i=0;i<5;i++)
        {
            s[i]=new stud();
            System.out.println("enter the details of student"+(i+1));
            s[i].readdata(sc);
        }
       System.out.println("student details");
       for(int i=0;i<5;i++)
       {
           s[i].displayData();
       }
    }
}
