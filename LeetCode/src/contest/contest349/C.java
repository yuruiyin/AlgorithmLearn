package contest.contest349;

public class C {

    public long minCost(int[] nums, int x) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int minIdx = -1;
        long minNum = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] < minNum) {
                minNum = nums[i];
                minIdx = i;
            }
        }

        int[] arr = new int[len * 2];
        for (int i = 0; i < len; i++) {
            arr[i] = nums[i];
            arr[i + len] = nums[i];
        }

        int[][] minCostArr = new int[len][len];
        for (int i = 0; i < len; i++) {
            minCostArr[i][0] = arr[i];
            for (int j = 1; j < len; j++) {
                minCostArr[i][j] = Math.min(minCostArr[i][j - 1], arr[i + j]);
            }
        }

        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            long cost = minNum + (long)i * x + i * minNum;
            int leftCount = len - i - 1;
            for (int count = 1; count <= leftCount; count++) {
                int j = (minIdx + count) % len;
                cost += minCostArr[j][i];
            }
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

}
