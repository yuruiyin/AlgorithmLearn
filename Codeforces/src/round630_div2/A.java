package round630_div2;

import java.io.*;
import java.util.StringTokenizer;

public class A {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                long left = in.nextLong();
                long right = in.nextLong();
                long down = in.nextLong();
                long up = in.nextLong();
                long x = in.nextLong();
                long y = in.nextLong();
                long x1 = in.nextLong();
                long y1 = in.nextLong();
                long x2 = in.nextLong();
                long y2 = in.nextLong();

                long diffX = right - left;
                long diffY = up - down;

                long minX = Math.max(left, right) != 0 ? 1 : 0;
                long minY = Math.max(up, down) != 0 ? 1 : 0;

                if (minX != 0 && x2 == x1 || minY != 0 && y2 == y1) {
                    out.println("No");
                    continue;
                }

                if (x + diffX >= x1 && x + diffX <= x2 && y + diffY >= y1 && y + diffY <= y2) {
                    out.println("Yes");
                } else {
                    out.println("No");
                }
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
