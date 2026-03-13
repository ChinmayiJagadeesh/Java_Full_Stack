/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import java.util.ArrayList;
import java.util.*;
public class Collection {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Store food stalls
        ArrayList<String> stalls = new ArrayList<>();

        // 2. Chef updates dishes
        Vector<String> dishes = new Vector<>();

        // 3. Customer line
        Queue<String> customers = new LinkedList<>();

        // 4. Last visited stalls
        Stack<String> lastVisited = new Stack<>();

        // 5. Daily history
        LinkedList<String> history = new LinkedList<>();

        int choice;

        do {
            System.out.println("\n--- Magical Food Festival ---");
            System.out.println("1. Add Food Stall");
            System.out.println("2. Chef Add Dish");
            System.out.println("3. Customer Arrives");
            System.out.println("4. Serve Customer");
            System.out.println("5. Customer Goes Back (Undo)");
            System.out.println("6. Show Daily History");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                // Add stall
                case 1:
                    System.out.print("Enter stall name: ");
                    String stall = sc.nextLine();
                    stalls.add(stall);
                    System.out.println("Stall Added!");
                    break;

                // Chef adds dish
                case 2:
                    System.out.print("Enter dish name: ");
                    String dish = sc.nextLine();
                    dishes.add(dish);
                    System.out.println("Dish Updated!");
                    break;

                // Customer arrives
                case 3:
                    System.out.print("Enter customer name: ");
                    String customer = sc.nextLine();
                    customers.add(customer);
                    System.out.println(customer + " joined the line.");
                    break;

                // Serve customer
                case 4:
                    if(!customers.isEmpty()) {
                        String served = customers.poll();
                        System.out.println(served + " is served.");

                        System.out.print("Visited stall: ");
                        String visited = sc.nextLine();

                        lastVisited.push(visited);
                        history.add(served + " visited " + visited);
                    } else {
                        System.out.println("No customers!");
                    }
                    break;

                // Customer goes back
                case 5:
                    if(!lastVisited.isEmpty()) {
                        System.out.println("Customer returned to: " + lastVisited.pop());
                    } else {
                        System.out.println("No previous stall!");
                    }
                    break;

                // Show history
                case 6:
                    System.out.println("\n--- Daily History ---");
                    for(String h : history) {
                        System.out.println(h);
                    }
                    break;
            }

        } while(choice != 7);

        System.out.println("Festival Closed!");
    }
}

