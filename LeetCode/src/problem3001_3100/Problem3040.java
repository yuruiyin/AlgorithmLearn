package problem3001_3100;

import java.util.*;

public class Problem3040 {

    private int[] scoreArr;

    private int[] nums;
    private int len;

    private Map<Integer, Integer> memoMap;

    private int rec(int l, int idx, int scoreIdx) {
        int r = len - 2 * idx + l - 1;
        if (l >= r || l >= len || r < 0) {
            return 0;
        }

        int key = scoreIdx * 1000_000 + l * 1000 + idx;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int res = 0;
        if (nums[l] + nums[l + 1] == scoreArr[scoreIdx]) {
            res = 1 + rec(l + 2, idx + 1, scoreIdx);
        }

        if (nums[l] + nums[r] == scoreArr[scoreIdx]) {
            res = Math.max(res, 1 + rec(l + 1, idx + 1, scoreIdx));
        }

        if (nums[r] + nums[r - 1] == scoreArr[scoreIdx]) {
            res = Math.max(res, 1 + rec(l, idx + 1, scoreIdx));
        }

        memoMap.put(key, res);
        return res;
    }

    public int maxOperations(int[] nums) {
        // 分数只有三种选择，同时这三种选择也可能存在相同的
        // 1. nums[0] + nums[1]
        // 2. nums[len - 2] + nums[len - 1]
        // 3. nums[0] + nums[len - 1]
        this.len = nums.length;
        this.nums = nums;
        Set<Integer> set = new HashSet<>();
        set.add(nums[0] + nums[1]);
        set.add(nums[len - 2] + nums[len - 1]);
        set.add(nums[0] + nums[len - 1]);
        // set 转 arr
        int scoreCount = set.size();
        scoreArr = new int[scoreCount];
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < scoreCount; i++) {
            scoreArr[i] = iterator.next();
        }

        memoMap = new HashMap<>();
        int ansMax = 0;
        for (int i = 0; i < scoreCount; i++) {
            ansMax = Math.max(ansMax, rec(0, 0, i));
        }
        return ansMax;
    }

}
