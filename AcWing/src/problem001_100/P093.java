package problem001_100;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P093 {

    static class Task {

        private List<List<Integer>> ansList;
        private int n;
        private int m;

        private void backTrack(int cur, List<Integer> list) {
            if (list.size() == m) {
                ansList.add(new ArrayList<>(list));
                return;
            }

            if (cur == n + 1) {
                return;
            }

            // 可能后面剩下元素不够了
            if (n - cur + 1 < m - list.size()) {
                return;
            }

            // 每个元素包括选或不选
            list.add(cur);
            backTrack(cur + 1, list);
            list.remove(list.size() - 1);
            backTrack(cur + 1, list);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            ansList = new ArrayList<>();
            backTrack(1, new ArrayList<>());

            for (List<Integer> list : ansList) {
                for (Integer num : list) {
                    out.print(num + " ");
                }
                out.println();
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
