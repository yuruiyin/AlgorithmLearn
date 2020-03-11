package holiday_33;

import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class J {
    
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

        private static final long MAX = 1000000L;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int m = in.nextInt();
            int n = in.nextInt();
            int t = in.nextInt();

            boolean[] visited = new boolean[2000001];
            Set<Long> failSet = new HashSet<>();
            int diff = 2;
            for (int i = 3; i < Math.max(m, n); i++) {
                if (visited[i]) {
                    continue;
                }

                failSet.add((i + diff) * MAX + i);
                visited[i + diff] = true;
                diff++;
            }

            while ((t--) > 0) {
                int x = in.nextInt();
                int y = in.nextInt();

                if (x == 0 && y == 0) {
                    out.println("Farmer John");
                } else if (x == 0 || y == 0 || x == y) {
                    out.println("Bessie");
                } else {
                    int min = Math.min(x, y);
                    int max = Math.max(x, y);
                    if (min == 1 && max == 2 || failSet.contains(max * MAX + min)) {
                        out.println("Farmer John");
                    } else {
                        out.println("Bessie");
                    }
                }

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
