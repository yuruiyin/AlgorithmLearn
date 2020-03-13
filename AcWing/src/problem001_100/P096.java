package problem001_100;

import utils.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class P096 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        // 先考虑三塔的情况
        int[] dp1 = new int[13];
        dp1[1] = 1;
        for (int i = 2; i <= 12; i++) {
            dp1[i] = 2 * dp1[i - 1] + 1;
        }

        // 再考虑四塔的情况
        int[] dp2 = new int[13];
        Arrays.fill(dp2, 0xff);
        dp2[0] = 0;
        for (int i = 1; i <= 12; i++) {
            for (int j = 0; j < i; j++) {
                // 也就是先将i中的j个塔移动到一个柱子（非D柱）上，然后再将剩下的i-j个塔移动到D柱上。这其中求最小值
                dp2[i] = Math.min(dp2[i], 2 * dp2[j] + dp1[i - j]);
            }
        }

        for (int i = 1; i <= 12; i++) {
            out.println(dp2[i]);
        }
    }
}
