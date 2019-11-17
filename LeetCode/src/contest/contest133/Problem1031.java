package contest.contest133;

public class Problem1031 {

    private int getMaxSum(int l, int m, int[] sumArr, int len) {
        int ansMax = Integer.MIN_VALUE;
        for (int i = l - 1; i < len - m; i++) {
            int lSum = 0;
            if (i == l - 1) {
                lSum = sumArr[i];
            } else {
                lSum = sumArr[i] - sumArr[i - l];
            }

            int maxM = Integer.MIN_VALUE;
            for (int j = i + m; j < len; j++) {
                int mSum = sumArr[j] - sumArr[j-m];
                if (mSum > maxM) {
                    maxM = mSum;
                }
            }

            int sum = lSum + maxM;
            if (sum > ansMax) {
                ansMax = sum;
            }
        }

        return ansMax;
    }

    public int maxSumTwoNoOverlap(int[] arr, int l, int m) {
        int len = arr.length;
        int[] sumArr = new int[len];
        sumArr[0] = arr[0];

        for (int i = 1; i < len; i++) {
            sumArr[i] = sumArr[i-1] + arr[i];
        }

        int max1 = getMaxSum(l, m, sumArr, len);
        int max2 = getMaxSum(m, l, sumArr, len);

        return Math.max(max1, max2);
    }
    
    public static void main(String[] args) {
        
    }
    
}
