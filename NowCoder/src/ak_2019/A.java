package ak_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    // 快速幂
    private static long mul(long a, long b, long p) {
        long ans = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans + a) % p;
            }
            a = (a + a) % p;
            b >>= 1;
        }

        return ans;
    }

    private static void solve() throws IOException {
        int t = nextInt();
        while ((t--) > 0) {
            long a = nextLong();
            long b = nextLong();
            long p = nextLong();

            if (b == 0) {
                System.out.println(1 % p);
                return;
            }

            long ans = 1;
            a = a % p;
            while (b > 0) {
                if ((b & 1) == 1) {
                    ans = mul(ans, a, p) % p;
                }
                a = mul(a, a,p) % p;
                b >>= 1L;
            }

            System.out.println(ans % p);
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
