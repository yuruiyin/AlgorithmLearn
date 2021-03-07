package contest.contest218;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/6
 */
public class D_1 {

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
        Arrays.sort(nums);
        int l = 0;
        int r = 300;
        int ans = -1;
        while (l <= r) {
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new D_1().minimumIncompatibility(new int[]{1,2,1,4}, 2));
        System.out.println(new D_1().minimumIncompatibility(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}, 4));
    }

}
