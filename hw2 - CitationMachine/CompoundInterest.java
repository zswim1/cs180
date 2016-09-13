
/**
 * Write a description of class CompoundInterest here.
 * 
 * @author Zachary Swim, zswim@purdue.edu, section LC1 
 * 
 * @version 9/4/2016
 */

import java.util.*;
public class CompoundInterest
{
    
    //determines compound interest gained over time
    //@param principal, rate, and years
    //returns interest gained
    public static void main (String []args)
    {
        //imports the scanner class to recieve user input
        Scanner scan = new Scanner(System.in);
        
        //gathers input on principal amount
        System.out.println("Enter Principle: ");
        int principal = scan.nextInt();
        
        //gathers input on interest rate
        System.out.println("Enter interest rate: ");
        int iRate = scan.nextInt();
        
        //gathers input on length of time
        System.out.println("Enter years: ");
        int years = scan.nextInt();
        
        //calculates and returns interest gained
        int total = (int)(principal*Math.pow((1+iRate/100.0),(double)years));
        int interest = total - principal;
        System.out.println("Interest = " + interest);
    }
}
