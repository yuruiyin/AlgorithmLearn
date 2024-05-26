package contest.contest356;

import java.util.HashSet;
import java.util.Set;

public class B {

    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int diffCount = set.size();
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            boolean[] visited = new boolean[2001];
            int count = 0;
            for (int j = i; j < len; j++) {
                int num = nums[j];
                if (!visited[num]) {
                    count++;
                    visited[num] = true;
                }

                if (count == diffCount) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
