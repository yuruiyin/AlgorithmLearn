import dsu.TreeDSU;
import utils.InputTest;

import java.io.*;
import java.util.StringTokenizer;

/**
 * P3367
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class P3367 {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            TreeDSU dsu = new TreeDSU(n);
            while ((m--) > 0) {
                int z = in.nextInt();
                int x = in.nextInt();
                int y = in.nextInt();

                if (z == 1) {
                    dsu.union(x - 1, y - 1);
                } else {
                    System.out.println(dsu.connected(x - 1, y - 1) ? "Y" : "N");
                }
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
