package doubleContest.round097;

import java.util.HashSet;
import java.util.Set;

public class B {

    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int num : banned) {
            set.add(num);
        }
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }
            sum += i;
            if (sum > maxSum) {
                break;
            }
            count++;
        }
        return count;
    }

}
