package problem601_700;

import java.util.HashSet;
import java.util.Set;

public class Problem667 {

    public int[] constructArray(int n, int k) {
        Set<Integer> visited = new HashSet<>();
        int[] ansArr = new int[n];
        ansArr[0] = 1;
        int index = 1;
        visited.add(1);

        for (int i = k; i >= 1; i--) {
            int smaller = ansArr[index-1] - i;
            int bigger = ansArr[index-1] + i;
            if (smaller >= 1 && !visited.contains(smaller)) {
                ansArr[index] = smaller;
                visited.add(smaller);
            } else {
                ansArr[index] = bigger;
                visited.add(bigger);
            }
            index++;
        }

        for (int i = 1; i <= n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            ansArr[index++] = i;
        }

        return ansArr;
    }

}
