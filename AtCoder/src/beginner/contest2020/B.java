package beginner.contest2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int aLen = nextInt();
        int bLen = nextInt();
        int M = nextInt();

        int[] arrA = new int[aLen];
        int minA = Integer.MAX_VALUE;
        for (int i = 0; i < aLen; i++) {
            arrA[i] = nextInt();
            minA = Math.min(minA, arrA[i]);
        }

        int[] arrB = new int[bLen];
        int minB = Integer.MAX_VALUE;
        for (int i = 0; i < bLen; i++) {
            arrB[i] = nextInt();
            minB = Math.min(minB, arrB[i]);
        }

        int min = minA + minB;
        for (int i = 0; i < M; i++) {
            int x = nextInt();
            int y = nextInt();
            int c = nextInt();

            min = Math.min(min, arrA[x - 1] + arrB[y - 1] - c);
        }

        System.out.println(min);

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
