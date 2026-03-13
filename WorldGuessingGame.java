/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import java.util.*;
public class WorldGuessingGame {
    public static void main(String[] args)
    {
        Random random=new Random();
        String[]words={"india","karnataka","mysore","banglore","computer","java","c","python"};
        String wordToGuess=words[random.nextInt(words.length)];
        int attempts=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to word guessing game !");
        System.out.println(" Guess the word ");
        while(true)
        {
            System.out.println("Enter your Guess : ");
            String wordGuess=scanner.nextLine();
            attempts++;
            if(wordGuess.equalsIgnoreCase(wordToGuess))
            {
                System.out.println("Congratulations ! you guessed the number in "+ attempts+" attempts");
                break;
            }
            else
            {
                System.out.println("wrong guess !");
            }
        }
    }
}
