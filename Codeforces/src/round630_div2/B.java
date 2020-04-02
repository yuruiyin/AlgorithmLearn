package round630_div2;

import java.io.*;
import java.util.*;

public class B {

    static class Task {

        private static int gcd(int m, int n) {
            return m % n == 0 ? n : gcd(n, m % n);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }

                int[] ansArr = new int[n];
                int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
                int count = 0;
                int i;
                int cur = 1;
                for (i = 0; i < primes.length; i++) {
                    boolean isFound = false;
                    for (int j = 0; j < n; j++) {
                        if (ansArr[j] == 0 && arr[j] % primes[i] == 0) {
                            ansArr[j] = cur;
                            isFound = true;
                            count++;
                        }
                    }

                    if (count == n) {
                        break;
                    }

                    if (isFound) {
                        cur++;
                    }
                }

                out.println(cur);
                for (int j = 0; j < n; j++) {
                    out.print(ansArr[j] + " ");
                }
                out.println();
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
