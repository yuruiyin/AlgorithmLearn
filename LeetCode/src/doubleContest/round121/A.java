package doubleContest.round121;

import java.util.HashSet;
import java.util.Set;

public class A {

    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int len = nums.length;
        int maxPreSum = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                maxPreSum += nums[i];
            } else {
                break;
            }
        }

        for (int i = maxPreSum; ;i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
