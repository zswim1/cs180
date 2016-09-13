
/**
 * Forms a book citation from inputted details
 * 
 * @author Zachary Swim, zswim@purdue.edu, section LC1
 * 
 * @version 9/4/2016
 */

import javax.swing.*;
public class CitationMachine
{
   //main method, where the citation is created
   //@param Author, year, title, publisher, and location
   //output a formatted citation
   public static void main (String []args)
   {
       //outputs directions
       JOptionPane.showMessageDialog(null, "Enter book details to generate APA format citation.");
       
       //accepts all the input to create a citation
       String Auth = JOptionPane.showInputDialog("Enter author's name");
       String year = JOptionPane.showInputDialog("Enter the book's year of publication");
       String title = JOptionPane.showInputDialog("Enter the title of the piece");
       String publish = JOptionPane.showInputDialog("Enter the publisher");
       String locat = JOptionPane.showInputDialog("Enter the location");
       
       //formats author string
       int space = Auth.indexOf(" ");
       String AuthFormat = (Auth.substring(space+1, Auth.length()) + ", " + Auth.substring(0,1) + ".");
       
       JOptionPane.showMessageDialog(null, AuthFormat + "(" + year + "). " + title + ". " + locat + ": " + publish + ".");  
    }
}
