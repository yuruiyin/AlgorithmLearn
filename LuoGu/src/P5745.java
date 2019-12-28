import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P5745 {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = nextInt();
        int m = nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }

        int left = 0;
        int right = 0;
        int ansLeft = 0;
        int ansRight = 0;
        long ansSum = 0;
        long sum = 0;
        while (right < n) {
            while (right < n) {
                if (sum + arr[right] <= (long) m) {
                    sum += arr[right];
                    right++;
                } else {
                    break;
                }
            }

            if (sum > ansSum) {
                ansSum = sum;
                ansLeft = left;
                ansRight = right - 1;
            }

            if (right == n) {
                break;
            }

            sum -= arr[left];
            left++;
            if (right < left) {
                right++;
                sum = 0;
            }
        }

        PrintWriter out = new PrintWriter(System.out);
        out.println((ansLeft + 1) + " " + (ansRight + 1) + " " + ansSum);
        out.close();
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
