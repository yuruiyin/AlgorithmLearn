package doubleContest.round172;

import java.util.HashSet;
import java.util.Set;

public class A {

    public int minOperations(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = len - 1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                return (i + 1) / 3 + ((i + 1) % 3 == 0 ? 0 : 1);
            }
            set.add(nums[i]);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
