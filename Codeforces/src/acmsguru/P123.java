package acmsguru;

import java.io.*;
import java.util.StringTokenizer;

public class P123 {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int k = in.nextInt();
            if (k == 1) {
                out.println(1);
                return;
            }

            if (k == 2) {
                out.println(2);
                return;
            }

            k -= 2;
            long num1 = 1;
            long num2 = 1;
            long sum = 2;
            while ((k--) > 0) {
                long oldNum2 = num2;
                num2 = num1 + num2;
                num1 = oldNum2;
                sum += num2;
            }

            out.println(sum);
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
