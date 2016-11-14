import java.util.Scanner;

/**
 * Created by Zach on 11/11/2016.
 */
public class Pokemon {
    private static int NUM_POKEMONS =0;
    private int iD;
    private String name;
    private String type;
    private int healthPower;
    private double baseAttackPower;

    public Pokemon(String name, String type, int healthPower, double baseAttackPower) {
        iD = NUM_POKEMONS;
        this.name = name;
        this.type = MyUtils.formatStr(type);
        if (this.type.equals("Fire")||this.type.equals("Water")||this.type.equals("Grass")||this.type.equals("Electric")) {

        }
        else {
            this.type = "Fire";
        }

        this.healthPower = healthPower;
        if (healthPower < 0) {
            this.healthPower = 0;
        }

        this.baseAttackPower = baseAttackPower;
        if (baseAttackPower <= 0) {
            this.baseAttackPower = 1;
        }

        NUM_POKEMONS ++;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return iD;
    }

    public String getType() {
        return type;
    }

    public int getHealthPower() {
        return healthPower;
    }

    public double getBaseAttackPower() {
        return baseAttackPower;
    }

    public boolean setType(String type) {
        type = MyUtils.formatStr(type);
        if (type.equals("Fire")||type.equals("Water")||type.equals("Grass")||type.equals("Electric"))
        {
            this.type = type;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean setHealthPower(int healthPower) {
        if (healthPower < 0) {
            return false;
        }
        else {
            this.healthPower = healthPower;
            return true;
        }
    }

    public boolean setBaseAttackPower(double baseAttackPower) {
        if (baseAttackPower <= 0) {
            return false;
        }
        else {
            this.baseAttackPower = baseAttackPower;
            return true;
        }
    }

    public String toString() {
        return "Name: " + getName() +
                "\nID: " + getId() +
                "\nType: " + getType() +
                "\nHealth power: " + getHealthPower() +
                "\nBase attack power: " + getBaseAttackPower();
    }

    public boolean isDead() {
        if (healthPower > 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public void boostHealthPower(int healthPower) {
        this.healthPower += healthPower;
    }

    public void reduceHealthPower(int healthPower) {
        if (healthPower >= getHealthPower()) {
            this.healthPower = 0;
        }
        else {
            this.healthPower = getHealthPower() - healthPower;
        }
    }

    public static int battle(Pokemon p1, Pokemon p2) {
        double multi1 = getAttackMultiplier(p1, p2);
        double multi2 = getAttackMultiplier(p2, p1);

        while (p1.isDead() == false && p2.isDead() == false) {
            p1.reduceHealthPower((int)(p2.getBaseAttackPower()*multi2));
            p2.reduceHealthPower((int)(p1.getBaseAttackPower()*multi1));
        }

        if (p2.isDead()) {
            return 1;
        }
        else if (p1.isDead()) {
            return 2;
        }
        else {
            return 0;
        }
    }

    public static double getAttackMultiplier(Pokemon attacker, Pokemon defender) {
        if (attacker.getType().equals("Grass")) {
            if (defender.getType().equals("Grass")) {
                return .5;
            }
            else if (defender.getType().equals("Electric")) {
                return 1;
            }
            else if (defender.getType().equals("Water")) {
                return 2;
            }
            else {
                return .5;
            }
        }
        else if (attacker.getType().equals("Electric")) {
            if (defender.getType().equals("Grass")) {
                return .5;
            }
            else if (defender.getType().equals("Electric")) {
                return .5;
            }
            else if (defender.getType().equals("Water")) {
                return 2;
            }
            else {
                return 1;
            }
        }
        else if (attacker.getType().equals("Water")) {
            if (defender.getType().equals("Grass")) {
                return .5;
            }
            else if (defender.getType().equals("Electric")) {
                return 1;
            }
            else if (defender.getType().equals("Water")) {
                return .5;
            }
            else {
                return 2;
            }
        }
        else {
            if (defender.getType().equals("Grass")) {
                return 2;
            }
            else if (defender.getType().equals("Electric")) {
                return 1;
            }
            else if (defender.getType().equals("Water")) {
                return .5;
            }
            else {
                return .5;
            }
        }
    }

    public static int battleOracle(Pokemon p1, Pokemon p2) {
        double multi1 = getAttackMultiplier(p1, p2);
        double multi2 = getAttackMultiplier(p2, p1);

        int health1 = p1.getHealthPower();
        int health2 = p2.getHealthPower();

        while (health1 > 0 && health2 > 0) {
            health1 -= (int)(p2.getBaseAttackPower()*multi2);
            health2 -= (int)(p1.getBaseAttackPower()*multi1);
        }

        if (health1 > 0) {
            return 1;
        }
        else if (health2 > 0) {
            return 2;
        }
        else {
            return 0;
        }
    }

    public static void main(String []args) {
        Scanner scan = new Scanner(System.in);
        String n;
        String t;
        String line;
        int hp =0;
        double atk =0;
        boolean isNumeric = false;

        System.out.println("Enter the first Pokemon's Name: ");
        n = scan.nextLine();

        System.out.println("Enter the first Pokemon's Type: ");
        t = scan.nextLine();

        System.out.println("Enter the first Pokemon's Health Power (HP): ");
        while (isNumeric == false) {
            line = scan.nextLine();
            if (MyUtils.isNumeric(line)) {
                hp = (int)(Double.parseDouble(line));
                isNumeric = true;
            }
            else {
                System.out.println("Invalid health power (HP) entered. Please re-enter: ");
            }
        }
        isNumeric = false;

        System.out.println("Enter the first Pokemon's Base Attack Power: ");
        while (isNumeric == false) {
            line = scan.nextLine();
            if (MyUtils.isNumeric(line)) {
                atk = Double.parseDouble(line);
                isNumeric = true;
            }
            else {
                System.out.println("Invalid base attack power entered. Please re-enter: ");
            }
        }
        isNumeric = false;
        Pokemon p1 = new Pokemon (n, t, hp, atk);

        System.out.println("Enter the second Pokemon's Name: ");
        n = scan.nextLine();

        System.out.println("Enter the second Pokemon's Type: ");
        t = scan.nextLine();

        System.out.println("Enter the second Pokemon's Health Power (HP): ");
        while (isNumeric == false) {
            line = scan.nextLine();
            if (MyUtils.isNumeric(line)) {
                hp = (int)(Double.parseDouble(line));
                isNumeric = true;
            }
            else {
                System.out.println("Invalid health power (HP) entered. Please re-enter: ");
            }
        }
        isNumeric = false;

        System.out.println("Enter the second Pokemon's Base Attack Power: ");
        while (isNumeric == false) {
            line = scan.nextLine();
            if (MyUtils.isNumeric(line)) {
                atk = Double.parseDouble(line);
                isNumeric = true;
            }
            else {
                System.out.println("Invalid health power (HP) entered. Please re-enter: ");
            }
        }
        isNumeric = false;

        Pokemon p2 = new Pokemon (n, t, hp, atk);

        int winner = Pokemon.battle(p1, p2);

        System.out.println("First Pokemon's stats after the battle: ");
        System.out.println(p1.toString());
        System.out.println("");

        System.out.println("Second Pokemon's stats after the battle: ");
        System.out.println(p2.toString());
        System.out.println("");

        if (winner == 1) {
            System.out.println("The winner of the battle is " + p1.getName());
        }
        else if (winner == 2) {
            System.out.println("The winner of the battle is " + p2.getName());
        }
        else {
            System.out.println("Draw");
        }

    }
}
