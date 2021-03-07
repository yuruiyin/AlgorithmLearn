package doubleContest.round40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/28
 */
public class D {

    // 最长上升子序列（LIS）
    private int findFirstBiggerByBinarySearch(int[] tail, int n, int target) {
        int low = 0;
        int high = n - 1;
        // 从tail数组中找到第一个比nums[i]大的元素，然后更新tail数组，若找不到，则说明nums[i] 比tail数组所有元素都大，则totalMax可以加1
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target == tail[mid]) {
                return -1;
            } else if (target < tail[mid]) {
                if(mid == 0 || tail[mid - 1] < target) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int lengthOfLISBinarySearch(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int totalMax = 1;
        int[] tail = new int[n + 1];
        tail[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int index = findFirstBiggerByBinarySearch(tail, totalMax, nums[i]);

            if (index == -1) {
                // nums[i]与tail数组中某个值相等, 不理睬
                continue;
            }

            if (index == totalMax) {
                // 说明num[i]比tail数组所有都大
                totalMax++;
            }

            tail[index] = nums[i];
        }

        return totalMax;
    }

    public int minimumMountainRemovals(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int ansMin = Integer.MAX_VALUE;
        for (int i = 1; i < len - 1; i++) {
            // 判断左右最长上升子序列的长度
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    list.add(nums[j]);
                }
            }
            int[] arr1 = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                arr1[j] = list.get(j);
            }
            int leftMax = lengthOfLISBinarySearch(arr1);

            list.clear();
            for (int j = len - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    list.add(nums[j]);
                }
            }

            int[] arr2 = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                arr2[j] = list.get(j);
            }
            int rightMax = lengthOfLISBinarySearch(arr2);
            ansMin = Math.min(ansMin, len - (leftMax + rightMax + 1));
        }

        return ansMin;
    }
    
    public static void main(String[] args) {
        System.out.println(new D().minimumMountainRemovals(new int[]{4,3,2,1,1,2,3,1}));
    }

}
