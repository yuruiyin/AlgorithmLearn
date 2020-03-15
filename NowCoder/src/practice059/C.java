package practice059;

import java.io.*;
import java.util.StringTokenizer;

public class C {

    static class Task {

        private long getCount(long x, long y, long i) {
            long leftX = x - 2 * i;
            long leftY = y - 3 * i;
            long count = i + Math.min(leftX / 4, leftY);
            return count;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                long x = in.nextLong();
                long y = in.nextLong();

                long allCount1 = Math.min(x / 2, y / 3);
                long ansMax = 0;
                // 二分
                long low = 0;
                long high = allCount1;
                while (low <= high) {
                    if (low == high) {
                        ansMax = Math.max(ansMax, getCount(x, y, low));
                        break;
                    }

                    long mid = (low + high) >>> 1L;
                    long count = getCount(x, y, mid);
                    long count1 = getCount(x, y, mid + 1);
                    ansMax = Math.max(ansMax, count);
                    ansMax = Math.max(ansMax, count1);
                    if (count <= count1) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                
                out.println(ansMax);
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
