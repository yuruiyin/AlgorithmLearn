package contest.contest186;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/26
 */
public class B {

    public int maxScore(int[] arr, int k) {
        int len = arr.length;
        int[] preSumArr = new int[len];
        preSumArr[0] = arr[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i-1] + arr[i];
        }

        int[] sufSumArr = new int[len];
        sufSumArr[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sufSumArr[i] = sufSumArr[i + 1] + arr[i];
        }

        int ansMax = 0;
        for (int i = 0; i <= k; i++) {
            int res = 0;
            if (i == 0) {
                res = sufSumArr[len - k];
            } else if (i == k) {
                res = preSumArr[k - 1];
            } else {
                res = preSumArr[i - 1] + sufSumArr[len - (k - i)];
            }
            ansMax = Math.max(ansMax, res);
        }

        return ansMax;
    }

}
