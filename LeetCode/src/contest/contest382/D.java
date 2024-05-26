package contest.contest382;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class D {

    public int minOrAfterOperations(int[] nums, int k) {
        int len = nums.length;
        TreeSet<Integer>[] bitIdxListArr = new TreeSet[32];
        Arrays.setAll(bitIdxListArr, value -> new TreeSet<>());
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            for (int j = 0; j < 32 && num > 0; j++) {
                int bit = num & 1;
                num >>= 1;
                if (bit == 1) {
                    bitIdxListArr[j].add(i);
                }
            }
        }

        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            TreeSet<Integer> bitIdxSet = bitIdxListArr[i];
            int bitCount = bitIdxSet.size();
            if (bitCount == 0) {
                continue;
            }

            if (bitCount > k || bitCount == len) {
                ans |= (1 << i);
                continue;
            }

            // bitCount <= k，可执行k次操作将当前位全部变成0
            // 但是问题出在需要如何选择这k次操作：贪心
            k -= bitCount;
            while (!bitIdxSet.isEmpty()) {
                int idx = bitIdxSet.pollFirst();
                if (idx == 0) {

                }
            }
            for (int j = 0; j < len - 1; j++) {
                if (bitIdxSet.contains(j)) {
                    // 当前位是1
                    if (bitIdxSet.contains(j + 1)) {
                        // 下一位也是1

                    } else {
                        // 下一位是0

                    }
                } else {

                }
            }

        }

        return 0;
    }

}
