/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Alexis
 */
public class Liste {

    public static <E extends Object> List<E> SupprDoublons(Collection<E> collection)
    {
        List<E> temp = new ArrayList<E>(collection);
        
        for (int i = 0; i < temp.size(); ++i)
            for (int j = i + 1; j < temp.size(); ++j)
                if (temp.get(i).equals(temp.get(j)))
                {
                    temp.remove(j);
                    --j;
                }
                
         return temp;
    }
}
