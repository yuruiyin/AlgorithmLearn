package doubleContest.round57;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/24
 */
public class A {

    public boolean areOccurrencesEqual(String s) {
        char[] arr = s.toCharArray();
        int[] countArr = new int[26];
        for (char c : arr) {
            countArr[c - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (countArr[i] != 0) {
                set.add(countArr[i]);
            }
        }
        return set.size() == 1;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
