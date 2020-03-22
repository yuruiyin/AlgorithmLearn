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
    private int[] suffixSumArr;

    private int dp(int idx, int count) {
        if (idx == len) {
            return 0;
        }

        int key = count * len + idx;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        if (count >= len - idx) {
            // 现有的手上的股票个数大于剩下的股票个数，则全部卖出即可
            memoMap.put(key, suffixSumArr[idx]);
            return suffixSumArr[idx];
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
        suffixSumArr = new int[len];
        suffixSumArr[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            suffixSumArr[i] = suffixSumArr[i + 1] + arr[i];
        }
        return dp(0, 0);
    }
    
    public static void main(String[] args) {
        System.out.println(new LintCode1691().getAns(new int[]{16,40,33,43,87,26,22,100,53,38,72,40,82,19,25,52,3,83}));
        System.out.println(new LintCode1691().getAns(new int[]{1, 2, 10, 9}));
    }

}
