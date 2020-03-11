package contest.contest179;

import java.util.ArrayList;
import java.util.List;

public class Problem02 {

    private int findFirstBigger(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target < list.get(mid)) {
                if (mid == 0 || target > list.get(mid - 1)) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return list.size();
    }

    public int numTimesAllBlue(int[] light) {
        int ans = 0;

        List<Integer> list = new ArrayList<>();
        int len = light.length;

        for (int i = 0; i < len; i++) {
            int insertIndex = findFirstBigger(list, light[i]);
            list.add(insertIndex, light[i]);
            int max = list.get(list.size() - 1);
            if (max == list.size()) {
                ans++;
            }
        }

        return ans;
    }

}
