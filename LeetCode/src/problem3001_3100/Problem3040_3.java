package problem3001_3100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem3040_3 {

    private boolean done = false;

    /**
     * 记忆化搜索
     * @param l       未删除的区间左端点位置
     * @param cnt     已删除次数
     * @param score   当前分数
     * @param nums    输入的数组
     * @param n       数组大小
     * @param memoMap 记忆map
     * @return        当前状态下（l, cnt, score）还能删除的最大次数
     */
    private int rec(int l, int cnt, int score, int[] nums, int n, Map<Integer, Integer> memoMap) {
        if (done) {
            return 0;
        }
        int r = n - 2 * cnt + l - 1;
        if (l >= r) {
            done = true;
            return 0;
        }

        int key = l * 1000 + cnt;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int res = 0;
        if (nums[l] + nums[l + 1] == score) {
            res = 1 + rec(l + 2, cnt + 1, score, nums, n, memoMap);
        }

        if (nums[l] + nums[r] == score) {
            res = Math.max(res, 1 + rec(l + 1, cnt + 1, score, nums, n, memoMap));
        }

        if (nums[r] + nums[r - 1] == score) {
            res = Math.max(res, 1 + rec(l, cnt + 1, score, nums, n, memoMap));
        }

        memoMap.put(key, res);
        return res;
    }

    public int maxOperations(int[] nums) {
        // 分数只有三种选择，同时这三种选择也可能存在相同的
        int n = nums.length;
        Set<Integer> scoreSet = new HashSet<>();
        scoreSet.add(nums[0] + nums[1]);
        scoreSet.add(nums[n - 2] + nums[n - 1]);
        scoreSet.add(nums[0] + nums[n - 1]);
        int ansMax = 0;
        for (int score: scoreSet) {
            ansMax = Math.max(ansMax, rec(0, 0, score, nums, n, new HashMap<>()));
        }
        return ansMax;
    }

}
