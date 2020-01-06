package hello_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = nextInt();
        int m = nextInt();
        String[] s = new String[n];
        String[] t = new String[m];
        for (int i = 0; i < n; i++) {
            s[i] = next();
        }
        for (int i = 0; i < m; i++) {
            t[i] = next();
        }

        int q = nextInt();
        while ((q--) > 0) {
            int y = nextInt();
            int sIndex = (y - 1) % n;
            int tIndex = (y - 1) % m;
            System.out.println(s[sIndex] + t[tIndex]);
        }

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
