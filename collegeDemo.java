/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import java.util.Scanner;
public class collegeDemo {
    public static void main(String []args)
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter college name");
        String colname=s.nextLine();
        System.out.println("Enter student name");
        String name=s.next();
        System.out.println("Enter Roll number");
        int rollno=s.nextInt();
        System.out.println("Enter Score");
        float score=s.nextFloat();
        System.out.println("Enter Semester");
        byte sem=s.nextByte();
        System.out.println("Enter Mobile number");
        long mobno=s.nextLong();
        System.out.println("Enter Gender");
        char gender=s.next().charAt(0);
        System.out.println(" college name = "+colname);
        System.out.println(" student name = "+name);
        System.out.println(" roll number = "+rollno);
        System.out.println(" score = "+score);
        System.out.println(" sem = "+sem);
        System.out.println(" mobile number = "+mobno);
        System.out.println(" gender = "+gender);
    }
}
