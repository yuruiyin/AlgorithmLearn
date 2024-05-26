package contest.contest363;

import java.util.*;

public class D {

    private long ansMax = 0;

    private int[] arr;

    private int len;

    // 判断是否完全平方数
    private boolean isOk(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    private void dfs(int idx, List<Integer> tmpIdxList) {
        if (idx == len) {
            long sum = 0;
            for (int tmpIdx: tmpIdxList) {
                sum += arr[tmpIdx];
            }
            ansMax = Math.max(ansMax, sum);
            return;
        }

        // 选，下一个idx
        for (int i = idx; i < len; i++) {
            boolean isYes = true;
            for (int preIdx: tmpIdxList) {
                int num = (i + 1) * (preIdx + 1);
                if (!isOk(num)) {
                    isYes = false;
                    break;
                }
            }
            if (isYes) {
                tmpIdxList.add(i);
                dfs(i + 1, tmpIdxList);
                tmpIdxList.remove(tmpIdxList.size() - 1);
                dfs(i + 1, tmpIdxList);
            }
        }
    }

    public long maximumSum(List<Integer> nums) {
        this.len = nums.size();
        this.arr = new int[this.len];
        for (int i = 0; i < len; i++) {
            arr[i] = nums.get(i);
        }
        dfs(0, new ArrayList<>());
        return ansMax;
    }

}
