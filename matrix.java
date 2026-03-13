/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
public class matrix {
    public static void main(String []args)
    {
        int n=5;
        for(int i=0;i<n;i++)
        {
             for(int j=0;j<=i;j++)
            {
                System.out.print(" * ");
            }
        System.out.println(); 
        }
        System.out.println();
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print(" * ");
            }
        System.out.println();    
        }
    }
}
