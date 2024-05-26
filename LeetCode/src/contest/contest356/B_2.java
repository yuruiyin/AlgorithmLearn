package contest.contest356;

import java.util.HashSet;
import java.util.Set;

public class B_2 {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxNum = 0;
        for (int num : nums) {
            set.add(num);
            maxNum = Math.max(maxNum, num);
        }
        int diffCount = set.size();
        int len = nums.length;
        int ans = 0;
        int l = 0;
        int[] countArr = new int[maxNum + 1];
        int curDiffCount = 0;
        for (int e = 0; e < len; e++) {
            int num = nums[e];
            countArr[num]++;
            if (countArr[num] == 1) {
                curDiffCount++;
            }
            if (curDiffCount < diffCount) {
                continue;
            }
            ans += l + 1;
            while (true) {
                int tmpNum = nums[l];
                int count = countArr[tmpNum];
                if (count > 1) {
                    ans++;
                    countArr[tmpNum]--;
                    l++;
                } else {
                    break;
                }
            }
        }

        return ans;
    }

}
