package contest.contest218;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/6
 */
public class D {

    private Map<String, Integer> memoMap;
    private int[] nums;
    private int len;
    private int k;
    private int eachCount;

    private String arrToString(TreeSet<Integer>[] tmpArr) {
        StringBuilder ansSb = new StringBuilder();
        for (TreeSet<Integer> treeSet : tmpArr) {
            for (Integer num : treeSet) {
                ansSb.append(num);
                ansSb.append(',');
            }
            ansSb.append('.');
        }
        return ansSb.toString();
    }

    private int dp(int idx, TreeSet<Integer>[] tmpArr) {
        if (idx == len) {
            int ans = 0;
            for (int i = 0; i < k; i++) {
                ans += tmpArr[i].last() - tmpArr[i].first();
            }
            return ans;
        }

        String key = arrToString(tmpArr);
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int ansMin = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            if (tmpArr[i].contains(nums[idx]) || tmpArr[i].size() == eachCount) {
                continue;
            }

            tmpArr[i].add(nums[idx]);
            int tmpAns = dp(idx + 1, tmpArr);
            if (tmpAns != -1) {
                ansMin = Math.min(ansMin, tmpAns);
            }
            tmpArr[i].remove(nums[idx]);
        }

        if (ansMin == Integer.MAX_VALUE) {
            memoMap.put(key, -1);
            return -1;
        }

        memoMap.put(key, ansMin);
        return ansMin;
    }

    public int minimumIncompatibility(int[] nums, int k) {
        this.nums = nums;
        this.len = nums.length;
        this.k = k;
        this.eachCount = len / k;
        memoMap = new HashMap<>();
        TreeSet<Integer>[] treeSets = new TreeSet[k];
        for (int i = 0; i < k; i++) {
            treeSets[i] = new TreeSet<>();
        }
        return dp(0, treeSets);
    }
    
    public static void main(String[] args) {
        System.out.println(new D().minimumIncompatibility(new int[]{1,2,1,4}, 2));
        System.out.println(new D().minimumIncompatibility(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}, 4));
    }

}
