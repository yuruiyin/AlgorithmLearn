package problem001_100;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P092 {

    static class Task {

        private int n;

        private void backTrack(int cur, List<Integer> list) {
            if (cur == n + 1) {
                for (Integer num: list) {
                    System.out.print(num + " ");
                }
                System.out.println();
                return;
            }

            // 每个数选或不选
            backTrack(cur + 1, list);
            list.add(cur);
            backTrack(cur + 1, list);
            list.remove(list.size() - 1);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            backTrack(1, new ArrayList<>());
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
