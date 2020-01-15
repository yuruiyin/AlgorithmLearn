package educational_round080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int t = nextInt();
        while ((t--) > 0) {
            int n = nextInt();
            int d = nextInt();

            if (d <= n) {
                System.out.println("YES");
                continue;
            }

            int delta = (int) Math.sqrt(1 + (long) 4 * d);
//            int delta = (int) Math.sqrt(1 + 4 * d);
            int x = (delta - 1) / 2;
            boolean isOk = false;
            int oldX = x;
            for (int offset = -1000000; offset <= 1000000; offset++) {
                x = oldX + offset;
                if (x < 0) {
                    continue;
                }
                int ceil = d % ( x + 1) == 0 ? d / (x + 1) : d / (x + 1) + 1;
                if (x + ceil <= n) {
                    isOk = true;
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
