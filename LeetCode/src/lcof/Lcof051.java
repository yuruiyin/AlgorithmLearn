package lcof;

import java.util.ArrayList;
import java.util.List;

public class Lcof051 {

    private int findFirstBigger(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target < list.get(mid)) {
                if (mid == 0 || target >= list.get(mid - 1)) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return list.size();
    }

    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len <= 1) {
            return 0;
        }

        int ans = 0;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < len; i++) {
            int firstBiggerIndex = findFirstBigger(list, nums[i]);
            ans += list.size() - firstBiggerIndex;
            list.add(firstBiggerIndex, nums[i]);
        }

        return ans;
    }

}
