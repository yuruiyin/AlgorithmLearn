package contest.contest242;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/23
 */
public class D {

    public int stoneGameVIII(int[] arr) {
        int len = arr.length;
        int ans1 = 0;
        for (int num : arr) {
            ans1 += num;
        }

        int ans2 = ans1 - arr[len - 1];
        int[] suffixSumArr = new int[len];
        suffixSumArr[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            suffixSumArr[i] = suffixSumArr[i + 1] + arr[i];
        }

        int minSuffixSum = Integer.MAX_VALUE - 1;
        for (int i = 2; i < len; i++) {
            minSuffixSum = Math.min(minSuffixSum, suffixSumArr[i]);
        }

        return Math.max(-minSuffixSum, ans1);
    }

}
