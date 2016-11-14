import java.io.IOException;

/**
 * Created by Zach on 11/8/2016.
 */
public class View {
    public static void main (String []args) throws IOException {
        Client2 control = new Client2();
        System.out.println(control.sendMessage(3));

    }
}

