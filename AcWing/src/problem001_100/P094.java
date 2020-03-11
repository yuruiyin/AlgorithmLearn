package problem001_100;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P094 {

    static class Task {

        private int n;
        private List<List<Integer>> ansList;

        private void backTrack(List<Integer> list, boolean[] visited) {
            if (list.size() == n) {
                ansList.add(new ArrayList<>(list));
                return;
            }

            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }

                visited[i] = true;
                list.add(i);
                backTrack(list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }


        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.n = in.nextInt();
            ansList = new ArrayList<>();
            backTrack(new ArrayList<>(), new boolean[n + 1]);

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
