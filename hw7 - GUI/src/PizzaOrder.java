/**
 * Created by Zach on 10/26/2016.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PizzaOrder extends JFrame {

    private JTextArea result= new JTextArea();

    public PizzaOrder(){
        BorderLayout layout = new BorderLayout();

        JRadioButton small = new JRadioButton("Small");
        JRadioButton medium = new JRadioButton("Medium");
        JRadioButton large = new JRadioButton("Large");

        String[] choices = {"Margherita", "Prosciutto", "Diavola",
                "Verdure", "Calzone"};
        JComboBox<String> styles= new JComboBox<>(choices);

        JCheckBox garlic = new JCheckBox("Garlic");
        JCheckBox peppers = new JCheckBox("Jalapenos");
        JCheckBox cheese = new JCheckBox("Extra Cheese");
        JCheckBox bacon = new JCheckBox("Bacon");

        JButton submit = new JButton("Submit");

        result.setRows(16);
        result.setColumns(20);

        JPanel leftN = new JPanel();
        JPanel leftC = new JPanel();
        JPanel leftS = new JPanel();
        //leftN.setLayout(layout);
        //leftC.setLayout(layout);
        //leftS.setLayout(layout);
        leftN.setBorder(BorderFactory.createTitledBorder("Select your pizza size"));
        leftC.setBorder(BorderFactory.createTitledBorder("Select your pizza style"));
        leftS.setBorder(BorderFactory.createTitledBorder("Choose your toppings"));

        leftN.add(small);
        leftN.add(medium);
        leftN.add(large);

        leftC.add(styles);

        leftS.add(garlic);
        leftS.add(peppers);
        leftS.add(cheese);
        leftS.add(bacon);

        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel south = new JPanel();
        BoxLayout bLayout = new BoxLayout(left, BoxLayout.Y_AXIS);
        left.setLayout(bLayout);
        //right.setLayout(layout);
        //south.setLayout(layout);
        left.setBorder(BorderFactory.createTitledBorder("Options"));
        right.setBorder(BorderFactory.createTitledBorder("Output"));


        left.add(leftN);
        left.add(leftC);
        left.add(leftS);

        right.add(result, BorderLayout.PAGE_START);

        south.add(submit);

        JFrame frame = new JFrame("Pizza Shop");
        frame.setLayout(layout);

        frame.add(left, BorderLayout.LINE_START);
        frame.add(right, BorderLayout.LINE_END);
        frame.add(south, BorderLayout.PAGE_END);

        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(600,358));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        small.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (small.isSelected()){
                    medium.setSelected(false);
                    large.setSelected(false);
                }
            }
        });
        medium.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (medium.isSelected()){
                    small.setSelected(false);
                    large.setSelected(false);
                }
            }
        });
        large.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (large.isSelected()){
                    small.setSelected(false);
                    medium.setSelected(false);
                }
            }
        });

        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String a = "Your custom pizza";
                String size;
                if (small.isSelected()){
                    size = "Small";
                }
                else if (medium.isSelected()){
                    size = "Medium";
                }
                else if (large.isSelected()){
                    size = "Large";
                }
                else{
                    size = "Small";

                }
                String toppings = "";
                int numToppings = 0;
                if (garlic.isSelected()) {
                    toppings += "Garlic";
                    numToppings ++;
                }
                if (peppers.isSelected()){
                    if (numToppings >= 1){
                        toppings += ", ";
                    }
                    toppings += "Jalapenos";
                    numToppings ++;
                }
                if (cheese.isSelected()){
                    if (numToppings >= 1){
                        toppings += ", ";
                    }
                    toppings += "Extra Cheese";
                    numToppings ++;
                }
                if (bacon.isSelected()){
                    if (numToppings >= 1){
                        toppings += ", ";
                    }
                    toppings += "Bacon";
                    numToppings ++;
                }
                String b = "Size: " + size;
                String c = "Style: " + styles.getSelectedItem().toString();
                String d = "Toppings: " + toppings;
                result.setText(a + "\n" + b + "\n" + c + "\n" + d);
            }
        });
    }

    public static void main (String [] args){
        new PizzaOrder();
    }
}
