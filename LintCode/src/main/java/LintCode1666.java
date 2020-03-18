import java.util.HashMap;
import java.util.Map;

/**
 * LintCode1666
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode1666 {

    private boolean isPrime(int num) {
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int len;
    private int[] arr;
    private Map<String, Integer> memoMap;

    private int dp(int idx, int k, int sum) {
        if (idx == len) {
            if (k == 0 && isPrime(sum)) {
                return 1;
            }
            return 0;
        }

        if (k == 0) {
            return isPrime(sum) ? 1 : 0;
        }

        if (len - idx < k) {
            return 0;
        }

        String key = idx + "_" + k + "_" + sum;

        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int chooseRes = dp(idx + 1, k - 1, sum + arr[idx]);
        int nonChooseRes = dp(idx + 1, k, sum);
        memoMap.put(key, chooseRes + nonChooseRes);
        return chooseRes + nonChooseRes;
    }

    public int getWays(int[] arr, int k) {
        // Write your code here
        this.arr = arr;
        this.len = arr.length;
        memoMap = new HashMap<>();
        return dp(0, k, 0);
    }

}
