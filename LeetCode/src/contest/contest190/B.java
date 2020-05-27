package contest.contest190;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/24
 */
public class B {

    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        char[] arr = s.toCharArray();
        int len = arr.length;

        int maxCount = 0;

        for (int i = 0; i < k; i++) {
            char c = arr[i];
            if (set.contains(c)) {
                maxCount++;
            }
        }

        int count = maxCount;

        for (int left = 1; left + k <= len; left++) {
            if (set.contains(arr[left - 1])) {
                count--;
            }

            if (set.contains(arr[left + k - 1])) {
                count++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

}
