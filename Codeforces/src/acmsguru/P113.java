package acmsguru;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P113 {

    static class Task {

        private boolean isPrime(int num) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        private boolean isNearlyPrime(int num) {
            // 求因子
            List<Integer> factorList = new ArrayList<>();
            int i;
            for (i = 2; i * i < num; i++) {
                if (num % i == 0) {
                    factorList.add(i);
                    factorList.add(num / i);
                    if (factorList.size() > 2) {
                        return false;
                    }

                }
            }

            if (i * i == num) {
                factorList.add(i);
                factorList.add(i);
            }

            if (factorList.size() != 2) {
                return false;
            }

            return isPrime(factorList.get(0)) && isPrime(factorList.get(1));
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            while ((n--) > 0) {
                int num = in.nextInt();
                if (isNearlyPrime(num)) {
                    out.println("Yes");
                } else {
                    out.println("No");
                }
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
