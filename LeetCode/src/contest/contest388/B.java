package contest.contest388;

import java.util.Arrays;

public class B {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int len = happiness.length;
        long ans = 0;
        long value = 0;
        for (int i = len - 1; i >= len - k; i--) {
            ans += happiness[i];
        }

        for (int i = len - 2, j = 1; i >= len - k; i--, j++) {
            ans -= Math.min(j, happiness[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
