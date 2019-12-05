package problem001_100;

public class Problem050_2 {

    private double dfs(double x, long n) {
        if (n == 0) {
            return 1;
        }

        double halfValue = dfs(x, n / 2);
        if ((n & 1) == 1) {
            return halfValue * halfValue * x;
        }

        return halfValue * halfValue;
    }

    // 递归分治
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return dfs(x, N);
    }

}
