package goodbye_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemA {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        while ((t--) > 0) {
            int n = nextInt();
            int k1 = nextInt();
            int k2 = nextInt();
            int[] arr1 = new int[k1];
            int[] arr2 = new int[k2];

            int max1 = Integer.MIN_VALUE;
            for (int i = 0; i < k1; i++) {
                arr1[i] = nextInt();
                max1 = Math.max(max1, arr1[i]);
            }

            int max2 = Integer.MIN_VALUE;
            for (int i = 0; i < k2; i++) {
                arr2[i] = nextInt();
                max2 = Math.max(max2, arr2[i]);
            }

            if (max1 > max2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
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
