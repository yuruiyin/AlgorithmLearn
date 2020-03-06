package lcci;

public class Lcci0801 {

    private static final int MOD = 1000000007;

    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (n == 3) {
            return 4;
        }

        long first = 1;
        long second = 2;
        long third = 4;

        for (int i = 4; i <= n; i++) {
            long oldThird = third;
            third = (first + second + third) % MOD;
            long oldSecond = second;
            second = oldThird;
            first = oldSecond;
        }

        return (int) third;
    }

}
