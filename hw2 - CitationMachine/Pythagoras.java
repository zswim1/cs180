
/**
 * Calculates the length of the hypotenuse given two legs
 * 
 * @author Zachary Swim, zswim@purdue.edu, section LC1  
 * 
 * @version 9/4/2016
 */

import java.util.*;

public class Pythagoras
{
    //main method, calculates third side given two legs
    //@param leg1, leg2
    //returns hypotenuse
    public static void main (String []args)
    {
        //imports the scanner class, allows user input
        Scanner scan = new Scanner(System.in);
        
        //takes input for first leg
        System.out.println("Enter a: ");
        int a = scan.nextInt();
        
        //takes input for second leg
        System.out.println("Enter b: ");
        int b = scan.nextInt();
        
        //calculates and returns length of hypotenuse
        double hypot = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
        System.out.println("Hypotenuse = " + hypot);
    }
}
