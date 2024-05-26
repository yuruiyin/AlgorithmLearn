package contest.contest386;

import java.util.HashSet;
import java.util.Set;

public class C {

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int[] firstIdxArr = new int[2001];
        int m = changeIndices.length;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            if (firstIdxArr[changeIndices[i]] == 0) {
                firstIdxArr[changeIndices[i]] = i + 1;
            }
            set.add(changeIndices[i]);
        }

        if (set.size() != n) {
            return -1;
        }

        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum + n > m) {
            return -1;
        }

        int maxFirstIdx = 0;
        for (int i = 0; i <= 2000; i++) {
            maxFirstIdx = Math.max(maxFirstIdx, firstIdxArr[i]);
        }

        // sum + n <= m
        int l = (int) (sum + n);
        int r = m;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            // mid秒标记完成
            if (mid < maxFirstIdx) {
                l = mid + 1;
            } else {
                Set<Integer> visited = new HashSet<>();
                boolean isOk = true;
                int nextI = -1;
                int left = mid;
                for (int i = mid - 1; i >= 0; i--) {
                    int idx = changeIndices[i];
                    if (visited.contains(idx)) {
                        continue;
                    }
                    int value = nextI == -1 ? 0 : Math.max(0, nums[changeIndices[nextI] - 1] - (nextI - i));
                    if (nums[idx - 1] >= left - value) {
                        isOk = false;
                        break;
                    }
                    visited.add(idx);
                    nextI = i;
                    left -= value;
                }

                if (visited.size() < n || !isOk) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                    ans = mid;
                }
            }
        }

        return ans;
    }

}
