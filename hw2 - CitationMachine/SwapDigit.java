
/**
 * Write a description of class SwapDigit here.
 * 
 * @author Zachary Swim, zswim@purdue.edu, section LC1  
 * @version 9/4/2016
 */

import java.util.*;
public class SwapDigit
{
    //main method, where inputted number is flipped
    //@param two digit number
    //returns swapped number
    public static void main (String []args)
    {
        //creates the scanner, allows for user input
        Scanner scan = new Scanner(System.in);
        
        //takes input for the two digit integer
        System.out.println("Enter number: ");
        int number = scan.nextInt();
        
        //converts integer to string and swaps digits
        String normal = "" + number;
        String flip = normal.substring(1,2) + normal.substring(0,1);
        
        //returns swapped number
        System.out.println("Swapped: " + flip);
    }
}
