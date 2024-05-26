package doubleContest.round116;

import java.util.*;

public class A {

    private static final int MOD = (int) (1e9 + 7);

    public int sumCounts(List<Integer> nums) {
        int len = nums.size();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < len; j++) {
                set.add(nums.get(j));
                int size = set.size();
                sum = (sum + size * size) % MOD;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
