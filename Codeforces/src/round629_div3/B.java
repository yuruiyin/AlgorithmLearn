package round629_div3;

import java.io.*;
import java.util.StringTokenizer;

public class B {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int k = in.nextInt();
                double delta = Math.sqrt(1L + 8L * k) - 1;
                long x = (int) (delta / 2);
                long value = x * (x + 1) / 2;
                long diff = k - value;
                StringBuilder sb = new StringBuilder();
                if (diff == 0) {
                    long bitCount = x + 1;
                    long leftACount = n - bitCount;
                    while ((leftACount--) > 0) {
                        sb.append('a');
                    }
                    sb.append("bb");
                    long rightBCount = bitCount - 2;
                    while ((rightBCount--) > 0) {
                        sb.append('a');
                    }
                } else {
                    long bitCount = x + 2;
                    long leftACount = n - bitCount;
                    while ((leftACount--) > 0) {
                        sb.append('a');
                    }
                    sb.append("b");
                    long midZeroCount = bitCount - 1 - diff;
                    while ((midZeroCount--) > 0) {
                        sb.append('a');
                    }
                    sb.append('b');
                    for (int i = 0; i < diff - 1; i++) {
                        sb.append('a');
                    }
                }

                out.println(sb.toString());
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
