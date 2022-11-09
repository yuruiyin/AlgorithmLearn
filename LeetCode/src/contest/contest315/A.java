package contest.contest315;

import java.util.HashSet;
import java.util.Set;

public class A {

    public int findMaxK(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ansMax = -1;
        for (int num : nums) {
            if (set.contains(-num)) {
                ansMax = Math.max(ansMax, Math.abs(num));
            }
        }

        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
