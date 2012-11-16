/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author Morgane
 */
public class Casse
{

    public static String toTitleCase(String s)
    {
        String result = s;
        if (s != null)
        {
            String s1 = "";
            String s2 = "";

            if (s.length() > 0)
                s1 = s.substring(0, 1).toUpperCase();
            if (s.length() > 1)
                s2 = s.substring(1, s.length()).toLowerCase();

            result = s1 + s2;
        }

        return result;
    }
}
