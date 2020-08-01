package ABC169;

import java.io.*;
import java.util.*;

public class D {

    static class Task {

        private boolean isPrime(long num) {
            for (long i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        private List<Long> getPrimeList(List<Long> factorList) {
            List<Long> primeList = new ArrayList<>();
            for (Long factor : factorList) {
                if (isPrime(factor)) {
                    primeList.add(factor);
                }
            }
            return primeList;
        }

        private boolean isExp(long num, long factor) {
            while (num > 1) {
                if (num % factor != 0) {
                    return false;
                }

                num /= factor;
            }
            return true;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long n = in.nextLong();

            if (n == 1) {
                out.println(0);
                return;
            }

            if (isPrime(n)) {
                out.println(1);
                return;
            }

            int ans = 0;
            List<Long> factorList = new ArrayList<>();
            for (long i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    factorList.add(i);
                    if (n / i != i) {
                        factorList.add(n / i);
                    }
                }
            }

            Collections.sort(factorList);
            int factorSize = factorList.size();
            List<Long> primeList = getPrimeList(factorList);
            for (int i = 0; i < factorSize; i++) {
                long factor = factorList.get(i);
                if (n == 1 || factor > n) {
                    break;
                }

                boolean isOk = false;
                for (Long prime : primeList) {
                    if (isExp(factor, prime)) {
                        isOk = true;
                        break;
                    }
                }
                if (n % factor == 0 && isOk) {
                    n /= factor;
                    ans++;
                }
            }

            out.println(ans);
        }
    }

    private static void sort(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sort(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sort(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
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
