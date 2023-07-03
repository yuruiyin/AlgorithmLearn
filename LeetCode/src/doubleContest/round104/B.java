package doubleContest.round104;

import java.util.Arrays;
import java.util.Map;

public class B {

    public int matrixSum(int[][] nums) {
        int m = nums.length;
        int n  = nums[0].length;
        for (int i = 0; i < m; i++) {
            int[] arr = nums[i];
            Arrays.sort(arr);
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, nums[i][j]);
            }
            ans += max;
        }
        return ans;
    }

}
