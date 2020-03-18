import java.util.HashMap;
import java.util.Map;

/**
 * LintCode1691
 * stack overflow
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode1691 {

    private int[] arr;
    private int len;
    private Map<Integer, Integer> memoMap;

    private int dp(int idx, int count) {
        if (idx == len) {
            return 0;
        }

        int key = count * len + idx;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        // 三种选择，买入、卖出或者放弃交易
        int buyRes = dp(idx + 1, count + 1) - arr[idx];
        int saleRes = count == 0 ? 0 : dp(idx + 1, count - 1) + arr[idx];
        int nonRes = dp(idx + 1, count);
        int max = Math.max(buyRes, Math.max(saleRes, nonRes));
        memoMap.put(key, max);
        return max;
    }

    public int getAns(int[] arr) {
        this.arr = arr;
        this.len = arr.length;
        memoMap = new HashMap<>();
        return dp(0, 0);
    }

}
