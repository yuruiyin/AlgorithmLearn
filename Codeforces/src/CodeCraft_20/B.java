package CodeCraft_20;

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
            String str = next();

            int ansMinIndex = 0;
            String minStr = str;

            for (int i = 1; i < n; i++) {
                boolean isReversed = (n - i) % 2 != 0;
                StringBuilder curSb = new StringBuilder();
                curSb.append(str.substring(i));
                if (isReversed) {
                    String left = str.substring(0, i);
                    curSb.append(new StringBuilder(left).reverse());
                } else {
                    String left = str.substring(0, i);
                    curSb.append(left);
                }

                String curStr = curSb.toString();
                if (curStr.compareTo(minStr) < 0) {
                    minStr = curStr;
                    ansMinIndex = i;
                }
            }

            System.out.println(minStr);
            System.out.println(ansMinIndex + 1);
        }
    }


    private static void createArr() {
        int MAX = 5000;

        for (int i = 0; i < MAX; i++) {
            System.out.print('a');
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
//        createArr();
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
