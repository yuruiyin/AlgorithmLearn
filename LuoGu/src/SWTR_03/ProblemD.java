package SWTR_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemD {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = nextInt();
        int w = nextInt();
        int s = nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        long[] dp = new long[w + 1];
        Arrays.fill(dp, Long.MIN_VALUE);
        dp[1] = arr[0];
        long[] tmpDp = new long[w+1];

        for (int i = 1; i < n; i++) {
            int maxCount = Math.min(w, i);
            int maxDelCount = Math.min(maxCount, s);
            Arrays.fill(tmpDp, Long.MIN_VALUE);
            for (int k = 1; k <= maxCount; k++) {
                if (dp[k] == Long.MIN_VALUE) {
                    continue;
                }

                for (int j = 0; j <= maxDelCount; j++) {
                    if (j > k) {
                        break;
                    }

                    if (k - j + 1 > w) {
                        continue;
                    }

                    tmpDp[k-j+1] = Math.max(tmpDp[k-j+1], dp[k] + (k-j+1) * arr[i]);
                }
            }

            for (int k = 1; k <= maxCount + 1; k++) {
                if (tmpDp[k] != Long.MIN_VALUE) {
                    dp[k] = tmpDp[k];
                }
            }
        }

        long ans = Long.MIN_VALUE;
        for (int i = 1; i <= w; i++) {
            ans = Math.max(ans, dp[i]);
        }
        
        System.out.println(ans);
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
