package acmsguru;

import java.io.*;
import java.util.StringTokenizer;

public class P499 {

    static class Task {

        private int maxGcd = 1;
        private int[] factorCountArr;

        private void calcMaxGcd(int j) {
            if (factorCountArr[j] >= 2) {
                maxGcd = Math.max(maxGcd, j);
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            factorCountArr = new int[1000005];
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                for (int j = 1; j * j <= a; j++) {
                    if (j * j == a) {
                        factorCountArr[j]++;
                        calcMaxGcd(j);
                        continue;
                    }

                    if (a % j == 0) {
                        factorCountArr[j]++;
                        calcMaxGcd(j);
                        factorCountArr[a / j]++;
                        calcMaxGcd(a / j);
                    }
                }
            }

            out.println(maxGcd);
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
