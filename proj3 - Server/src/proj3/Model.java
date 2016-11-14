package proj3;

import java.util.*;
import javax.swing.*;

/**
 * Created by Zach on 10/28/2016.
 */
public class Model {
    private String name;
    private String pass;
    private String userToken;
    private int score;
    private boolean joined;
    private ArrayList<Model> playerList = new ArrayList<Model>();

    public Model(String name, String pass, String userToken){
        this.name = name;
        this.pass = pass;
        this.userToken = userToken;
        score = 0;
        joined = false;
        playerList.add(this);
    }

    public Model(String name, String pass){
        this.name = name;
        this.pass = pass;
    }

    public Model(){
    }

    public void setJoined(boolean j){
        joined = j;
    }

    public boolean isJoined(){
        return joined;
    }
    public String getName(){
        return name;
    }
    public String getPass(){
        return pass;
    }
    public String getUserToken(){
        return userToken;
    }
    public int getScore(){
        return score;
    }
    public void addToScore(int add){
        score += add;
    }

    public ArrayList<Model> getPlayerList(){
        return playerList;
    }

}
