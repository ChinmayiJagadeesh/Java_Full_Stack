/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import java.util.Scanner;
public class SimpleClaculator {
    public static void main(String []ags)
    {
        Scanner s=new Scanner(System.in);
        System.out.println(" Simple Calculator ");
        System.out.println(" Enter the 1st number : ");
        double a=s.nextDouble();
        System.out.println(" Enter the 2nd number : ");
        double b=s.nextDouble();
        System.out.println(" Choose the operation : ");
        System.out.println(" 1. Addition ");
        System.out.println(" 2. Subtraction ");
        System.out.println(" 3. Multiplication ");
        System.out.println(" 4. Division ");
        System.out.println(" Enter the choice : ");
        int choice=s.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println(" Result : "+(a+b));
                break;
            case 2:
                System.out.println(" Result : "+(a-b));
                break;
            case 3:
                System.out.println(" Result : "+(a*b));
                break;
            case 4:
                if(b!=0)
                System.out.println(" Result : "+(a/b));
                else 
                System.out.println(" not divisible ");
                break;
        }
    }
}
