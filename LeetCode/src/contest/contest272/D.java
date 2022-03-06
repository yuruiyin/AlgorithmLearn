package contest.contest272;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/12/19
 */
public class D {

    int ceilIndex(int arr[], int left, int right, int value) {
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= value)
                right = mid;
            else
                left = mid;
        }
        return right;
    }

    int longestIncreasingSub(int arr[], int size) {
        int[] tail = new int[size];
        int len; // always points empty slot
        tail[0] = arr[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (arr[i] < tail[0]) {
                tail[0] = arr[i];// new smallest value
            } else if (arr[i] > tail[len - 1]) {
                // A[i] wants to extend largest subsequence
                tail[len++] = arr[i];
            } else {
                // 使用二分法查找
                tail[ceilIndex(tail, -1, len - 1, arr[i])] = arr[i];
            }
        }
        return len;
    }

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
                if (mid == 0 || tail[mid - 1] < target) {
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
                totalMax++;

            }

            if (index == totalMax) {
                // 说明num[i]比tail数组所有都大
                totalMax++;
            }

            tail[index] = nums[i];
        }

        return totalMax;
    }

    public int kIncreasing(int[] arr, int k) {
        int ans = 0;
        int len = arr.length;
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            for (int offset = k; i + offset < len; offset += k) {
                list.add(arr[i + offset]);
            }
            int size = list.size();
            int[] tmpArr = new int[size];
            for (int j = 0; j < size; j++) {
                tmpArr[j] = list.get(j);
            }
            ans += size - longestIncreasingSub(tmpArr, size);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().kIncreasing(new int[]{4, 1, 5, 2, 6, 2}, 2));
    }

}
