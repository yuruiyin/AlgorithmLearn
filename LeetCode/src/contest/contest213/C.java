package contest.contest213;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * C
 *
 * @author: yry
 * @date: 2021/5/15
 */
class C {
    private boolean isOk(int[] heights, int bricks, int ladders, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= end; i++) {
            if (heights[i] > heights[i - 1]) {
                list.add(heights[i] - heights[i - 1]);
            }
        }

        if (list.isEmpty()) {
            return true;
        }

        Collections.sort(list);
        int size = list.size();
        int i;
        for (i = size - 1; i >= 0 && ladders > 0; i--, ladders--);

        if (i < 0) {
            return true;
        }

        int sum = 0;
        for (int j = i; j >= 0; j--) {
            sum+=list.get(j);
        }

        return sum <= bricks;
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // 二分
        int l = 0;
        int r = heights.length - 1;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOk(heights, bricks,ladders, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}
