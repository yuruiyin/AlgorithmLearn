package problem3001_3100;

import java.util.*;

public class Problem3040_2 {

    private int[] nums;
    private int len;
    private boolean done = false;
    private Map<Integer, Integer> memoMap;

    /**
     * 记忆化搜索
     * @param l     未删除的区间左端点位置
     * @param cnt   已删除次数
     * @param score 当前分数
     * @return      当前状态下（l, cnt, score）还能删除的最大次数
     */
//    private int rec(int l, int cnt, int score) {
//        if (done) {
//            return 0;
//        }
//
//        int r = len - 2 * cnt + l - 1;
//        if (l >= r) {
//            done = true;
//            return 0;
//        }
////        if (l >= len || r < 0) {
////            return 0;
////        }
//
//        int key = l * 1000 + cnt;
//        if (memoMap.containsKey(key)) {
//            return memoMap.get(key);
//        }
//
//        int res = 0;
//        int numL = nums[l];
//        int numLPlus1 = nums[l + 1];
//        int numR = nums[r];
//        int numRMinus1 = nums[r - 1];
//        if (numL + numLPlus1 == score) {
//            res = 1 + rec(l + 2, cnt + 1, score);
//        }
//
//        if (numL + numR == score) {
//            res = Math.max(res, 1 + rec(l + 1, cnt + 1, score));
//        }
//
//        if (numR + numRMinus1 == score) {
//            res = Math.max(res, 1 + rec(l, cnt + 1, score));
//        }
//
//        memoMap.put(key, res);
//        return res;
//    }

    private int rec(int l, int cnt, int score) {
        // 通过l和cnt计算当前右端点位置
        int r = len - 2 * cnt + l - 1;
        if (l >= r) {
            // 一些终止条件
            return 0;
        }

        // 判断是否命中缓存，算过就不要重复算了
        int key = l * 1000 + cnt;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        // 以下有三种选择，计算3种选择的最大值
        int res = 0;
        // 选择1：删除最前面两个元素
        if (nums[l] + nums[l + 1] == score) {
            res = 1 + rec(l + 2, cnt + 1, score);
        }

        // 选择2：删除第一个和最后一个元素
        if (nums[l] + nums[r] == score) {
            res = Math.max(res, 1 + rec(l + 1, cnt + 1, score));
        }

        // 选择3：删除最后两个元素
        if (nums[r - 1] + nums[r] == score) {
            res = Math.max(res, 1 + rec(l, cnt + 1, score));
        }

        // 记忆
        memoMap.put(key, res);
        return res;
    }

    public int maxOperations(int[] nums) {
        // 分数只有三种选择，同时这三种选择也可能存在相同的
        this.len = nums.length;
        this.nums = nums;
        Set<Integer> scoreSet = new HashSet<>();
        scoreSet.add(nums[0] + nums[1]);
        scoreSet.add(nums[len - 2] + nums[len - 1]);
        scoreSet.add(nums[0] + nums[len - 1]);
        int ansMax = 0;
        for (int score: scoreSet) {
            memoMap = new HashMap<>();
            ansMax = Math.max(ansMax, rec(0, 0, score));
        }
        return ansMax;
    }

}
