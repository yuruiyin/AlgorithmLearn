package round613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int t = nextInt();
        while ((t--) > 0) {
            int n = nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }

            if (arr[0] <= 0 || arr[n-1] <= 0) {
                System.out.println("NO");
                continue;
            }

            long[] preSumArr = new long[n];
            preSumArr[0] = arr[0];
            boolean isOk = true;
            for (int i = 1; i < n; i++) {
                preSumArr[i] = preSumArr[i-1] + arr[i];
                if (preSumArr[i] <= 0) {
                    isOk = false;
                    break;
                }
            }

            if (!isOk) {
                System.out.println("NO");
                continue;
            }

            long[] suffixSumArr = new long[n];
            suffixSumArr[n-1] = arr[n-1];

            for (int i = n - 2; i >= 0; i--) {
                suffixSumArr[i] = suffixSumArr[i+1] + arr[i];
                if (suffixSumArr[i] <= 0) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }




    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
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
