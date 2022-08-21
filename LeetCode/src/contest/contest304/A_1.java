package contest.contest304;

import java.util.HashSet;
import java.util.Set;

public class A_1 {

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num != 0) {
                set.add(num);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
