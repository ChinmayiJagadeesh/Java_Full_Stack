/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import java.util.*;
public class NumberGuessingGame {
    public static void main(String[] args)
    {
        Random random=new Random();
        int numberToGuess=random.nextInt(100)+1;
        int attempts=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to number guessing game !");
        System.out.println(" I am thinking of a number between 1 to 100 ");
        while(true)
        {
            System.out.println("Enter your Guess : ");
            int userGuess=scanner.nextInt();
            attempts++;
            if(userGuess== numberToGuess)
            {
                System.out.println("Congratulations ! you guessed the number in "+ attempts+" attempts");
                break;
            }
            else if(userGuess<numberToGuess)
            {
                System.out.println("Too low ! try again ");
            }
            else
            {
                System.out.println("Too high ! try again ");
            }
        }
    }
}
