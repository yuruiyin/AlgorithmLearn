package round628;

import java.io.*;
import java.util.StringTokenizer;

public class D {
    
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long u = in.nextLong();
            long v = in.nextLong();

            if (u > v) {
                out.println(-1);
                return;
            }

            if (u == v) {
                if (v == 0) {
                    out.println(0);
                } else {
                    out.println(1);
                    out.println(u);
                }
                return;
            }

            // u < v
            long diff = v - u;
            if (diff % 2 == 1) {
                out.println(-1);
                return;
            }

            // 可以拆分成两个数
            long x1 = (u + v) >>> 1L;
            long x2 = (v - u) >>> 1L;
            if ((x1 ^ x2) != u) {
                // 三个数
                out.println(3);
                out.println(u + " " + diff / 2 + " " + diff / 2);
            } else {
                out.println(2);
                out.println(x1 + " " + x2);
            }
        }
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
