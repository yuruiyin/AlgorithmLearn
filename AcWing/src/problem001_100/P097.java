package problem001_100;

import utils.InputReader;

import java.io.PrintWriter;

// 约数之和
public class P097 {

    private static final int MOD = 9901;

    private int pow(long x, long n) {
        long ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = ans * x % MOD;
            }

            x = x * x % MOD;
            n >>>= 1;
        }

        return (int) (ans % MOD);
    }

    private int sum(int p, int k) {
        if (k == 0) {
            return 1;
        }

        if ((k & 1) == 0) {
            return (p % MOD * sum(p, k - 1) + 1) % MOD;
        }

        return (1 + pow(p, (k >>> 1) + 1)) * sum(p, k >>> 1) % MOD;
    }

    // 约数定理
    // 参考：https://www.acwing.com/solution/acwing/content/1042/
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        long ans = 1;
        for (int i = 2; i <= a; i++) {
            int s = 0;
            while (a % i == 0) {
                s++;
                a /= i;
            }

            if (s > 0) {
                ans = ans * sum(i, s * b) % MOD;
            }
        }

        if (a == 0) {
            ans = 0;
        }

        out.println(ans);
    }
}
