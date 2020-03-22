package global_round007;

import java.io.*;
import java.util.StringTokenizer;

public class B {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                b[i] = in.nextLong();
            }

            long[] a = new long[n];
            a[0] = b[0];
            long x = Math.max(0, a[0]);
            for (int i = 1; i < n; i++) {
                a[i] = b[i] + x;
                x = Math.max(x, a[i]);
            }

            for (int i = 0; i < n; i++) {
                out.print(a[i] + " ");
            }
            out.println();
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
