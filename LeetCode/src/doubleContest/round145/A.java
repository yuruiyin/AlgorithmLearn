package doubleContest.round145;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A {

    public int minOperations(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() == 1) {
            return Integer.compare(nums[0], k);
        }

        int newLen = set.size();
        int[] arr = new int[newLen];
        int idx = 0;
        for (int num : set) {
            arr[idx++] = num;
        }

        Arrays.sort(arr);

        if (k == arr[newLen - 1]) {
            return -1;
        }

        if (k > arr[0]) {
            return -1;
        }

        if (k == arr[0]) {
            return newLen - 1;
        }

        return newLen;
    }

}
