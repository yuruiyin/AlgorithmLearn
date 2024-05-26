package contest.contest360;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B {

    public long minimumPossibleSum(int n, int target) {
        if (n == 1) {
            return 1;
        }

        long ans = 0;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 1; count < n ;i++) {
            if (target >= i && set.contains(target - i)) {
                continue;
            }
            set.add(i);
            count++;
            ans += i;
        }

        return ans;
    }

}
