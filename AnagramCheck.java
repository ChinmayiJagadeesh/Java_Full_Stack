
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
public class AnagramCheck
{
    public static void main(String []args)
    {
        String s1="Listen";
        String s2="Silent";
        if(isAnagram(s1,s2))
            System.out.println("Anagram");
        else
            System.out.println(" Not Anagram");
    }    
    static boolean isAnagram(String s1, String s2)
        {
            s1=s1.toLowerCase();
            s2=s2.toLowerCase();
            if(s1.length()!=s2.length())
                return false;
            char[]a=s1.toCharArray();
            char[]b=s2.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            return Arrays.equals(a,b);
        }
        
}
