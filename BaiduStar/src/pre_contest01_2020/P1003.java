package pre_contest01_2020;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1003 {

    static class Task {

        private boolean[] isPrime;
        private int[][] memo;

        private boolean isPrime(int n) {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        }

        private void calcPrimeList() {
            isPrime = new boolean[1001];
            isPrime[1] = true;
            for (int i = 2; i <= 1000; i++) {
                if (isPrime(i)) {
                    isPrime[i] = true;
                }
            }
        }

        private int dp(int a, int b) {
            if (a == 1 || b == 1) {
                return a + b - 1;
            }

            if (a > b) {
                return dp(b, a);
            }

            if (memo[a][b] != -1) {
                return memo[a][b];
            }

            if (a == 2 || isPrime[b]) {
                int ans = a + b - 1;
                if (gcd(a, b) > 1) {
                    ans--;
                }
                memo[a][b] = ans;
                return ans;
            }

            int ans = Math.max(dp(a - 1, b), dp(a, b - 1));
            if (gcd(a, b) == 1) {
                ans++;
            }
            memo[a][b] = ans;
            return ans;
        }

        private int gcd(int a, int b) {
            return a % b == 0 ? b : gcd(b, a % b);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
//            System.out.println(isPrime(997));
            calcPrimeList();
            int t = in.nextInt();
            memo = new int[1001][1001];
            for (int i = 1; i <= 1000; i++) {
                Arrays.fill(memo[i], -1);
            }
            while ((t--) > 0) {
                int a = in.nextInt();
                int b = in.nextInt();

                int min = Math.min(a, b);
                int max = Math.max(a, b);

                out.println(dp(min, max));
            }
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
