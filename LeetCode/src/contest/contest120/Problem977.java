package contest.contest120;

import java.util.Arrays;

public class Problem977 {

    public int[] sortedSquares(int[] arr) {
        int len = arr.length;
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            ans[i] = arr[i] * arr[i];
        }

        Arrays.sort(ans);

        return ans;
    }

}
