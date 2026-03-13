/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
public class ChessBoard {
    public static void main(String []args)
    {
        int s=8;
        for(int  i=0;i<s;i++)
        {
            for(int j=0;j<s;j++)
            {
                if((i+j)%2==0)
                {
                    System.out.print("B");
                    
                }
                else
                {
                    System.out.print("W");
                }
            }
            System.out.println();
        }
    }
}
