package contest.contest388;

import java.util.Arrays;

public class A {

    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int num : apple) {
            sum += num;
        }

        Arrays.sort(capacity);
        int len = capacity.length;
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (sum > 0) {
                sum -= capacity[i];
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }

}
