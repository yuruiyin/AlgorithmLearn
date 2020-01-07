package contest.contest105;

public class Problem918 {

    public int maxSubarraySumCircular(int[] arr) {
        int len = arr.length;

        if (len == 1) {
            return arr[0];
        }

        int[] prefixSumArr = new int[len];
        prefixSumArr[0] = arr[0];
        for (int i = 1; i < len; i++) {
            prefixSumArr[i] = prefixSumArr[i-1] + arr[i];
        }

        int[] suffixSumArr = new int[len];
        suffixSumArr[len - 1] = arr[len-1];
        for (int i = len - 2; i >= 0; i--) {
            suffixSumArr[i] = suffixSumArr[i+1] + arr[i];
        }

        int[] suffixSumMaxArr = new int[len];
        suffixSumMaxArr[len - 1] = suffixSumArr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            suffixSumMaxArr[i] = Math.max(suffixSumArr[i], suffixSumMaxArr[i+1]);
        }

        int[] prefixSumMinArr = new int[len];
        prefixSumMinArr[0] = prefixSumArr[0];
        for (int i = 1; i < len; i++) {
            prefixSumMinArr[i] = Math.min(prefixSumArr[i], prefixSumMinArr[i-1]);
        }

        int ansMax = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (i == len - 1 || suffixSumMaxArr[i+1] <= 0) {
                if (i == 0) {
                    ansMax = Math.max(ansMax, arr[0]);
                    continue;
                }
                if (prefixSumMinArr[i-1] >= 0) {
                    ansMax = Math.max(ansMax, prefixSumArr[i]);
                } else {
                    ansMax = Math.max(ansMax, prefixSumArr[i] - prefixSumMinArr[i-1]);
                }
            } else {
                if (i == 0) {
                    ansMax = Math.max(ansMax, arr[0] + suffixSumMaxArr[i+1]);
                } else {
                    int tmpMax = Integer.MIN_VALUE;
                    if (prefixSumMinArr[i-1] >= 0) {
                        tmpMax = Math.max(tmpMax, prefixSumArr[i]);
                    } else {
                        tmpMax = Math.max(tmpMax, prefixSumArr[i] - prefixSumMinArr[i-1]);
                    }

                    tmpMax = Math.max(tmpMax, prefixSumArr[i] + suffixSumMaxArr[i+1]);
                    ansMax = Math.max(ansMax, tmpMax);
                }
            }
        }

        return ansMax;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem918().maxSubarraySumCircular(new int[]{5,-3,5}));
    }

}
