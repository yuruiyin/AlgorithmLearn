package problem601_700;

public class Problem697 {

    public int findShortestSubArray(int[] nums) {
        int[] countArr = new int[50000];
        int len = nums.length;
        for (int num : nums) {
            countArr[num]++;
        }

        int maxCount = 0;
        for (int i = 0; i < 50000; i++) {
            maxCount = Math.max(maxCount, countArr[i]);
        }

        int[][] map = new int[50000][2];
        int ansMinLen = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (map[num][0] == 0) {
                map[num][0] = i + 1;
                map[num][1] = 1;
            } else {
                map[num][1]++;
            }
            if (countArr[num] == maxCount && map[num][1] == maxCount) {
                ansMinLen = Math.min(ansMinLen, i - map[num][0] + 2);
            }
        }
        return ansMinLen;
    }

}
