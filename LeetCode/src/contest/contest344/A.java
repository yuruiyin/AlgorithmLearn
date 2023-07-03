package contest.contest344;

import java.util.HashSet;
import java.util.Set;

public class A {

    public int[] distinctDifferenceArray(int[] nums) {
        int len = nums.length;
        int[] diff = new int[len];
        Set<Integer> preSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            preSet.add(nums[i]);
            Set<Integer> sufSet = new HashSet<>();
            for (int j = i + 1; j < len; j++) {
                sufSet.add(nums[j]);
            }
            diff[i] = preSet.size() - sufSet.size();
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
