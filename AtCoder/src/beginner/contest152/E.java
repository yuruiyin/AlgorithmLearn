package beginner.contest152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E {

    private static int MOD = (int) (1e9 + 7);
    private static long BIG_MOD = (long) (1e17 + 7);

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static long gcd(long m, long n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    private static long lcm(long m, long n) {
        return ((m * n) / gcd(m, n)) % BIG_MOD;
    }

    private static void solve() throws IOException {
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        long mul = 1;
        for (int i = 0; i < n; i++) {
            long maxGcd = 1;
            for (int j = i + 1; j < n; j++) {
                maxGcd = Math.max(maxGcd, gcd(arr[i], arr[j]));
            }
            mul = (mul * maxGcd) % MOD;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + arr[i]) % MOD;
        }
        
        System.out.println(ans / mul);

//        for (int i = 0; i < n; i++) {
//            ans = (ans + arr[i]) % MOD;
//        }
//
//        long lcm = 1;
//        for (int i = 0; i < n; i++) {
//            lcm = lcm(arr[i], lcm);
//        }
//
//        double tmpAns = 0;
//        for (int i = 0; i < n; i++) {
//            tmpAns += 1.0 / arr[i];
//        }
//
//        System.out.println((int)((lcm * tmpAns) % MOD));
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
