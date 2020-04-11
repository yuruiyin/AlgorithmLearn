package acmsguru;

import java.io.*;
import java.util.StringTokenizer;

public class P486 {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int secret = in.nextInt();
            int guess = in.nextInt();
            String secretStr = String.format("%04d", secret);
            String guessStr = String.format("%04d", guess);

            int n = 0;
            int m = 0;
            boolean[] visited = new boolean[10];
            for (int i = 0; i < 4; i++) {
                visited[secretStr.charAt(i) - '0'] = true;
            }
            for (int i = 0; i < 4; i++) {
                if (secretStr.charAt(i) == guessStr.charAt(i)) {
                    n++;
                    continue;
                }

                if (visited[guessStr.charAt(i) - '0']) {
                    m++;
                }
            }

            out.println(n + " " + m);
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
