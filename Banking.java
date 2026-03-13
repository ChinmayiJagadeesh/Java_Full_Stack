/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import java.util.Scanner;

class BankAccount {

    private double balance = 5000;
    Scanner sc = new Scanner(System.in);

    // Deposit Method
    void deposit() {
        try {
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();

            if (amount < 0) {
                throw new IllegalArgumentException("Amount cannot be negative.");
            }

            simulateNetwork();

            balance += amount;
            System.out.println("✅ Deposit successful.");
            System.out.println("Available balance: ₹" + balance);
        }

        catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        }

        catch (RuntimeException e) {
            System.out.println("⚠ " + e.getMessage());
        }

        finally {
            System.out.println("Thank you for banking with us.\n");
        }
    }

    // Withdraw Method
    void withdraw() {
        try {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();

            if (amount < 0) {
                throw new IllegalArgumentException("Amount cannot be negative.");
            }

            if (amount > balance) {
                throw new ArithmeticException("Insufficient balance.");
            }

            simulateNetwork();

            balance -= amount;
            System.out.println("✅ Withdrawal successful.");
            System.out.println("Available balance: ₹" + balance);
        }

        catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        }

        catch (ArithmeticException e) {
            System.out.println("❌ " + e.getMessage());
        }

        catch (RuntimeException e) {
            System.out.println("⚠ " + e.getMessage());
        }

        finally {
            System.out.println("Thank you for banking with us.\n");
        }
    }

    // Balance Check
    void checkBalance() {
        System.out.println("💰 Available balance: ₹" + balance);
        System.out.println("Thank you for banking with us.\n");
    }

    // Simulate Network Issue
    void simulateNetwork() {
        if (Math.random() < 0.1) {
            throw new RuntimeException("Network error. Please try again later.");
        }
    }
}
public class Banking {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();
        int choice;

        do {
            System.out.println("====== BANK MENU ======");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.deposit();
                    break;

                case 2:
                    account.withdraw();
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("🙏 Thank you for using our Bank System.");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.\n");
            }

        } while (choice != 4);

        sc.close();
    }
}
