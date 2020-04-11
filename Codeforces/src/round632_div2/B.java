package round632_div2;

import java.io.*;
import java.util.StringTokenizer;

public class B {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                long[] a = new long[n];
                long[] b = new long[n];
                for (int i = 0; i < n; i++) {
                    a[i] = in.nextLong();
                }
                for (int i = 0; i < n; i++) {
                    b[i] = in.nextLong();
                }

                if (a[0] != b[0]) {
                    out.println("NO");
                    continue;
                }

                boolean hasNegativeOne = a[0] == -1;
                boolean hasPositiveOne = a[0] == 1;
                boolean isOk = true;

                for (int i = 1; i < n; i++) {
                    if (b[i] == a[i]) {
                        if (a[i] == -1) {
                            hasNegativeOne = true;
                        } else if (a[i] == 1) {
                            hasPositiveOne = true;
                        }
                        continue;
                    }

                    if (b[i] < a[i]) {
                        if (!hasNegativeOne) {
                            isOk = false;
                            break;
                        }
                    } else {
                        if (!hasPositiveOne) {
                            isOk = false;
                            break;
                        }
                    }

                    if (a[i] == -1) {
                        hasNegativeOne = true;
                    } else if (a[i] == 1) {
                        hasPositiveOne = true;
                    }
                }

                if (isOk) {
                    out.println("YES");
                } else {
                    out.println("NO");
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
