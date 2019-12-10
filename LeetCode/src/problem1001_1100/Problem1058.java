package problem1001_1100;

import java.util.HashMap;
import java.util.Map;

public class Problem1058 {

    private double[] priceArr;
    private int len;
    private Map<Long, Double> memo;
    private int oldTarget;

    private double backTrack(int from, double target) {
        if (from == len) {
            return target == 0 ? 0 : -1;
        }

        if (target < 0) {
            return -1;
        }

        long key = (long) (from * oldTarget + target);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        double curPrice = priceArr[from];
        double floorVal = Math.floor(curPrice);
        double floorDiff = Math.abs(curPrice - floorVal);
        double floorRes = backTrack(from + 1, target - floorVal);
        double ceilVal = Math.ceil(curPrice);
        double ceilDiff = Math.abs(curPrice - ceilVal);
        double ceilRes = backTrack(from + 1, target - ceilVal);

        double ans;
        if (floorRes == -1 && ceilRes == -1) {
            ans = -1;
        } else if (floorRes == -1) {
            ans = ceilRes + ceilDiff;
        } else if (ceilRes == -1) {
            ans = floorRes + floorDiff;
        } else {
            ans = Math.min(floorRes + floorDiff, ceilRes + ceilDiff);
        }

        memo.put(key, ans);
        return ans;
    }

    public String minimizeError(String[] prices, int target) {
        oldTarget = target;
        len = prices.length;
        priceArr = new double[len];

        for (int i = 0; i < len; i++) {
            priceArr[i] = Double.parseDouble(prices[i]);
        }

        memo = new HashMap<>();
        double res = backTrack(0, target);

        if (res == -1) {
            return String.valueOf(-1);
        }

        // 保留3位小数
        return String.format("%.3f", res);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1058().minimizeError(new String[]{"0.700","2.800","4.900"}, 8));
    }

}
