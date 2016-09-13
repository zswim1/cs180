
/**
 * Write a description of class Notecard here.
 * 
 * @author Zachary Swim, zswim@purdue.edu, section LC1
 * @version 8/29/2016
 */
//imports the tools necessary to run the program
import java.util.*;
import javax.swing.*;

public class BusinessCard
{
    public static void main (String []args)
    {
        //asks the user 3 questions to determing name, major, and email
        String s = JOptionPane.showInputDialog("Enter your name: ");
        String t = JOptionPane.showInputDialog("Enter your major: ");
        String u = JOptionPane.showInputDialog("Enter your e-mail: ");
        
        //returns the inputted values in the format of a Buisness card
        JOptionPane.showMessageDialog(null, "Name: " + s + "\n Major: " + t + "\n E-mail: " + u);
    }
}
