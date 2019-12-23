package problem901_1000;

import java.util.HashMap;
import java.util.Map;

public class Problem964 {

    private Map<Integer, Integer> memoMap;

    private int dfs(int x, int target) {
        if (target == x || target == 0) {
            return 0;
        }

        if (target == 1) {
            return 1; // x/x，因为target=1，x!=target,所以x!=1，因此必须使用x/x才能得到1
        }

        if (target < x) { // 只能是x/x + x/x + ... + x/x，或者x - x/x - x/x - ... - x/x
            return Math.min(2 * target - 1, 2 * (x - target));
        }

        if (memoMap.containsKey(target)) {
            return memoMap.get(target);
        }

        // target > x, 可以划分为target = x^{n} + d 或者x^{n+1} - d
        int exponent = 1;
        long power = x;
        while (power < target) {
            power *= x;
            exponent++;
        }

        if (power == target) {
            memoMap.put(target, exponent - 1);
            return exponent - 1; // 如2*2*2 = 8, 返回3-1=2
        }

        // 如x = 2， target = 7，那么可以变成2^2 + 3 or 2^3 - 1
        int lowerPower = (int) (power / x);
        int lowerExponent = exponent - 1;
        int lowerDiff = target - lowerPower;
        int lowerRes = Integer.MAX_VALUE;
        if (lowerDiff < target) {
            // 防止下一轮递归的target比这一轮还大
            lowerRes = lowerExponent + dfs(x, lowerDiff);
        }

        long higherPower = power;
        int higherExponent = exponent;
        int higherDiff = (int) (higherPower - target);
        int higherRes = Integer.MAX_VALUE;
        if (higherDiff < target) {
            higherRes = higherExponent + dfs(x, higherDiff);
        }

        int min = Math.min(lowerRes, higherRes);
        memoMap.put(target, min);
        return min;
    }

    /**
     * 思路：递归拆分数字， 2<=x<=100
     */
    public int leastOpsExpressTarget(int x, int target) {
        memoMap = new HashMap<>();
        return dfs(x, target);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem964().leastOpsExpressTarget(3, 19));
        System.out.println(new Problem964().leastOpsExpressTarget(100, 200000000));
    }

}
