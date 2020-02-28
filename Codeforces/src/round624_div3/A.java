package round624_div3;

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
            int a = nextInt();
            int b = nextInt();

            int diff = a - b;

            if (diff == 0) {
                System.out.println(0);
                continue;
            }

            if (diff < 0) {
                if ((diff & 1) == 1) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
            } else {
                if ((diff & 1) == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
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
