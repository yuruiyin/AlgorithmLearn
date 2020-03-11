package educational_round083;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class E {
    
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

        private int ansMin = Integer.MAX_VALUE;

        private boolean hasNeighborEqual(List<Integer> list) {
            int size = list.size();
            for (int i = 0; i < size - 1; i++) {
                if (list.get(i).equals(list.get(i + 1))) {
                    return true;
                }
            }
            return false;
        }

        private void rec(List<Integer> list) {
            if (!hasNeighborEqual(list)) {
                ansMin = Math.min(ansMin, list.size());
                return;
            }

            int size = list.size();
            for (int i = 0; i < size - 1; i++) {
                if (list.get(i).equals(list.get(i + 1))) {
                    List<Integer> nextList = new ArrayList<>();
                    if (i > 0) {
                        nextList.addAll(list.subList(0, i));
                    }

                    nextList.add(list.get(i) + 1);
                    if (i + 2 < size) {
                        nextList.addAll(list.subList(i + 2, size));
                    }

                    rec(nextList);
                }
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(in.nextInt());
            }

            rec(list);
            out.println(ansMin);
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
