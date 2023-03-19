package contest.contest334;

import java.lang.reflect.Array;
import java.util.Arrays;

public class C {

    private int findFirstBiggerOrEqual(int[] arr, int from, int target) {
        int low = from;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = arr[mid];
            if (midVal >= target) {
                if (mid == from || arr[mid - 1] < target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        boolean[] visited = new boolean[len];
        int fromIdx = len / 2;
        for (int i = 0; i < len / 2; i++) {
            int next = nums[i] * 2;
            int firstBiggerOrEqualIdx = findFirstBiggerOrEqual(nums, fromIdx, next);
            if (firstBiggerOrEqualIdx == -1) {
                break;
            }
            visited[i] = true;
            visited[firstBiggerOrEqualIdx] = true;
            fromIdx = firstBiggerOrEqualIdx + 1;
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                ans++;
            }
        }
        return ans;
    }

}
