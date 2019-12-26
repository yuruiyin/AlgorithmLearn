package contest.contest168;

import java.util.Arrays;

public class Problem1296 {

    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;

        if (len % k != 0) {
            return false;
        }

        Arrays.sort(nums);

        boolean[] visited = new boolean[len];
        int kCount = 0;
        int needKCount = len / k;
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            int prev = nums[i];
            int count = 1;
            visited[i] = true;
            for (int j = i + 1; j < len; j++) {
                if (visited[j]) {
                    continue;
                }

                if (count == k) {
                    break;
                }

                if (nums[j] > prev + 1) {
                    return false;
                }

                if (nums[j] == prev + 1) {
                    count++;
                    visited[j] = true;
                    prev = nums[j];
                }
            }

            if (count < k) {
                return false;
            }

            kCount++;
            if (kCount == needKCount) {
                return true;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        
    }
    
}
