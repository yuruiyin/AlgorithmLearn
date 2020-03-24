package ABC159;

import java.io.*;
import java.util.StringTokenizer;

public class D {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            long[] countArr = new long[n + 1];
            for (int i = 0; i < n; i++) {
                countArr[arr[i]]++;
            }

            long ans = 0;
            for (int i = 1; i <= n; i++) {
                if (countArr[i] <= 1) {
                    continue;
                }

                ans += (countArr[i] - 1) * countArr[i] / 2;
            }

            for (int i = 0; i < n; i++) {
                if (countArr[arr[i]] <= 1) {
                    out.println(ans);
                } else {
                    out.println(ans - (countArr[arr[i]] - 1));
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
