package problem001_100;

import java.io.*;
import java.util.StringTokenizer;

public class P090 {

    static class Task {

        // 64位整型相乘取模
        private long longMulti(long a, long b, long mod) {
            long res = 0;
            while (b > 0) {
                if ((b & 1) == 1) {
                    res = (res + a) % mod;
                }

                a = (a << 1) % mod;
                b >>>= 1;
            }
            return res;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long a = in.nextLong();
            long b = in.nextLong();
            long p = in.nextLong();
            out.println(longMulti(a, b, p));
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
