package educational_round080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static int getNumBitCount(int num) {
        int ans = 0;
        while (num > 0) {
            num /= 10;
            ans++;
        }
        return ans;
    }

    private static void solve() throws IOException {
        int t = nextInt();
        while ((t--) > 0) {
            int A = nextInt();
            int B = nextInt();
            int lenB = getNumBitCount(B);
            int countB = Math.pow(10, lenB) - 1 == B ? lenB : lenB - 1;
//            System.out.println(countB * A);
            System.out.println((long) countB * A);
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
