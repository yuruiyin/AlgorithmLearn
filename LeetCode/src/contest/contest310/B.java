package contest.contest310;

import java.util.HashSet;
import java.util.Set;

public class B {

    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int len = arr.length;
        set.add(arr[0]);
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (set.contains(arr[i])) {
                set = new HashSet<>();
                ans++;
                set.add(arr[i]);
            } else {
                set.add(arr[i]);
            }
        }
        if (!set.isEmpty()) {
            ans++;
        }
        return ans;
    }

}
