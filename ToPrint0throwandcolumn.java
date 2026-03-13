/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author Chinm
 */
import java.util.Scanner;
public class ToPrint0throwandcolumn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int r=3,c=3;
        int arr[][]={
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        System.out.println("0th row and 1st column elements");
        for(int i=0;i<r;i++){
            for(int j=1;j<c;j++){
                if(i==0||j==1)
                    System.out.print(arr[i][j]+" ");
            }
        }
    }
    
}
