package contest.contest246;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/20
 */
public class D {

    public int[] minDifference(int[] nums, int[][] queries) {
        int len = nums.length;
        int[][] preCountArr = new int[len][101];
        preCountArr[0][nums[0]]++;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= 100; j++) {
                preCountArr[i][j] = preCountArr[i - 1][j];
            }
            preCountArr[i][nums[i]]++;
        }

        int[] ansArr = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int[] q = queries[j];
            int s = q[0];
            int e = q[1];
            int pre = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 1; i <= 100; i++) {
                int value = s == 0 ? (preCountArr[e][i]) : (preCountArr[e][i] - preCountArr[s - 1][i]);
                if (value == 0) {
                    continue;
                }

                if (pre == -1) {
                    pre = i;
                } else {
                    min = Math.min(min, i - pre);
                    pre = i;
                }
            }

            if (min == Integer.MAX_VALUE) {
                ansArr[j] = -1;
            } else {
                ansArr[j] = min;
            }
        }

        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
