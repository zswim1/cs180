
/**
 * Write a description of class EuroConverter here.
 * 
 * @author Zachary Swim, zswim@purdue.edu, section LC1 
 * 
 * @version 9/4/2016
 */

import java.util.*;
public class EuroConverter
{
    //main method, converts an amount of US dollars to Euros
    //@param USD amount, conversion rate
    //returns converted euro amount
    public static void main (String []args)
    {
        //imports the scanner class used to recieve user input
        Scanner scan = new Scanner(System.in);
        
        //collects the number of USD
        System.out.println("Enter amount in USD: ");
        int uSD = scan.nextInt();
        
        //collects the conversion rate from USD to Euro
        System.out.println("Enter number of $ in 100 Euro: ");
        int convRate = scan.nextInt();
        
        //calculates and returns number of euros
        double euro = uSD * (100.0/convRate);
        System.out.println("Number of euros = " + euro);
    }
}
