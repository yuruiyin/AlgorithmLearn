package problem401_500;

import java.util.HashSet;
import java.util.Set;

public class Problem421_1 {

    // 最大异或值
    // https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
    public int findMaximumXOR(int[] nums) {
        int mask = 0;
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            mask = mask | (1 << i); // 如1000..., 1100..., 11100...

            Set<Integer> prefixSet = new HashSet<>();
            for (int num : nums) {
                prefixSet.add(num & mask);
            }

            // 假设第i位可以为1，那后到prefixSet里头寻找，看看是否能找到满足a ^ b == wantAns的值，
            // 由于异或满足交换律：若a ^ b = c，则a ^ c = b 且 b ^ c = a
            int wantAns = ans | (1 << i);
            for (Integer prefix : prefixSet) {
                // 这个判断很关键，就是利用的异或交换定律。因为wantAns不可能是0，因此只要满足下面成立，
                // 即prefix和prefix ^ wantAns这两个数都存在于前缀集合里，且prefix ^ (prefix ^ wantAns) == wantAns
                if (prefixSet.contains(prefix ^ wantAns)) {
                    ans = wantAns;
                    break;
                }
            }
        }

        return ans;
    }

}
