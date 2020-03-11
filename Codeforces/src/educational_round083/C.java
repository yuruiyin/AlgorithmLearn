package educational_round083;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
    
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

        private int max;
        private boolean[] visited;

        private boolean isSumOfPowK(long num, int k) {
            if (num == 0) {
                return true;
            }

            boolean[] tmpVisited = new boolean[max + 1];
            for (int i = max; i >= 0; i--) {
                if (visited[i]) {
                    continue;
                }

                long pow = (long) Math.pow(k, i);
                if (pow > num) {
                    continue;
                }

                tmpVisited[i] = true;
                num -= pow;
                if (num == 0) {
                    for (int j = 0; j <= max; j++) {
                        if (tmpVisited[j]) {
                            visited[j] = true;
                        }
                    }
                    return true;
                }
            }

            return false;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int k = in.nextInt();
                long[] arr = new long[n];
                long numMax = 0;
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextLong();
                    numMax = Math.max(numMax, arr[i]);
                }

                for (int i = 0; i < 60; i++) {
                    double pow = Math.pow(k, i);
                    if (pow > numMax) {
                        max = i;
                        break;
                    }
                }

                visited = new boolean[max + 1];
                Arrays.sort(arr);
                boolean isOk = true;
                for (int i = 0; i < n; i++) {
                    if (!isSumOfPowK(arr[i], k)) {
                        isOk = false;
                        break;
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
