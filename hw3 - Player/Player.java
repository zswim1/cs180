
/**
 * Creates a player that is changeable by methods
 * 
 * @author Zachary Swim, zswim@purdue.edu, section LC1
 * 
 * @version 9/13/2016
 */

public class Player
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;
    private String name;

    /**
     * Constructor for objects of class Player
     */
    public Player(double x, double y, String name)
    {
        // initialise instance variables
        this.x = x;
        this.y = y;
        this.name = name;
    }
    
    public Player(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
    }

    /**
     * gets the players name
     * 
     * @return  the players name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * gets the players x-position
     * 
     * @return  x-position
     */
    public double getPositionX()
    {
        return x;
    }
    
    /**
     * gets the players y-position
     * 
     * @return  y-position
     */
    public double getPositionY()
    {
        return y;
    }
    
    /**
     * changes the players name
     * 
     * @param name in string form
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * moves the players x-position
     * 
     * @param amnt to move x by
     */
    public void moveX(double offsetX)
    {
        x += offsetX;
    }
    
    /**
     * moves the players y-position
     * 
     * @param amnt to move y by
     */
    public void moveY(double offsetY)
    {
        y += offsetY;
    }
    
    /**
     * moves the players position depending on input
     * 
     * @param angle and distance to move at
     */
    public void moveInDirection(double theta, double distance)
    {
        double radians = theta*Math.PI /180;
        x += distance*Math.cos(radians);
        y += distance*Math.sin(radians);
    }
    
    /**
     * checks if two players are in the same position
     * 
     * @param player to compare to
     * @return true/false if in the same place
     */
    public boolean hasSamePositionAs(Player player)
    {
        double pX = player.getPositionX();
        double pY = player.getPositionY();
        
        double distX = Math.pow(x-pX, 2);
        double distY = Math.pow(y-pY, 2);
        
        return .001 > Math.sqrt(distX + distY);
    }
    
    /**
     * calculates the distance between two players
     * 
     * @param player to calculate from
     * @return distance between players
     */
    public double distanceFrom(Player player)
    {
        double pX = player.getPositionX();
        double pY = player.getPositionY();
        
        double distX = Math.pow(x-pX, 2);
        double distY = Math.pow(y-pY, 2);
        
        return Math.sqrt(distX + distY);
    }
    
}
