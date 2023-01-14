package contest.contest323;

import java.util.Arrays;

public class B {

    public int longestSquareStreak(int[] nums) {
//        2 <= nums.length <= 105
//        2 <= nums[i] <= 105

        int len = nums.length;
        Arrays.sort(nums);

        boolean[] visited = new boolean[100001];

        for (int i = 0; i < len; i++) {
            visited[nums[i]] = true;
        }

        boolean[] visited1 = new boolean[100001];
        int ansMax = -1;
        for (int i = 0; i < len; i++) {
            if (visited1[i]) {
                continue;
            }
            long num = nums[i];
            int count = 1;
            for (long next = num * num; next <= 100000; next = next * next) {
                if (!visited[(int) next]) {
                    break;
                }
                visited1[(int) next] = true;
                count++;
            }
            if (count >= 2) {
                ansMax = Math.max(ansMax, count);
            }
        }

        return ansMax;
    }

}
