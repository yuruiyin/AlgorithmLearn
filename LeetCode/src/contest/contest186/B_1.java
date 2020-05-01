package contest.contest186;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/26
 */
public class B_1 {

    public int maxScore(int[] arr, int k) {
        int len = arr.length;
        int[] preSumArr = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSumArr[i + 1] = preSumArr[i] + arr[i];
        }

        int ansMax = 0;
        for (int i = 0; i <= k; i++) {
            ansMax = Math.max( ansMax, preSumArr[i] + preSumArr[len] - preSumArr[len - (k - i)]);
        }

        return ansMax;
    }

}
