package problems;

import java.io.*;
import java.util.StringTokenizer;

public class P20443 {

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

        private int calcCount(String word, String str) {
            int wordLen = word.length();
            int ansCount = 0;
            for (int i = 0; i < str.length(); i++) {
                if (i + wordLen > str.length()) {
                    continue;
                }

                boolean isEqual = true;
                for (int j = 0; j < wordLen; j++) {
                    if (word.charAt(j) != str.charAt(i + j)) {
                        isEqual = false;
                        break;
                    }
                }

                if (isEqual) {
                    ansCount++;
                }
            }
            return ansCount;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = in.next();
            }

            for (int i = 0; i < n; i++) {
                int ansCount = 0;
                String word = words[i];
                for (int j = 0; j < n; j++) {
                    ansCount += calcCount(word, words[j]);
                }
                out.println(ansCount);
            }

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
