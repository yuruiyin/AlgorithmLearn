package acmsguru;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P231 {

    static class Task {

        private List<Integer> getAllPrimes(int n, boolean[] isNotPrime) {
            for (int i = 2; i * i <= n; i++) {
                if (isNotPrime[i]) {
                    continue;
                }

                for (int j = i * i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }

            List<Integer> primeList = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                if (!isNotPrime[i]) {
                    primeList.add(i);
                }
            }
            return primeList;
        }

        class Pair {
            int first;
            int second;
            Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            // 求n以内的所有素数
            boolean[] isNotPrime = new boolean[n + 1];
            List<Integer> primeList = getAllPrimes(n, isNotPrime);
            List<Pair> ansList = new ArrayList<>();
            // 由于奇数+奇数=偶数，而偶数不可能是质数，因此必须是偶数+奇数才可以，而是质数的偶数只有2，因此，必须有一个2
            for (Integer num : primeList) {
                if (2 + num <= n && !isNotPrime[2 + num]) {
                    ansList.add(new Pair(2, num));
                }
            }

            out.println(ansList.size());
            for (Pair pair : ansList) {
                out.println(pair.first + " " + pair.second);
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
