package acmsguru;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P358 {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = 3;
            int[] midArr = new int[3];
            for (int i = 0; i < n; i++) {
                int[] arr = new int[3];
                for (int j = 0; j < n; j++) {
                    arr[j] = in.nextInt();
                }
                Arrays.sort(arr);
                midArr[i] = arr[1];
            }
            Arrays.sort(midArr);
            out.println(midArr[1]);
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
