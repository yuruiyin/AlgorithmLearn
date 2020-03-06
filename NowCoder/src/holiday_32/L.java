package holiday_32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class L {

    private static final int MOD = 1000000;

    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    private static int totalSum;

    public static int[] getAnsNotRec(int[] nums) {
        int len = nums.length;
        int[] dp = new int[totalSum + 1];
        dp[0] = 1;
        for (int j = 0; j < len; j++) {
            int[] oldDp = Arrays.copyOf(dp, totalSum + 1);
            for (int i = 1; i <= totalSum; i++) {
                if (i + nums[j] > totalSum) {
                    break;
                }

                dp[i + nums[j]] = (oldDp[i + nums[j]] + oldDp[i]) % MOD;
            }
            if (nums[j] > totalSum) {
                continue;
            }
            dp[nums[j]] = (dp[nums[j]] + 1) % MOD;
        }

        int minDiff = totalSum;
        int ansCount = 0;

        for (int i = 1; i <= totalSum; i++) {
            int diff = totalSum - 2 * i;
            if (diff >= 0 && diff < minDiff && dp[i] != 0) {
                minDiff = diff;
                ansCount = dp[i];
                if (i == totalSum - i && nums[0] != nums[len - 1]) {
                    ansCount >>= 1;
                }
            }
        }

        return new int[]{minDiff, ansCount};
    }

    private static void solve() throws IOException {
        int n = nextInt();
        int[] arr = new int[n];
        totalSum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
            totalSum += arr[i];
        }

        Arrays.sort(arr);
        
        if (n == 1) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        // dp求得最小的两堆间距
        int[] ansArr = getAnsNotRec(arr);
        System.out.println(ansArr[0]);
        System.out.println(ansArr[1]);
    }

    private static void makeInputArr() {
        int n = 100;
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(2001);
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
//        makeInputArr();
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null)
                throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

}
