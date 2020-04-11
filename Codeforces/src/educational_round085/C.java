package educational_round085;

import java.io.*;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class C {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                long[] a = new long[n];
                long[] b = new long[n];
                for (int i = 0; i < n; i++) {
                    a[i] = in.nextLong();
                    b[i] = in.nextLong();
                }

                if (n == 1) {
                    out.println(a[0]);
                    continue;
                }

                long[] pre = new long[n];
                long preB = b[n - 1];
                pre[0] = preB >= a[0] ? 0 : a[0] - preB;
                preB = b[0];
                for (int i = 1; i < n; i++) {
                    pre[i] = preB >= a[i] ? pre[i-1] : pre[i-1] + a[i] - preB;
                    preB = b[i];
                }

                long ansMin = pre[n - 1] + a[0] - pre[0];
                for (int i = 1; i < n; i++) {
                    long cur = pre[n - 1] - pre[i] + a[i] + pre[i - 1];
                    ansMin = Math.min(ansMin, cur);
                }
                out.println(ansMin);
            }

        }
    }

    private static void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    public static void main(String[] args) {
        new Thread(null, () -> solve(), "1", 1 << 26).start();
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
