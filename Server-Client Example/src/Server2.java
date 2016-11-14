/**
 * Created by Zach on 11/7/2016.
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server2 {
    public static void main(String[] args) throws IOException{
        int number, temp;

        ServerSocket ss = new ServerSocket(18874);
        Socket s = ss.accept();

        ObjectOutputStream dos = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream dis = new ObjectInputStream(s.getInputStream());

        number =dis.readInt();

        temp = 2*number;

        dos.writeInt(temp);
        dos.flush();

        dos.close();
        dis.close();
    }
}
