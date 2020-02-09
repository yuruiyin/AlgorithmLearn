package beginner.contest152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int a = nextInt();
        int b = nextInt();
        StringBuilder aSb = new StringBuilder();
        for (int i = 0; i < b; i++) {
            aSb.append(a);
        }

        StringBuilder bSb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            bSb.append(b);
        }

        if (aSb.toString().compareTo(bSb.toString()) < 0) {
            System.out.println(aSb.toString());
        } else {
            System.out.println(bSb.toString());
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
