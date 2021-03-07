package contest.contest222;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/3
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

    public int minOperations(int[] target, int[] arr) {
        // 最长公共子序列转化成最长上升子序列
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            indexMap.put(target[i], i);
        }

        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (indexMap.containsKey(arr[i])) {
                indexList.add(indexMap.get(arr[i]));
            }
        }

        int size = indexList.size();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = indexList.get(i);
        }

        return target.length - lengthOfLISBinarySearch(nums);
    }

}
