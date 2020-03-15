package practice059;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D {

    static class Task {

        private Map<Long, Boolean> memo;

        private boolean isWin(long k) {
            if (k == 1) {
                return false;
            }

            if (k == 2) {
                return true;
            }

            if (k == 3) {
                return true;
            }

            if (memo.containsKey(k)) {
                return memo.get(k);
            }

            long fk = k >>> 1;
            boolean res = !isWin(fk) || !isWin(k - fk);
            memo.put(k, res);
            return res;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                long n = in.nextLong();
//                int count = 0;
//                for (int i = 0; n > 1 && i < 64; i++) {
//                    n >>>= 1;
//                    count++;
//                }

                memo = new HashMap<>();
                if (isWin(n)) {
                    out.println("XiaoHuiHui");
                } else {
                    out.println("XiaoQiao");
                }
            }
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
