/**
 * Created by Zach on 11/7/2016.
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client2 {
    public Client2(){

    }
    public int sendMessage (int number) throws IOException {

        int temp;
        Socket s = new Socket(InetAddress.getLocalHost(), 18874);

        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

        oos.writeInt(number);
        oos.flush();

        temp = ois.readInt();

        ois.close();
        oos.close();

        return temp;
    }
}