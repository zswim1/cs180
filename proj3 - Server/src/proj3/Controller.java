package proj3;

import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Zach on 10/28/2016.
 */

public class Controller {
    private Socket s;
    private String response = "";
    private String token;
    private String uToken = ""; //random token given by login response
    InputStreamReader isr;
    PrintWriter pw;
    BufferedReader br;
    private View v;

    public Controller(){
        try {
            s = new Socket("localhost", 50000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            pw = new PrintWriter(s.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            isr = new InputStreamReader(s.getInputStream());
            br = new BufferedReader(isr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        v = new View(1);
    }


    public String cLogin(String user, String pass) throws IOException, FoilException {
        pw.println("LOGIN--" + user + "--" + pass);
        pw.flush();

        response = (String)br.readLine();

        if(response.equals("RESPONSE--LOGIN--INVALIDMESSAGEFORMAT--LOGIN--"+ user+"--"+pass)){
            throw new FoilException("Invalid message format");
        }
        if(response.equals("RESPONSE--LOGIN--UNKNOWNUSER--LOGIN--"+ user+"--"+pass)){
            throw new FoilException("Your username is incorrect");
        }
        if(response.equals("RESPONSE--LOGIN--INVALIDUSERPASSWORD--LOGIN--"+ user+"--"+pass)){
            throw new FoilException("Your Password for the user was incorrect");
        }
        if(response.equals("RESPONSE--LOGIN--USERALREADYLOGGEDIN--LOGIN--"+ user+"--"+pass)){
            throw new FoilException("This user is already logged in");
        }

        uToken = response.substring(26);
        return uToken;
    }

    public void cRegister(String user, String pass) throws IOException, FoilException {
        pw.println("CREATENEWUSER--" + user + "--" + pass);
        pw.flush();

        response = (String)br.readLine();
        int index = response.indexOf("-",26);
        response = response.substring(25,index);
        if (response.equals("INVALIDMESSAGEFORMAT")){
            throw new FoilException("Request in incorrect format");
        } else if (response.equals("INVALIDUSERNAME")){
            throw new FoilException("Username empty");
        } else if (response.equals("INVALIDUSERPASSWORD")){
            throw new FoilException("Password empty");
        } else if (response.equals("USERALREADYEXISTS")){
            throw new FoilException("User already exists");
        } else if (response.equals("SUCCESS")){
            throw new FoilException("User created successfully");
        }
    }

    public String cStartNew() throws IOException, FoilException {


        pw.println("STARTNEWGAME--" + uToken);
        pw.flush();

        response = (String)br.readLine();
        int index = response.indexOf("-", 26);
        String response2 = response.substring(24, index);
        if (response2.equals("USERNOTLOGGEDIN")){
            throw new FoilException("Not logged in");
        } else if (response2.equals("FAILURE")){
            throw new FoilException("User already playing or failed due to internal error");
        } else {
            token = response.substring(33,response.length());
        }

        return token;
    }

    public String hasNew(){
        String r3 = "";
        String r4 = "";
        boolean newParticipant = false;

        while (!newParticipant){
            try {
                r3 = (String) br.readLine();
                int index = r3.indexOf("-", 17);

                r4 = r3.substring(16, index);
                r3 = r3.substring(index+2, r3.length());

                v.playerJoin(new Model(r4, r3));
                newParticipant = true;
            } catch (Exception e){
                System.out.println(e.getMessage());
                newParticipant = false;
            }
        }
        return r4;
    }

    public String roundReady() throws IOException {
        response = br.readLine();
        int index = response.indexOf("-", 13);
        String word = response.substring(13,index);
        String example = response.substring(index+2);
        return word + "?" + example;
    }

    public boolean cJoin(String iToken) throws IOException, FoilException {
        //score???
        pw.println("JOINGAME--" + uToken + "--" + iToken);
        pw.flush();

        response = (String)br.readLine();
        int index = response.indexOf("-", 26);
        String response2 = response.substring(24, index);
        if (response.substring(20, response.length()-5).equals("SUCCESS")){
            return true;
        }else if(response2.equals("USERNOTLOGGEDIN")){
            throw new FoilException("Invalid User Token");
        }else if(response2.equals("GAMEKEYNOTFOUND")){
            throw new FoilException("Invalid Game Token");
        }else if(response2.equals("FAILURE")){
            throw new FoilException("You already played in that game");
        }
        return false;
    }

    public String cLaunch() throws IOException {
        pw.println("ALLPARTICIPANTSHAVEJOINED--" + uToken + "--" + token);
        pw.flush();

        response = br.readLine();
        int index = response.indexOf("-", 13);
        String word = response.substring(13,index);
        String example = response.substring(index+2);
        return word + "?" + example;
    }

    public String cSuggestion(String suggestion, String gameToken) throws IOException, FoilException {
        pw.println("PLAYERSUGGESTION--" + uToken + "--" + gameToken + "--" + suggestion);
        pw.flush();

        response = (String)br.readLine();

        int index = response.indexOf("-", 28);
        //checks for errors

        if (index > -1 && response.length() > index) {
            if (response.substring(28, index).equals("USERNOTLOGGEDIN")) {
                throw new FoilException("invalid user token");
            } else if (response.substring(28, index).equals("INVALIDGAMETOKEN")) {
                throw new FoilException("invalid game token");
            } else if (response.substring(28, index).equals("UNEXPECTEDMESSAGETYPE")) {
                throw new FoilException("suggestion sent when different message type was expected");
            } else if (response.substring(28, index).equals("INVALIDMESSAGEFORMAT")) {
                throw new FoilException("message format not according to model");
            }
        }
        if (response.length() > index) {
            index = response.indexOf("-", 15);
        }
        if (response.length() > index) {
            index = response.indexOf("-", index + 2);
        }
        return response.substring(14);

    }

    public String cChoice(String choice, String gameToken) throws IOException, FoilException {
        pw.println("PLAYERCHOICE--" + uToken + "--" + gameToken + "--" + choice);
        pw.flush();

        response = (String)br.readLine();

        int index = response.indexOf("-", 24);
        //checks for errors

        if (index > -1 && response.length() > index) {
            if (response.substring(24, index).equals("USERNOTLOGGEDIN")) {
                throw new FoilException("invalid user token");
            } else if (response.substring(24, index).equals("INVALIDGAMETOKEN")) {
                throw new FoilException("invalid game token");
            } else if (response.substring(24, index).equals("UNEXPECTEDMESSAGETYPE")) {
                throw new FoilException("suggestion sent when different message type was expected");
            } else if (response.substring(24, index).equals("INVALIDMESSAGEFORMAT")) {
                throw new FoilException("message format not according to model");
            }
        }

        return response.substring(13);
    }

    public String cNewRound() throws IOException {
        response = br.readLine();
        int index = response.indexOf("-", 13);
        String word = response.substring(13,index);
        String example = response.substring(index+2);
        return word + "?" + example;
    }

    public void cQuit() throws IOException, FoilException {
        pw.println("LOGOUT--");
        pw.flush();

        response = (String)br.readLine();
        response = response.substring(18);
        if (response.equals("USERNOTLOGGEDIN")){
            throw new FoilException("user currently not logged in");
        }
        s.close();
    }

    //public SwingWorker<String, Object>{

    //}


}
