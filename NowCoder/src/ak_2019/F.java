package ak_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static final int MOD = (int) (1e9 + 7);

    private static void solve() throws IOException {
        int n = nextInt();
        // 求解n * 2^(n-1)

        if (n == 1) {
            System.out.println(1);
            return;
        }

        if (n == 2) {
            System.out.println(4);
            return;
        }

        long ans = n;
        int count = (n - 1) / 32;
        int leftCount = (n - 1) % 32;
        for (int i = 0; i < count; i++) {
            ans = (ans << 32) % MOD;
        }

        for (int i = 0; i < leftCount; i++) {
            ans = (ans << 1) % MOD;
        }
        
        System.out.println(ans);
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
