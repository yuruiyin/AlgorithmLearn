package contest.contest262;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/10
 */
public class D {

    private int[] preSumArr;
    private int len;
    private int[] arr;

    private Map<Long, Integer> memoMap;

    private int getSum(int flag) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (flag & (1 << i)) != 0 ? arr[i] : 0;
        }
        return sum;
    }

    private int rec(int preFlag, int curIdx) {
        int preOneCount = Integer.bitCount(preFlag);
        if (curIdx == len) {
            if (preOneCount != len / 2) {
                return Integer.MAX_VALUE;
            }
            int preOneSum = getSum(preFlag);
            return Math.abs(preSumArr[len - 1] - preOneSum - preOneSum);
        }

        if (preOneCount > len / 2) {
            return Integer.MAX_VALUE;
        }

        if (preOneCount + (len - curIdx) < len / 2) {
            return Integer.MAX_VALUE;
        }

        long key = preFlag * 30L + curIdx;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int chooseRes = rec(preFlag | (1 << curIdx), curIdx + 1);
        int nonChooseRes = rec(preFlag, curIdx + 1);
        int ans = Math.min(chooseRes, nonChooseRes);
        memoMap.put(key, ans);
        return ans;
    }

    public int minimumDifference(int[] arr) {
        this.len = arr.length;
        this.arr = arr;
        preSumArr = new int[len];
        preSumArr[0] = arr[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + arr[i];
        }

        memoMap = new HashMap<>();
        return rec(0, 0);
    }
    
    public static void main(String[] args) {
        System.out.println(new D().minimumDifference(new int[]{76,8,45,20,74,84,28,1}));
    }
}
