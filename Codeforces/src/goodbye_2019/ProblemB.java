package goodbye_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProblemB {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void runCase(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(arr[i] - arr[i+1]) > 1) {
                System.out.println("YES");
                System.out.println((i + 1) + " " + (i + 2));
                return;
            }
        }
        
        System.out.println("NO");
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        while ((t--) > 0) {
            int n = nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }

            runCase(arr);
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
