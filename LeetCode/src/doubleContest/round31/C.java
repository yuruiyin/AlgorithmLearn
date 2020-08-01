package doubleContest.round31;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/25
 */
public class C {

    public int numSplits(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int[] preCountArr = new int[len];
        preCountArr[0] = 1;
        Set<Character> set = new HashSet<>();
        set.add(arr[0]);

        for (int i = 1; i < len; i++) {
            set.add(arr[i]);
            preCountArr[i] = set.size();
        }

        int[] sufCountArr = new int[len];
        sufCountArr[len - 1] = 1;
        set.clear();
        set.add(arr[len - 1]);

        for (int i = len - 2; i >= 0; i--) {
            set.add(arr[i]);
            sufCountArr[i] = set.size();
        }

        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            if (preCountArr[i] == sufCountArr[i + 1]) {
                ans++;
            }
        }

        return ans;
    }

}
