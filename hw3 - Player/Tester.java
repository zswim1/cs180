
/**
 * Tests the player class
 * 
 * @author Zachary Swim, zswim@purdue.edu, section LC1
 * 
 * @version 9/13/2016
 */

import java.util.*;
public class Tester
{
    //tests the method written in the Player class
    //@param two players with name, x, and y paramaters
    public static void main (String []args)
    {
        Scanner scan = new Scanner(System.in);
        
        //determines the first players characteristics
        System.out.println("Enter player1 name: ");
        String pName = scan.nextLine();        
        System.out.println("Enter player1 x-position: ");
        double x = scan.nextDouble();        
        System.out.println("Enter player1 y-position: ");
        double y = scan.nextDouble();
        
        //determines the second players characteristics
        System.out.println("Enter player2 name: ");
        String p2Name = scan.nextLine();
        p2Name = scan.nextLine();
        System.out.println("Enter player2 x-position: ");
        double x2 = scan.nextDouble();        
        System.out.println("Enter player2 y-position: ");
        double y2 = scan.nextDouble();
        
        //assigns p1 and p2 values to player objects named "Alice" and "Bob"
        Player Alice = new Player(x, y, pName);        
        Player Bob = new Player(x2, y2, p2Name);
        
        //returns their initial positions
        System.out.println(Alice.getName() + ", " + Alice.getPositionX() + ", " + Alice.getPositionY());
        System.out.println(Bob.getName() + ", " + Bob.getPositionX() + ", " +Bob.getPositionY());
        
        //Moves Alice in X, y, and Diagonal directions
        System.out.println("Enter Alice's horizontal move: ");
        Alice.moveX(scan.nextDouble());        
        System.out.println("Enter Alice's vertical move: ");
        Alice.moveY(scan.nextDouble());
        
        System.out.println("Enter Alice's diagonal move angle: ");
        double thetaA = scan.nextDouble();       
        System.out.println("Enter Alice's diagonal move distance: ");
        Alice.moveInDirection(thetaA, scan.nextDouble());
        
        //Moves Bob in x, y, and diagonal directions
        System.out.println("Enter Bob's horizontal move: ");
        Bob.moveX(scan.nextDouble());        
        System.out.println("Enter Bob's vertical move: ");
        Bob.moveY(scan.nextDouble());
        
        System.out.println("Enter Bob's diagonal move angle: ");
        double thetaB = scan.nextDouble();       
        System.out.println("Enter Bob's diagonal move distance: ");
        Bob.moveInDirection(thetaB, scan.nextDouble());
        
        //returns the updated positions of Bob + Alice
        System.out.println(Alice.getName() + ", " + Alice.getPositionX() + ", " + Alice.getPositionY());
        System.out.println(Bob.getName() + Bob.getPositionX() + Bob.getPositionY());
        
        //returns whether they are in the same position and the distance between them
        System.out.println(Alice.hasSamePositionAs(Bob));
        System.out.println(Alice.distanceFrom(Bob));
    }
}
