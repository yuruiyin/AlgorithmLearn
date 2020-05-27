package contest.contest187;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/3
 */
public class A {

    public String destCity(List<List<String>> paths) {
        String ans;
        Set<String> set = new HashSet<>();
        Set<String> startSet = new HashSet<>();
        for (List<String> list : paths) {
            String city1 = list.get(0);
            String city2 = list.get(1);
            set.add(city1);
            set.add(city2);
            startSet.add(city1);
        }

        set.removeAll(startSet);
        return set.iterator().next();
    }

}
