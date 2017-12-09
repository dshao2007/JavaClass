import java.io.*;
import java.lang.System.*;

import java.util.Scanner;
/*Enter the values for the first array, up to 10000 values, enter 'End' to quit
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
    String words1 []= new String [10000];
    String words2 []= new String [10000];

    readInWords(words1);
    // 
    readInWords(words2);

    System.out.println(words1[0] + ' ' + words1[1] + ' ' + words1[2]);
    System.out.println(words2[0] + ' ' + words2[1] + ' ' + words2[2]);
    // Need to merge two arrays
    
    for (int i = 0, j = 0; i < words1.length && j < words2.length; i++,j++) {
        if (words1[i] == null) {
            System.out.println("words1 i is null " + i);
            break;
        }
        
        if (words2[j] == null) {
            System.out.println("words2[j] is null " + j);
            break;
        }
        
        
        if (words1[i].compareTo(words2[j]) > 0) {
            System.out.print(words2[j] + "," + " " + words1[i]);
        }else if (words2[j].compareTo(words1[i]) > 0) {
            System.out.print(words1[i] + "," + " " + words2[j]);
        }
        
        
        
    }
    
  }
    
  public static void readInWords(String[] words) {
      
    Scanner scan = new Scanner(System.in);
    //initialize first array
    
    System.out.println("Enter a group of words.");

    //checks to see if user enters charcter "End"
    String upper;
    String correctCase;
 
    // AlIcer
    for (int i= 0; i < words.length; i++) {
        words[i] = scan.nextLine();
    
        if (words[i].toLowerCase().compareTo("end") != 0) {
            upper = words[i].substring(0, 1).toUpperCase();

            words[i] = upper + words[i].substring(1).toLowerCase();  // Alicer
            
            correctCase = upper + words[i].substring(1);
            System.out.println("new string == " + correctCase);
       
            if (i > 0) {
                int distance = words[i].compareTo(words[i-1]);
        
                if (distance <= 0) {
                    System.out.println("ERROR: Array not in correct order");
                    System.exit(1);
                }
            }   
        } else {
            break;
        }
    }
  }
}