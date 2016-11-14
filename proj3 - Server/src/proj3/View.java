package proj3;

/**
 * Created by Zach on 10/30/2016.
 */

/**
 * Created by Zach on 10/30/2016.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static java.awt.SystemColor.control;

public class View extends JFrame {
//Put in stuff up until game/rounds actually start - suggestions/Launch game

    private String name="";
    private String pass="";
    private char [] temp;
    private ArrayList<String> joined = new ArrayList<String>();
    private JTextArea participants = new JTextArea("");
    private String code = "";
    private Controller control;
    private String tempPW = "";
    private String userCode = "";
    private String gameCode = "";
    private boolean players = false;
    private ArrayList<String> playerList;
    private boolean correctCode = false;
    private boolean startGame = false;
    private ArrayList<Model> playerSet = new ArrayList<Model>();
    private Timer t;
    private boolean refresh = false;
    Model m;
    private boolean joingame = false;
    private boolean roundReady = false;
    private String ps = "";
    private String word = "";
    private String options = "";
    private String option1 = "";
    private String option2 = "";
    private String option3 = "";
    private String results = "";
    private String namep1 = "";
    private String messagep1 = "";
    private String scorep1 = "";
    private String foolerp1 = "";
    private String fooledp1 = "";
    private String namep2 = "";
    private String messagep2 = "";
    private String scorep2 = "";
    private String foolerp2 = "";
    private String fooledp2 = "";


    public void setToken(String t){
        gameCode = t;
    }

    public void playerJoin(Model e){
        playerSet.add(e);
    }

    public View(int i){

    }

    public View() throws IOException {
        control = new Controller();
        login();
    }

    public void login(){
        //creates the JFrame used for the page
        JFrame frame = new JFrame("FoilMaker");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        //sets the layout for the frame and some panels
        BorderLayout layout = new BorderLayout();
        frame.setLayout(layout);

        //north portion of page
        JPanel panelN = new JPanel();
        frame.add(panelN, BorderLayout.PAGE_START);
        panelN.setPreferredSize(new Dimension(300,100));
        //creates components for northern panel
        JLabel labelN1 = new JLabel("FoilMaker!");
        //adds components to northern portion of page
        panelN.add(labelN1);

        //central portion of page
        JPanel panelC = new JPanel();
        frame.add(panelC, BorderLayout.CENTER);
        panelC.setPreferredSize(new Dimension(300,200));
        //subpanels (north and south portions of central)
        JPanel panelCN = new JPanel();
        JPanel panelCS = new JPanel();
        panelC.add(panelCN, BorderLayout.PAGE_START);
        panelC.add(panelCS, BorderLayout.PAGE_END);
        //creates components for panels
        JLabel labelC1 = new JLabel("Username");
        JLabel labelC2 = new JLabel("Password");
        JTextField textC1 = new JTextField();
        JPasswordField textC2 = new JPasswordField();
        textC1.setPreferredSize(new Dimension(100,18));
        textC2.setPreferredSize(new Dimension(100,18));
        //adds components to panels
        panelCN.add(labelC1);
        panelCN.add(textC1);
        panelCS.add(labelC2);
        panelCS.add(textC2);

        //southern portion of page
        JPanel panelS = new JPanel();
        frame.add(panelS, BorderLayout.PAGE_END);
        panelS.setPreferredSize(new Dimension(300,80));
        //creates components for panels
        JButton buttonS1 = new JButton("Login");
        JButton buttonS2 = new JButton ("Register");
        buttonS1.setPreferredSize(new Dimension(100,18));
        buttonS2.setPreferredSize(new Dimension(100,18));
        //adds components to panels
        panelS.add(buttonS1);
        panelS.add(buttonS2);
        buttonS1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pass = "";
                name = textC1.getText();
                temp = textC2.getPassword();

                for (int i = 0; i<temp.length;i++){
                    tempPW += String.valueOf(temp[i]);
                }
                boolean moveOn = false;
                try {
                    userCode = control.cLogin(name, tempPW);
                    moveOn = true;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }catch(FoilException e2){
                    JOptionPane.showMessageDialog(null,e2.getMessage());
                }
                if(moveOn) {
                    m = new Model(name, pass, userCode);
                    playerJoin(m);
                    frame.dispose();
                    newOrJoin();
                }
                tempPW = "";
            }
        });

        buttonS2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pass = "";
                name = textC1.getText();
                temp = textC2.getPassword();
                for (int i = 0; i<temp.length;i++){
                    pass += String.valueOf(temp[i]);
                }
                try {
                    control.cRegister(name, pass);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (FoilException e2){
                    JOptionPane.showMessageDialog(null, e2.getMessage(), "error", 1);
                }
            }
        });
        //puts together frame
        frame.pack();

    }

    public String getName(){
        return name;
    }

    public void newOrJoin(){
        //creates the JFrame used for the page
        JFrame frame = new JFrame("FoilMaker");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        //sets the layout for the frame and some panels
        BorderLayout layout = new BorderLayout();
        frame.setLayout(layout);

        //north portion of page
        JPanel panelN = new JPanel();
        frame.add(panelN, BorderLayout.PAGE_START);
        panelN.setPreferredSize(new Dimension(300,100));
        //creates components for northern panel
        JLabel labelN1 = new JLabel(getName());
        //adds components to northern portion of page
        panelN.add(labelN1);

        //central portion of page
        JPanel panelC = new JPanel();
        frame.add(panelC, BorderLayout.CENTER);
        panelC.setPreferredSize(new Dimension(300,200));
        //subpanels (north and south portions of central)
        JPanel panelCN = new JPanel();
        JPanel panelCS = new JPanel();
        panelC.add(panelCN, BorderLayout.PAGE_START);
        panelC.add(panelCS, BorderLayout.PAGE_END);

        //southern portion of page
        JPanel panelS = new JPanel();
        frame.add(panelS, BorderLayout.PAGE_END);
        panelS.setPreferredSize(new Dimension(300,80));
        //creates components for panels
        JButton buttonS1 = new JButton("Start New Game");
        JButton buttonS2 = new JButton ("Join a Game");
        buttonS1.setPreferredSize(new Dimension(120,18));
        buttonS2.setPreferredSize(new Dimension(120,18));
        //adds components to panels
        panelCS.add(buttonS1);

        panelCS.add(buttonS2);
        buttonS1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    gameCode = control.cStartNew();
                    JOptionPane.showMessageDialog(null, "Code: " + gameCode, "Code", JOptionPane.INFORMATION_MESSAGE);

                    ps += control.hasNew() + "\n";
                    if (ps.length() >0) {
                        frame.dispose();
                        startNew();
                    }


                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (FoilException e2){
                    JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", 1);
                }
            }
        });
        buttonS2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                joinGame();
            }
        });
        //puts together frame
        frame.pack();
    }

    public void startNew(){

        //creates the JFrame used for the page
        JFrame frame = new JFrame("FoilMaker");
        //frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        //sets the layout for the frame and some panels
        BorderLayout layout = new BorderLayout();
        frame.setLayout(layout);

        //north portion of page
        JPanel panelN = new JPanel();
        frame.add(panelN, BorderLayout.PAGE_START);
        panelN.setPreferredSize(new Dimension(300,100));
        //creates components for northern panel
        JLabel labelN1 = new JLabel(getName());
        //adds components to northern portion of page
        panelN.add(labelN1);

        //central portion of page
        JPanel panelC = new JPanel();
        frame.add(panelC, BorderLayout.CENTER);
        panelC.setPreferredSize(new Dimension(300,80));
        //subpanels (north and south portions of central)
        //creates components for panels
        JLabel labelC1 = new JLabel("Others Should use this key to join your game:   ");
        code = gameCode;

        JLabel textC1 = new JLabel();
        textC1.setText(code);
        textC1.setPreferredSize(new Dimension(100,18));
        //adds components to panels
        panelC.add(labelC1, BorderLayout.PAGE_START);
        panelC.add(textC1, BorderLayout.PAGE_END);


        //southern portion of page
        JPanel panelS = new JPanel();
        frame.add(panelS, BorderLayout.PAGE_END);
        panelS.setPreferredSize(new Dimension(300,300));

        //creates components for panels
        JButton buttonS1 = new JButton("Start Game");
        buttonS1.setPreferredSize(new Dimension(120,18));

        participants.setBorder(BorderFactory.createTitledBorder("Participants"));
        participants.setEditable(false);
        participants.setBackground(Color.orange);
        participants.setRows(7);
        participants.setColumns(18);
        String text = "";
        participants.setText(ps);
        //participants.setText(text);
        //adds components to panels
        panelS.add(participants, BorderLayout.PAGE_END);
        panelS.add(buttonS1, BorderLayout.PAGE_START);
        //panelS.add(buttonS2);
        buttonS1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {

                    String fromServ = control.cLaunch();
                    int index = fromServ.indexOf("?");
                    word = fromServ.substring(0,index);
                    option1 = fromServ.substring(index+1);
                    frame.dispose();
                    suggestions();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


                String text2 = "";
                for (int i =1; i< playerSet.size();i++){
                    text2 += playerSet.get(i).getName() + "\n";
                }
                participants.setText(text2);
            }
        });
        //puts together frame

        frame.pack();
    }

    public void joinGame(){
        String topic= "";
        //creates the JFrame used for the page
        JFrame frame = new JFrame("FoilMaker");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        //sets the layout for the frame and some panels
        BorderLayout layout = new BorderLayout();
        frame.setLayout(layout);

        //north portion of page
        JPanel panelN = new JPanel();
        frame.add(panelN, BorderLayout.PAGE_START);
        panelN.setPreferredSize(new Dimension(300,150));
        //creates components for northern panel
        JLabel labelN1 = new JLabel(getName());
        //adds components to northern portion of page
        panelN.add(labelN1);
        panelN.add(labelN1, BorderLayout.SOUTH);

        //central portion of page
        JPanel panelC = new JPanel();
        frame.add(panelC, BorderLayout.CENTER);
        panelC.setPreferredSize(new Dimension(300,70));
        //subpanels (north and south portions of central)
        JPanel panelCN = new JPanel();
        JPanel panelCS = new JPanel();
        //creates components for panels
        JLabel labelC1 = new JLabel("Enter game key to join active game");
        JTextField textC1 = new JTextField();
        textC1.setPreferredSize(new Dimension(100,18));
        //adds components to panels
        panelCN.add(labelC1);
        panelCS.add(textC1);
        panelC.add(panelCN, BorderLayout.PAGE_START);
        panelC.add(panelCS, BorderLayout.PAGE_END);


        //southern portion of page
        JPanel panelS = new JPanel();
        frame.add(panelS, BorderLayout.PAGE_END);
        panelS.setPreferredSize(new Dimension(300,200));
        JPanel panelSN = new JPanel();
        JPanel panelSS = new JPanel();
        panelSN.setPreferredSize(new Dimension(200,80));
        panelSS.setPreferredSize(new Dimension(100,80));
        //creates components for panels
        JButton buttonS1 = new JButton("Join Game");

        buttonS1.setPreferredSize(new Dimension(120,18));

        //adds components to panels
        panelS.add(buttonS1);
        buttonS1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    gameCode = textC1.getText();
                    correctCode = control.cJoin(gameCode);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }catch(FoilException e1){
                    JOptionPane.showMessageDialog(null,e1.getMessage().toString());
                }
                if (correctCode) {
                    joingame = true;
                    m.setJoined(true);
                    frame.dispose();
                    joined.add(getName());

                    String participate = "";
                    for (int i = 0; i < joined.size(); i++) {
                        participate += (joined.get(i) + "\n");
                    }
                    participants.setText(participate);
                    waiting();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error: Incorrect code", "Code error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //puts together frame
        frame.pack();
    }

    public void waiting(){
        //creates the JFrame used for the page
        JFrame frame = new JFrame("FoilMaker");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        //sets the layout for the frame and some panels
        BorderLayout layout = new BorderLayout();
        frame.setLayout(layout);

        JLabel label = new JLabel(getName());
        //frame.add(label, BorderLayout.BEFORE_FIRST_LINE);
        JLabel label2 = new JLabel("Waiting for leader.....");

        JPanel top = new JPanel();
        top.setPreferredSize(new Dimension(300,150));
        top.add(label);
        JPanel middle = new JPanel();
        middle.setPreferredSize(new Dimension(300,200));
        middle.add(label2);
        frame.add(top, BorderLayout.PAGE_START);
        frame.add(middle, BorderLayout.CENTER);

        frame.pack();

        t = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String fromServ = "";
                    fromServ = control.roundReady();
                    int index = fromServ.indexOf("?");
                    word = fromServ.substring(0,index);
                    //option1 = fromServ.substring(index+1);
                    roundReady = true;
                    frame.dispose();
                    suggestions();
                    t.stop();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        if (word.length() > 0){
            t.stop();

        }
        else {
            t.setRepeats(true);
            t.setDelay(500);
            t.start();
        }

    }

    public void suggestions(){
        //creates the JFrame used for the page
        JFrame frame = new JFrame("FoilMaker");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(300,500));

        //sets the layout for the frame and some panels
        BorderLayout layout = new BorderLayout();
        frame.setLayout(layout);

        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();

        //northern portion of frame
        north.add(new JLabel(getName()));
        north.setPreferredSize(new Dimension(300,20));
        frame.add(north, BorderLayout.PAGE_START);

        //central portion of frame
        JPanel cenNN = new JPanel();
        JPanel cenN = new JPanel();
        JPanel cenS = new JPanel();
        cenNN.setPreferredSize(new Dimension(300,20));
        cenN.setPreferredSize(new Dimension(300,150));
        cenN.setBorder(BorderFactory.createLineBorder(Color.gray));
        cenN.setBackground(Color.yellow);
        cenS.setPreferredSize(new Dimension(300,150));
        cenS.setBorder(BorderFactory.createTitledBorder("Your Suggestion"));
        //create content for subpanels
        JLabel display = new JLabel(word);
        display.setAlignmentX(Component.LEFT_ALIGNMENT);
        display.setPreferredSize(new Dimension(100,18));
        cenN.add(display);
        JTextArea input = new JTextArea();
        input.setPreferredSize(new Dimension(150,20));
        cenS.add(input);
        JLabel question = new JLabel("What is the word for");
        question.setAlignmentX(Component.LEFT_ALIGNMENT);
        cenNN.add(question);
        center.add(cenNN, BorderLayout.PAGE_START);
        center.add(cenN, BorderLayout.CENTER);
        center.add(cenS, BorderLayout.PAGE_END);
        frame.add(center, BorderLayout.CENTER);

        //southern portion of frame
        JButton submit = new JButton("Submit Suggestion");
        submit.setPreferredSize(new Dimension(150,18));
        south.setPreferredSize(new Dimension(300,60));
        south.add(submit, BorderLayout.CENTER);
        frame.add(south, BorderLayout.PAGE_END);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    options = control.cSuggestion(input.getText(), gameCode);
                    int index = options.indexOf("-");

                    if (options.length() > 0 && index >= 0) {
                        option1 = options.substring(0,index);
                        options = options.substring(index + 2);
                        index = options.indexOf("-");
                        option2 = options.substring(0,index);
                        option3 = options.substring(index+2);
                        frame.dispose();
                        choose();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (FoilException e1) {
                    e1.getMessage();
                }

            }
        });
        //puts together frame
        frame.pack();
    }

    public void choose(){
        String topic= "";
        //creates the JFrame used for the page
        JFrame frame = new JFrame("FoilMaker");
        frame.setPreferredSize(new Dimension(300,500));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JPanel south =  new JPanel();

        //northern portion of frame
        north.add(new JLabel(getName()));
        north.setPreferredSize(new Dimension(300,20));
        frame.add(north, BorderLayout.PAGE_START);

        //central portion of page
        JPanel cN = new JPanel();
        JPanel cC = new JPanel();
        BoxLayout layout = new BoxLayout(cC, BoxLayout.Y_AXIS);
        cC.setLayout(layout);

        JPanel cS = new JPanel();
        cN.setPreferredSize(new Dimension(300,100));
        cC.setPreferredSize(new Dimension(300,150));
        cS.setPreferredSize(new Dimension(300,50));

        JRadioButton choice1 = new JRadioButton("word1");
        JRadioButton choice2 = new JRadioButton("word2");
        JRadioButton choice3 = new JRadioButton("word3");
        JLabel pickOption = new JLabel("Pick your option below");
        if (option1.length() > 1 && option2.length() > 1 && option3.length() > 1) {
            choice1.setText(option1);
            choice2.setText(option2);
            choice3.setText(option3);
        }
        JButton submit = new JButton("Submit Option");

        cN.add(pickOption);
        cC.add(choice1);
        choice1.setSelected(true);
        choice1.setAlignmentX(Component.CENTER_ALIGNMENT);
        cC.add(choice2);
        choice2.setAlignmentX(Component.CENTER_ALIGNMENT);
        cC.add(choice3);
        choice3.setAlignmentX(Component.CENTER_ALIGNMENT);
        cS.add(submit);

        center.add(cN, BorderLayout.PAGE_START);
        center.add(cC, BorderLayout.CENTER);
        center.add(cS, BorderLayout.PAGE_END);
        frame.add(center, BorderLayout.CENTER);

        choice1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (choice1.isSelected()) {
                    choice2.setSelected(false);
                    choice3.setSelected(false);;
                }
                else{
                    choice1.setSelected(true);
                }
            }
        });
        choice2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (choice2.isSelected()) {
                    choice1.setSelected(false);
                    choice3.setSelected(false);
                }
                else{
                    choice2.setSelected(true);
                }
            }
        });
        choice3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (choice3.isSelected()) {
                    choice1.setSelected(false);
                    choice2.setSelected(false);
                }
                else{
                    choice3.setSelected(true);
                }
            }
        });
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (choice1.isSelected()) {
                        results = control.cChoice(choice1.getText(), gameCode);
                    } else if (choice2.isSelected()){
                        results = control.cChoice(choice2.getText(), gameCode);
                    } else{
                        results = control.cChoice(choice3.getText(), gameCode);
                    }
                    System.out.println(results);
                    if (results.length() > 0) {
                        int index = results.indexOf("-");
                        namep1 = results.substring(0,index);
                        results = results.substring(index+2);
                    }
                    if (results.length() > 0) {
                        int index = results.indexOf("-");
                        if (index < 1) {
                            messagep1 = "You picked your own option";
                            results = results.substring(index+4);
                        } else {
                            messagep1 = results.substring(0, index);
                            results = results.substring(index + 2);
                        }
                    }
                    if (results.length() > 0) {
                        int index = results.indexOf("-");
                        scorep1 = results.substring(0,index);
                        results = results.substring(index+2);
                    }
                    if (results.length() > 0) {
                        int index = results.indexOf("-");
                        foolerp1 = results.substring(0,index);
                        results = results.substring(index+2);
                    }
                    if (results.length() > 0) {
                        int index = results.indexOf("-");
                        fooledp1 = results.substring(0,index);
                        results = results.substring(index+2);
                    }

                    if (results.length() > 0) {
                        int index = results.indexOf("-");
                        namep2 = results.substring(0,index);
                        results = results.substring(index+2);
                    }

                    if (results.length() > 0) {
                        int index = results.indexOf("-");
                        if (index <1){
                            messagep2 = "You picked your own option";
                            results = results.substring(index+4);
                        } else {
                            messagep2 = results.substring(0, index);
                            results = results.substring(index + 2);
                        }
                    }
                    if (results.length() > 0) {
                        int index = results.indexOf("-");
                        scorep2 = results.substring(0,index);
                        results = results.substring(index+2);
                    }

                    if (results.length() > 0) {
                        int index = results.indexOf("-");
                        foolerp2 = results.substring(0, index);
                        results = results.substring(index + 2);
                    }
                    if (results.length() > 0) {
                        int index = results.indexOf("-");
                        fooledp2 = results.substring(0);
                    }

                    frame.dispose();
                    results();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (FoilException e1) {
                    System.out.println(e1.getMessage());
                }
            }
        });
        //puts together frame
        frame.pack();
    }

    public void results(){
        JFrame frame = new JFrame("FoilMaker");
        frame.setPreferredSize(new Dimension(300,500));
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel up = new JPanel();
        up.setPreferredSize(new Dimension(300,50));
        JPanel mid = new JPanel();
        mid.setPreferredSize(new Dimension(300,300));
        JPanel down = new JPanel();
        down.setPreferredSize(new Dimension(300,100));

        //northern portion
        JLabel name = new JLabel(getName());
        up.add(name, BorderLayout.CENTER);
        frame.add(up, BorderLayout.PAGE_START);

        //middle portion
        JTextArea round = new JTextArea();

        round.setEditable(false);
        round.setBorder(BorderFactory.createTitledBorder("Round Result"));
        round.setBackground(Color.yellow);
        round.setPreferredSize(new Dimension(250,70));
        JTextArea overal = new JTextArea();
        JScrollPane overall = new JScrollPane(overal);

        if (namep1.equals(getName())){
            round.setText(messagep1);
            overal.setText(namep1 + " => Score: " + scorep1 + " | Fooled: " + foolerp1 + " player(s) | Fooled by: " + fooledp1 + " player(s)");
            overal.setText(overal.getText() + "\n" + namep2 + " => Score: " + scorep2 + " | Fooled: " + foolerp2 + " player(s) | Fooled by: " + fooledp2 + " player(s)");
        } else if (namep2.equals(getName())){
            round.setText(messagep2);
            overal.setText(namep2 + " => Score: " + scorep2 + " | Fooled: " + foolerp2 + " player(s) | Fooled by: " + fooledp2 + " player(s)");
            overal.setText(overal.getText() + "\n" + namep1 + " => Score: " + scorep1 + " | Fooled: " + foolerp1 + " player(s) | Fooled by: " + fooledp1 + " player(s)");
        } else {
            System.out.println("error");
        }
        overal.setEditable(false);
        overall.setBackground(Color.orange);
        overall.setBorder(BorderFactory.createTitledBorder("Overall Results"));
        overall.setPreferredSize(new Dimension(250,200));
        mid.add(round);
        mid.add(overall);
        frame.add(mid, BorderLayout.CENTER);

        //southern portion
        JButton nextRound = new JButton("Next Round");
        JButton quit = new JButton("Quit");
        down.add(nextRound, BorderLayout.CENTER);
        down.add(quit);
        frame.add(down, BorderLayout.PAGE_END);

        nextRound.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    String fromServ = control.cNewRound();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
                suggestions();
            }
        });
        nextRound.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    control.cQuit();
                    frame.dispose();
                }catch(IOException i){
                    i.printStackTrace();
                } catch (FoilException e1) {
                    System.out.println(e1.getMessage());
                }
            }
        });

        frame.pack();
    }

    public static void main(String[] args) throws IOException {
        View k = new View(); /* Show GUI */
    }
}
