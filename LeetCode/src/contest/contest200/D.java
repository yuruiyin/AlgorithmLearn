package contest.contest200;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/2
 */
public class D {

    private static final long MOD = (int) (1e9+7);

    private Map<Integer, Integer> indexMap1;
    private Map<Integer, Integer> indexMap2;
    private int len1;
    private int len2;
    private Map<Integer, Long> memoMap;
    private int[] nums1;
    private int[] nums2;
    private long[] sufSumArr1;
    private long[] sufSumArr2;

    private long dp(int curNum) {
        if (memoMap.containsKey(curNum)) {
            return memoMap.get(curNum);
        }

        int index1 = indexMap1.getOrDefault(curNum, -1);
        int index2 = indexMap2.getOrDefault(curNum, -1);

        if (curNum > nums1[len1 - 1]) {
            return sufSumArr2[index2];
        }

        if (curNum > nums2[len2 - 1]) {
            return sufSumArr1[index1];
        }

        long ans;
        if (index1 == -1) {
            if (index2 == len2 - 1) {
                ans = curNum;
            } else {
                ans = curNum + dp(nums2[index2 + 1]);
            }
        } else if (index2 == -1) {
            if (index1 == len1 - 1) {
                ans = curNum;
            } else {
                ans = curNum + dp(nums1[index1 + 1]);
            }
        } else {
            if (index1 == len1 - 1 && index2 == len2 - 1) {
                ans = curNum;
            } else if (index1 == len1 - 1) {
                ans = curNum + dp(nums2[index2 + 1]);
            } else if (index2 == len2 - 1) {
                ans = curNum + dp((nums1[index1 + 1]));
            } else {
                long res1 = curNum + dp(nums1[index1 + 1]);
                long res2 = curNum + dp(nums2[index2 + 1]);
                ans = Math.max(res1, res2);
            }

        }

        memoMap.put(curNum, ans);
        return ans;
    }

    private void calcSufSumArr(long[] sufSumArr, int[] nums) {
        int len = nums.length;
        sufSumArr[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sufSumArr[i] = sufSumArr[i + 1] + nums[i];
        }
    }

    private void calcSufSumArrs() {
        sufSumArr1 = new long[len1];
        calcSufSumArr(sufSumArr1, nums1);
        sufSumArr2 = new long[len2];
        calcSufSumArr(sufSumArr2, nums2);
    }

    public int maxSum(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        indexMap1 = new HashMap<>();
        indexMap2 = new HashMap<>();
        len1 = nums1.length;
        len2 = nums2.length;

        for (int i = 0; i < len1; i++) {
            indexMap1.put(nums1[i], i);
        }

        for (int i = 0; i < len2; i++) {
            indexMap2.put(nums2[i], i);
        }

        calcSufSumArrs();

        memoMap = new HashMap<>();

        long ans1 = dp(nums1[0]);
        long ans2 = dp(nums2[0]);

        return (int) ((Math.max(ans1, ans2)) % MOD);
    }
    
    public static void main(String[] args) {
//        System.out.print(new D().maxSum(new int[]{2,4,5,8,10}, new int[]{4,6,8,9}));
        System.out.print(new D().maxSum(new int[]{2,4}, new int[]{4,6}));
    }

}
