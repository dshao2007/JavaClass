import java.io.*;
import java.util.Scanner;
import java.lang.Math.*;

public class Guess {
    
    public static void main (String [] args) {
      Scanner scan = new Scanner (System.in);
      int randomNumber = (int) (Math.random() * 100) + 1;
      System.out.println("Enter a random number between 0-100");
      int userGuess = scan.nextInt();
      int counter = 1;
      
      while (userGuess != randomNumber) {
        if (userGuess < randomNumber) {
          System.out.println("Sorry, your number is too small. Please enter a new number");
        } else {
          System.out.println("Sorry, your number is too big, please enter another one.");
        } 
        userGuess = scan.nextInt();
        counter ++;
      }
      System.out.println("You have guessed the correct number which is " + randomNumber + " " + counter + " times");
    }
}