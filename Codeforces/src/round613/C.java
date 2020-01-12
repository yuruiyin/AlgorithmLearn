package round613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static long gcd(long m, long n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    private static long[] getAns(long num) {
        int end = (int) Math.sqrt(num);
        long min = num;
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                if (gcd(i, num / i) == 1) {
                    min = Math.min(min, num / i);
                }
            }
        }

        return new long[]{num / min, min};
    }

    private static void solve() throws IOException {
        long x = nextLong();
        long[] ans = getAns(x);
        System.out.println(ans[0] + " " + ans[1]);
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
