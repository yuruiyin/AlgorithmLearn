package contest.contest269;

/**
* a
*
* @author: yry
* @date: 2021/11/28
*/
public class B {

    public int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        long[] preSumArr = new long[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }

        int[] ansArr = new int[len];
        for (int i = 0; i < len; i++) {
            int l = i - k;
            int r = i + k;
            if (l < 0 || r >= len) {
                ansArr[i] = -1;
                continue;
            }

            long sum = preSumArr[r] - (l == 0 ? 0 : preSumArr[l - 1]);
            ansArr[i] = (int) (sum / (2 * k + 1));
        }

        return ansArr;
    }

}
