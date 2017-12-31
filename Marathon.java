import java.io.*;

import java.lang.System.*;

public class Marathon {
/*Write a method that takes as input an array of integers and returns 
the index corresponding to the person with the lowest
time. Run this method on the array of times. 
Print out the name and time corresponding to the returned index.
*/

    private static int findIndex (int [] values) {
          
        int leastTime = values[0];
        int i = 0;
        int winner = 0;
        
        for (i = 0; i < values.length; i++) {
            if (values[i] < leastTime) {
              leastTime = values[i];
              winner = i;
            }
        }
        return winner;
    }
    
    private static int findSecondIndex (int [] values) {
        
        int leastTime = 999;
        int i = 0;
        int winner = 0;
        int least2 = 999;
        int winner2 = 0;
        for (i = 0; i < values.length; i++) {
            if (values[i] < leastTime) {
                leastTime = values[i];
                winner = i;
            } 
        }
        for (i = 0; i < values.length; i++) {
            if (i != winner && values[i] < least2) {
              least2 = values [i];
              winner2 = i;   
            }
        }
        return winner2;
        // winner is the index of the least time. 
           
    }
        
    
    public static void main (String[] arguments) {
        String[] names = {
          "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
          "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
          "Aaron", "Kate"
        };

        int[] times = {
            113, 273, 278, 127, 445, 402, 388, 127, 243, 334, 412, 393, 299,
            343, 317, 265
        };

        /*for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + times[i]);
        }
        */
        
        
      
    
        int index = findIndex(times);
        System.out.println(names[index] + " " + times[index]); 
        
        int index2 = findSecondIndex(times);
        System.out.println(names[index2] + " " + times[index2]);
    }
}
        
    
