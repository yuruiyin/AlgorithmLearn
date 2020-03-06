package ozon_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[] arr = new int[n];
        boolean[] visited = new boolean[m + 1];
        boolean hasEqual = false;

        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
            if (visited[arr[i] % m]) {
                hasEqual = true;
            }

            visited[arr[i] % m] = true;
        }

        if (hasEqual) {
            System.out.println(0);
        } else {
            long ans = 1;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    ans = (ans * Math.abs(arr[i] - arr[j])) % m;
                }
            }

            System.out.println(ans);
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
