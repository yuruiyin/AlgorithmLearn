package educational_round083;

import java.io.*;
import java.util.StringTokenizer;

public class D {
    
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

        private static final int MOD = 998244353;
        private static final int MAXN = 200001;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();

            int low = n - 1;
            int high = m;
            long ans = 0;
            CombinationInv combination = new CombinationInv(MOD, MAXN);
            for (int i = low; i <= high; i++) {
                int equalCount = i - 1;
                int leftCount = n - 3;  // 减去高点和两个相同点
                int nn = i - 2;
                long res = combination.c(nn, leftCount);
                res = (res * combination.pow(2, leftCount)) % MOD;
                ans = (ans + (equalCount * res) % MOD) % MOD;
            }

            out.println(ans);
        }
    }

    // 使用乘法逆元求组合数，当mod是素数且较大时
    public static class CombinationInv {

        private long mod;
        private long[] frac;
        private long[] inv;

        public CombinationInv(long mod, int MAXN) {
            this.mod = mod;
            frac = new long[MAXN + 10];
            inv = new long[MAXN + 10];
            frac[0] = inv[0] = 1;
            init(MAXN);
        }

        private void init(int m) {
            for (int i = 1; i <= m; i++) {
                frac[i] = frac[i - 1] * i % mod;
                inv[i] = pow(frac[i], mod - 2);
            }
        }

        // 快速pow 二分
        private long pow(long x, long n) {
            long res = 1;
            x %= mod;
            while (n > 0) {
                if ((n & 1) == 1) {
                    res = (res * x) % mod;
                }

                x = (x * x) % mod;
                n >>= 1;
            }
            return res;
        }

//    private long inv(long a) {
//        return a == 1 ? 1 : (mod - mod / a) * inv(mod % a) % mod;
//    }

        public long c(int n, int m) {
            if (m < 0 || n < m) {
                return 0;
            }

            if (m > n - m) {
                m = n - m;
            }

            return frac[n] * inv[m] % mod * inv[n - m] % mod;
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
