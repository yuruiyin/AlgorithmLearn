package round632_div2;

import java.io.*;
import java.util.*;

public class C_1 {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }

            long ans = 0;

            long[] preSumArr = new long[n];
            preSumArr[0] = arr[0];
            if (preSumArr[0] != 0) {
                ans++;
            }
            Map<Long, Integer> indexMap = new HashMap<>();
            indexMap.put(preSumArr[0], 0);
            int preIndex = arr[0] == 0 ? 0 : -1;
            for (int i = 1; i < n; i++) {
                preSumArr[i] = preSumArr[i-1] + arr[i];
                if (indexMap.containsKey(preSumArr[i])) {
                    preIndex = Math.max(preIndex, indexMap.get(preSumArr[i]) + 1);
                    ans = ans + i - preIndex;
                } else {
                    if (preSumArr[i] == 0) {
                        preIndex = Math.max(preIndex, 0);
                        ans = ans + i - preIndex;
                    } else {
                        ans = ans + Math.min(i + 1, i - preIndex);
                    }
                }
                indexMap.put(preSumArr[i], i);
            }

            out.println(ans);
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
