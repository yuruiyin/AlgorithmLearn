package round627_div3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {
    
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

        private int n;
        private int h;
        private int l;
        private int r;
        private int[] arr;
        private int[][] memo;

        private int dp(int idx, int curTime) {
            if (idx == n) {
                return curTime >= l && curTime <= r ? 1 : 0;
            }

            if (memo[idx][curTime] != -1) {
                return memo[idx][curTime];
            }

            int count = idx != 0 && curTime >= l && curTime <= r ? 1 : 0;
            int res1 = dp(idx + 1, (curTime + arr[idx]) % h);
            int res2 = dp(idx + 1, (curTime + arr[idx] - 1) % h);
            memo[idx][curTime] = Math.max(res1, res2) + count;
            return memo[idx][curTime];
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            h = in.nextInt();
            l = in.nextInt();
            r = in.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            memo = new int[n][2001];
            for (int i = 0; i < n; i++) {
                Arrays.fill(memo[i], -1);
            }
            out.println(dp(0, 0));
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
