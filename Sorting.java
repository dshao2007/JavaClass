import java.io.*;
import java.lang.System.*;

import java.util.Scanner;
/*

Enter the values for the first array, up to 10000 values, enter 'End' to quit
Alf
BOB
heATher
john
ZoE
eNd

Enter the values for the second array, up to 10000 values, enter 'End' to quit
Chloe
dylan
michAEL
END

First Array
Alf Bob Heather John Zoe

Second Array
Chloe Dylan Michael

Merged Array
Alf Bob Chloe Dylan Heather John Michael Zoe

*/
public class Assignment6 {

  public static void main (String args[]) {
      
    Scanner scan = new Scanner(System.in);
      
    String words1 []= new String [10000];
    String words2 []= new String [10000];
    
    boolean firstArrayOutOfOrder = false;
    boolean secondArrayOutOfOrder = false;
    
    System.out.println("Enter the values for the first array, up to 10000 values, enter 'End' to quit");

    //checks to see if user enters charcter "End"
    String upper;
 
    int arrayLength1, arrayLength2;
 
    arrayLength1 = 0;
    arrayLength2 = 0;
 
    // Read in the first array, up to 10000 values.
    for (int i= 0; i < words1.length; i++) {
        words1[i] = scan.nextLine();
    
        if (words1[i].toLowerCase().compareTo("end") != 0) {
            upper = words1[i].substring(0, 1).toUpperCase();

            words1[i] = upper + words1[i].substring(1).toLowerCase();
            
            // keep track of the real size of the user input.
            arrayLength1++;
       
            if (i > 0) {
                int distance = words1[i].compareTo(words1[i-1]);
                if (distance <= 0) {
                    // The input words are out of alphabetical order
                    firstArrayOutOfOrder = true;
                }
            }  
        } else {
            break;
        }
    }
    System.out.println("Enter the values for the second array, up to 10000 values, enter 'End' to quit");
    for (int i= 0; i < words2.length; i++) {
        words2[i] = scan.nextLine();
    
        if (words2[i].toLowerCase().compareTo("end") != 0) {
            upper = words2[i].substring(0, 1).toUpperCase();

            words2[i] = upper + words2[i].substring(1).toLowerCase();  // Alicer
            
            arrayLength2++;
            if (i > 0) {
                int distance = words2[i].compareTo(words2[i-1]);
                if (distance <= 0) {
                    secondArrayOutOfOrder = true;
                }
            }   
        } else {
            break;
        }
    }
    
    System.out.println("First Array");
    for (int i=0; i < arrayLength1; i++) {
        System.out.print(words1[i] + " ");
    }
    System.out.println("\n");

    System.out.println("Second Array");
    for (int i=0; i<arrayLength2; i++) {
        System.out.print(words2[i] + " ");
    }
    System.out.println("\n");
    
    if (firstArrayOutOfOrder || secondArrayOutOfOrder) {
      System.out.println("Error: Arrays not in correct order");
      System.exit(1);
    }

    // Merged array has this length
    int totalLength = arrayLength1 + arrayLength2;

    String[] words3 = new String[totalLength];

    // Compare two arrays from starting positions and put
    // the smaller values into the merged array in alphabetical order. 
    int position1 = 0;
    int position2 = 0;
    
    for (int i = 0; i < totalLength; i++) {
        if (words1[position1].compareTo(words2[position2]) > 0) {
             // Take the word from the second array.
          words3[i] = words2[position2];
          position2++;
        
          if (position2 == arrayLength2) {
            //copy over remaining first array into remaining third arrray
            for (int j = position1; j < arrayLength1; j++) {
              i++;
              words3[i] = words1[j];
            }
            break;  
          }
        } else {
            // Take the word from the first array.
          words3[i] = words1[position1];
          position1++;
          if (position1 == arrayLength1){
             // copy the remaining of array2 to remaining of array3
              for (int j = position2; j < arrayLength2; j++) {
              i++;
              words3[i] = words2[j];
            }
          }
        }
    }

    System.out.println("Merged Array");
    for (int i =0; i < totalLength; i++) {
        System.out.print(words3[i] + " ");
    }
    System.out.println("\n");

 }

}
      
    
    
