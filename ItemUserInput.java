/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import java.util.Scanner;
public class ItemUserInput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        String[] items = new String[n];
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter item " + (i + 1) + " name:");
            items[i] = sc.next();

            System.out.println("Enter item " + (i + 1) + " price:");
            prices[i] = sc.nextInt();
        }

        System.out.println("\nItem List:");
        for (int i = 0; i < n; i++) {
            System.out.println(items[i] + " - Rs." + prices[i]);
        }
    }
}
