package round627_div3;

import java.io.*;
import java.util.Arrays;
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

        // 思路，排序+双指针
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }

            for (int i = 0; i < n; i++) {
                b[i] = in.nextLong();
            }

            // 要使用Arrays.sort最好使用包装类型(int转为Integer，long转为Long)
            Long[] diff = new Long[n];
            for (int i = 0; i < n; i++) {
                diff[i] = a[i] - b[i];
            }

            Arrays.sort(diff);

            int l = 0;
            int r = n - 1;
            long ans = 0;
            while (l < r) {
                if (diff[l] + diff[r] > 0) {
                    ans += r - l; // 说明[l, r-1] 中的每个元素+diff[r]都会大于0
                    r--;
                } else {
                    // 相加太小，让l右移
                    l++;
                }
            }

            out.println(ans);
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
