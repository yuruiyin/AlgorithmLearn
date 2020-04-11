package acmsguru;

import java.io.*;
import java.util.StringTokenizer;

public class P460 {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            while ((n--) > 0) {
                String word = in.next();
                if (word.endsWith("ch") || word.endsWith("x") || word.endsWith("s") || word.endsWith("o")) {
                    out.println(word + "es");
                } else if (word.endsWith("f")) {
                    out.println(word.substring(0, word.length() - 1) + "ves");
                } else if (word.endsWith("fe")) {
                    out.println(word.substring(0, word.length() - 2) + "ves");
                } else if (word.endsWith("y")) {
                    out.println(word.substring(0, word.length() - 1) + "ies");
                } else {
                    out.println(word + "s");
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
