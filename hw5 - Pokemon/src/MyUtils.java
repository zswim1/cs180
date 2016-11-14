/**
 * Created by Zach on 11/11/2016.
 */
public class MyUtils {

    public MyUtils()
    {

    }

    public static boolean isNumeric(String str)
    {
        if (str.length() > 0)
        {
            for (int i =0; i < str.length(); i++)
            {
                if (Character.isDigit(str.charAt(i)))
                {

                }
                else if (str.substring(i,i+1).equals("."))
                {
                    if (Character.isDigit(str.charAt(i+1)))
                    {

                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static String formatStr(String str)
    {
        if (str.length()>0)
        {
            if (str.length()>1)
            {
                String part1 = str.substring(0,1).toUpperCase();
                String part2 = str.substring(1,str.length()).toLowerCase();
                return part1 + part2;
            }
            else {
                return str.toUpperCase();
            }
        }
        else {
            return str;
        }
    }
}
