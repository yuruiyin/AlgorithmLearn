package acmsguru;

import java.io.*;
import java.util.StringTokenizer;

public class P107 {

    static class Task {
        // 最n位数的平方 末尾是987654321的 个数
        // 思路，最后一位是1必须是1*1或者9*9
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();

            // n <= 8， 没有数字
            // n == 9, 有8个
            // n >= 10 低9位是固定的8种，最高位是1-9, 中间n - 10位每位可以有10种
//            for (long i = 30000; i <= 9999999999L; i++) {
//                long x = i * i;
//                if (x % 1000000000 == 987654321) {
//                    System.out.print(i + " ");
//                }
//            }

            if (n <= 8) {
                out.println(0);
            } else if (n == 9) {
                out.println(8);
            } else {
                out.print(72);
                while ((n--) > 10) {
                    out.print(0);
                }
                out.println();
            }
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
