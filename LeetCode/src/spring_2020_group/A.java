package spring_2020_group;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/25
 */
public class A {

    public int expectNumber(int[] scores) {
        Set<Integer> set = new HashSet<>();
        for (int num : scores) {
            set.add(num);
        }
        return set.size();
    }

}

//        1 <= time.length <= 10^5
//        1 <= time[i] <= 10000
//        1 <= m <= 1000
