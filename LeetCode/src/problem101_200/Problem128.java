package problem101_200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem128 {

    public int longestConsecutiveBySort(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return n;
        }

        Arrays.sort(nums);

        int maxCount = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i-1] + 1) {
                count++;
            } else if (nums[i] != nums[i-1]) {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }

        maxCount = Math.max(maxCount, count);

        return maxCount;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        int maxCount = 0;

        for (int num : set) {
            if (!set.contains(num-1)) {
                // 这个num是其中一个连续递增序列的第一个元素
                int curNum = num;
                int count = 1;

                while (set.contains(++curNum)) {
                    count++;
                }

                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(new Problem128().longestConsecutiveBySort(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(new Problem128().longestConsecutiveBySort(new int[]{100}));
        System.out.println(new Problem128().longestConsecutiveBySort(new int[]{0,-1}));
        System.out.println(new Problem128().longestConsecutiveBySort(new int[]{1,2,0,1}));
    }
    
}
