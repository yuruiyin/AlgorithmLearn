package ozon_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int t = nextInt();
        while ((t--) > 0) {
            int n = nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);

            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(b[i] + " ");
            }
            System.out.println();
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
