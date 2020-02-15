package lcof;

import java.util.HashMap;
import java.util.Map;

public class Lcof016_1 {

    // 二分
    private double dfs(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double value = (n & 1) == 1 ? x : 1;
        double halfRes = dfs(x, n / 2);
        return value * halfRes * halfRes;
    }

    public double myPow(double x, int n) {
        double ans = 1;
        ans = dfs(x, Math.abs(n));
        return n < 0 ? 1 / ans : ans;
    }

}
