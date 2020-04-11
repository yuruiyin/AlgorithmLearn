package acmsguru;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P154 {

    static class Task {

        // n阶乘的尾0个数，其实就是计算有多少个5
        private int tailZeroCount(int n) {
            int ans = 0;
            while (n > 0) {
                ans += n / 5;
                n /= 5;
            }
            return ans;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int tailZeroCount = in.nextInt();
            // 因子中5的个数 就是尾0的个数，因此5*2会产生0，而且5比2多, 但是25是有两个5、以此类推
            if (tailZeroCount == 0) {
                out.println(1);
                return;
            }

            // 因此我们只要二分n即可
            int low = 1;
            int high = 5 * tailZeroCount;
            int ans = 0;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int count = tailZeroCount(mid);
                if (count >= tailZeroCount) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (tailZeroCount(ans) == tailZeroCount) {
                out.println(ans);
            } else {
                out.println("No solution");
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
