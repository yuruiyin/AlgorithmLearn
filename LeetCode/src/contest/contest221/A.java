package contest.contest221;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/27
 */
public class A {

    public boolean halvesAreAlike(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int count1 = 0;
        for (int i = 0; i < len / 2; i++) {
            if (set.contains(arr[i])) {
                count1++;
            }
        }


        int count2 = 0;
        for (int i = len / 2; i < len; i++) {
            if (set.contains(arr[i])) {
                count2++;
            }
        }

        return count1 == count2;
    }

}
