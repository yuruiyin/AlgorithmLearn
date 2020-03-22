package global_round007;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class C {

    static class Task {

        private static final int MOD = 998244353;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            long[] p = new long[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextLong();
            }

            if (n == 1) {
                out.println(p[0] + " 1");
                return;
            }

            if (k == 1) {
                out.println(n + " 1");
                return;
            }

            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += n - i;
            }

            int leftIdx = -1;
            int rightIdx = -1;
            // [n - k + 1, n]
            for (int i = 0; i < n; i++) {
                if (p[i] >= n - k + 1 && p[i] <= n) {
                    leftIdx = i;
                    break;
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                if (p[i] >= n - k + 1 && p[i] <= n) {
                    rightIdx = i;
                    break;
                }
            }

            long ans = 1;
            long count = 1;
            for (int i = leftIdx + 1; i <= rightIdx; i++) {
                if (!(p[i] >= n - k + 1 && p[i] <= n)) {
                    count++;
                } else {
                    ans = (ans * count) % MOD;
                    count = 1;
                }
            }

            out.println(sum + " " + ans);
        }
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

}
