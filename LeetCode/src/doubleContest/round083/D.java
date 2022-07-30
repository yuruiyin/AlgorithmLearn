package doubleContest.round083;

import java.util.HashSet;
import java.util.Set;

public class D {

    public int shortestSequence(int[] rolls, int k) {
        int len = rolls.length;
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        boolean needK = true;
        for (int i = len - 1; i >= 0; i--) {
            if (set.size() == k && needK) {
                ans++;
                set.remove(rolls[i]);
                needK = false;
            } else if (set.size() == 0 && !needK) {
                ans++;
                set.add(rolls[i]);
                needK = true;
            } else if (needK) {
                set.add(rolls[i]);
            } else {
                set.remove(rolls[i]);
            }
        }
        if (set.size() == k) {
            ans++;
        } else if (set.size() == 0) {
            ans++;
        }
        return ans;
    }

}
