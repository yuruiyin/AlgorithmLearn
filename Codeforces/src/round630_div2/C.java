package round630_div2;

import java.io.*;
import java.util.StringTokenizer;

public class C {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int k = in.nextInt();
                char[] arr = in.next().toCharArray();

                int ans = 0;
                for (int i = 0; i < k; i++) {
                    int[] countArr = new int[26];
                    for (int j = i; j < n; j += k) {
                        countArr[arr[j] - 'a']++;
                    }

                    for (int j = n - i - 1; j >= 0; j -= k) {
                        countArr[arr[j] - 'a']++;
                    }

                    int maxCount = 0;
                    for (int j = 0; j < 26; j++) {
                        maxCount = Math.max(maxCount, countArr[j]);
                    }

                    ans += 2 * n / k - maxCount;
                }

                out.println(ans / 2);
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
