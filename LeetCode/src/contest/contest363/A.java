package contest.contest363;

import java.util.*;

public class A {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            int bitCount = Integer.bitCount(i);
            if (bitCount == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
