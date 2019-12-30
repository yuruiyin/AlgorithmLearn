package goodbye_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemC {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        while ((t--) > 0) {
            int n = nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }

            long sum = 0;
            long xor = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                xor ^= arr[i];
            }
            
            if (sum == 2 * xor) {
                System.out.println(0);
                System.out.println();
                continue;
            }
            
            System.out.println(2);
            System.out.println(xor + " " + (sum + xor));
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
