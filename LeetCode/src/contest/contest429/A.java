package contest.contest429;

import java.util.HashSet;
import java.util.Set;

public class A {

    public int minimumOperations(int[] nums) {
        int len = nums.length;
        int from = 0;
        int ans = 0;
        while (true) {
            Set<Integer> set = new HashSet<>();
            for (int i = from; i < len; i++) {
                set.add(nums[i]);
            }
            if (set.size() == len - from || set.isEmpty()) {
                break;
            }

            from += 3;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
