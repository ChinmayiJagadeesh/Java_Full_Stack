/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import java.util.ArrayList;
import java.util.Scanner;
public class ArrayList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> devices = new ArrayList<>();
        ArrayList<Boolean> status = new ArrayList<>();

        System.out.print("Enter number of devices: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter device name: ");
            String name = sc.nextLine().toLowerCase(); // convert to lowercase
            devices.add(name);
            status.add(false);
        }

        int choice;

        do {
            System.out.println("\n===== SWITCH BOARD =====");
            System.out.println("1. Show Devices");
            System.out.println("2. Switch ON Device");
            System.out.println("3. Switch OFF Device");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nDevices Status:");
                    for (int i = 0; i < devices.size(); i++) {
                        System.out.println(i + " - " + devices.get(i) +
                                " : " + (status.get(i) ? "ON" : "OFF"));
                    }
                    break;

                case 2:
                    System.out.print("Enter device index to ON: ");
                    int onIndex = sc.nextInt();

                    if (onIndex >= 0 && onIndex < devices.size()) {
                        status.set(onIndex, true);

                        String device = devices.get(onIndex);

                        if (device.equals("fan")) {
                            System.out.println("Fan is working");
                        } else if (device.equals("light")) {
                            System.out.println("Light is glowing");
                        } else if (device.equals("motor")) {
                            System.out.println("Motor is running");
                        } else {
                            System.out.println(device + " is ON");
                        }

                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 3:
                    System.out.print("Enter device index to OFF: ");
                    int offIndex = sc.nextInt();

                    if (offIndex >= 0 && offIndex < devices.size()) {
                        status.set(offIndex, false);
                        System.out.println(devices.get(offIndex) + " is OFF");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}