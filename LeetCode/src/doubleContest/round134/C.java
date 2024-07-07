package doubleContest.round134;

import java.util.Arrays;

public class C {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int len = colors.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int curIdx = 0;
        for (int i = len - 1; i > 0; i--) {
            if (colors[i] != colors[curIdx]) {
                dp[0]++;
                curIdx = i;
            } else {
                break;
            }
        }

        int ans = dp[0] >= k ? 1 :0;
        for (int i = 1; i < len; i++) {
            if (colors[i] != colors[(i - 1 + len) % len]) {
                dp[i] = dp[i - 1] + 1;
            }
            if (dp[i] >= k) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
