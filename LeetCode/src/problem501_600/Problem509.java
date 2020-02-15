package problem501_600;

public class Problem509 {

    private static final int MOD = (int) 1e9 + 7;

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int first = 0;
        int second = 1;

        for (int i = 2; i <= n; i++) {
            int tmp = second;
            second = (first + second) % MOD;
            first = tmp;
        }

        return second;
    }

}
