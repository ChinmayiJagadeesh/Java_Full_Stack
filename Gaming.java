/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import java.util.Scanner;

/* ---------- 1. Game Interface (Abstraction) ---------- */
interface Game {
    void startGame();
    void stopGame();
    int getCost();
    String getGameName();
}

/* ---------- 2. Game Implementations (Inheritance) ---------- */
class RacingGame implements Game {
    @Override
    public void startGame() {
        System.out.println("Racing Game Started 🏎️");
    }

    @Override
    public void stopGame() {
        System.out.println("Racing Game Stopped");
    }

    @Override
    public int getCost() {
        return 50;
    }

    @Override
    public String getGameName() {
        return "Racing Game";
    }
}

class ShootingGame implements Game {
    @Override
    public void startGame() {
        System.out.println("Shooting Game Started 🔫");
    }

    @Override
    public void stopGame() {
        System.out.println("Shooting Game Stopped");
    }

    @Override
    public int getCost() {
        return 70;
    }

    @Override
    public String getGameName() {
        return "Shooting Game";
    }
}

class VRAdventureGame implements Game {
    @Override
    public void startGame() {
        System.out.println("VR Adventure Game Started 🥽");
    }

    @Override
    public void stopGame() {
        System.out.println("VR Adventure Game Stopped");
    }

    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public String getGameName() {
        return "VR Adventure Game";
    }
}

/* ---------- 3. Wallet Class (Encapsulation) ---------- */
class Wallet {
    private int balance;

    public Wallet(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void addMoney(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Money added successfully!");
        }
    }

    public boolean deductMoney(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient balance!");
            return false;
        }
    }
}

/* ---------- 4. Player Class ---------- */
class Player {
    private final String name;
    private final String membershipCard;
    private final Wallet wallet;

    public Player(String name, String membershipCard, int balance) {
        this.name = name;
        this.membershipCard = membershipCard;
        this.wallet = new Wallet(balance);
    }

    public void showDetails() {
        System.out.println("\nPlayer Name: " + name);
        System.out.println("Membership Card: " + membershipCard);
        System.out.println("Wallet Balance: " + wallet.getBalance());
    }

    public void addMoney(int amount) {
        wallet.addMoney(amount);
    }

    public void playGame(Game game) {
        System.out.println("\nSelected: " + game.getGameName());
        int cost = game.getCost();

        if (wallet.deductMoney(cost)) {
            game.startGame();
            System.out.println("Credits deducted: " + cost);
            System.out.println("Remaining balance: " + wallet.getBalance());
            game.stopGame();
        }
    }
}
public class Gaming {
   public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Player Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Membership Card Number: ");
        String card = sc.nextLine();

        System.out.print("Enter Initial Wallet Balance: ");
        int balance = sc.nextInt();

        Player player = new Player(name, card, balance);

        int choice;

        do {
            System.out.println("\n===== GAME ZONE MENU =====");
            System.out.println("1. Show Player Details");
            System.out.println("2. Add Money to Wallet");
            System.out.println("3. Play Racing Game (Cost 50)");
            System.out.println("4. Play Shooting Game (Cost 70)");
            System.out.println("5. Play VR Adventure Game (Cost 100)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            Game game = null; // polymorphism reference

            switch (choice) {
                case 1:
                    player.showDetails();
                    break;

                case 2:
                    System.out.print("Enter amount to add: ");
                    int amount = sc.nextInt();
                    player.addMoney(amount);
                    break;

                case 3:
                    game = new RacingGame();
                    player.playGame(game);
                    break;

                case 4:
                    game = new ShootingGame();
                    player.playGame(game);
                    break;

                case 5:
                    game = new VRAdventureGame();
                    player.playGame(game);
                    break;

                case 6:
                    System.out.println("Thank you for visiting Game Zone ?");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
