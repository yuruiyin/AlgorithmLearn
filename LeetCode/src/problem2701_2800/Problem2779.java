package problem2701_2800;

import java.util.Arrays;
import java.util.LinkedList;

public class Problem2779 {

    public int maximumBeauty(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }

        Arrays.sort(nums);
        int maxCount = 0;
        LinkedList<Integer> endQueue = new LinkedList<>();
        for (int num : nums) {
            int l = num - k;
            int r = num + k;
            if (endQueue.isEmpty()) {
                endQueue.addLast(r);
            } else {
                int end = endQueue.getFirst();
                if (l > end) {
                    endQueue.pollFirst();
                }
                endQueue.addLast(r);
            }
            maxCount = Math.max(maxCount, endQueue.size());
        }
        return maxCount;
    }

}
