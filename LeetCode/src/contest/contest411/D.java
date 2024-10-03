package contest.contest411;

public class D {

    private int[] getLeft(char[] arr, int len, int k) {
        int[] left = new int[len];
        int l = 0;
        int count0 = 0;
        int count1 = 0;
        for (int r = 0; r < len; r++) {
            if (arr[r] == '0') {
                count0++;
            } else {
                count1++;
            }

            while (count0 > k && count1 > k) {
                if (arr[l] == '0') {
                    count0--;
                } else {
                    count1--;
                }
                l++;
            }
            left[r] = l;
        }
        return left;
    }

    private int[] getRight(char[] arr, int len, int k) {
        int[] right = new int[len];
        int r = len - 1;
        int count0 = 0;
        int count1 = 0;
        for (int l = len - 1; l >= 0; l--) {
            if (arr[l] == '0') {
                count0++;
            } else {
                count1++;
            }

            while (count0 > k && count1 > k) {
                if (arr[r] == '0') {
                    count0--;
                } else {
                    count1--;
                }
                r--;
            }
            right[l] = r;
        }
        return right;
    }

    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        int[] leftArr = getLeft(arr, len, k);
        int[] rightArr = getRight(arr, len, k);
        long[] rightSumArr = new long[len];
        rightSumArr[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            rightSumArr[i] = rightSumArr[i + 1] + (rightArr[i] - i + 1);
        }

        int qLen = queries.length;
        long[] ansArr = new long[qLen];
        for (int i = 0; i < qLen; i++) {
            int[] q = queries[i];
            int l = q[0];
            int r = q[1];
            int left = leftArr[r];
            if (l >= left) {
                long n = r - l + 1;
                ansArr[i] = n * (n + 1) / 2;
            } else {
                long n = r - left + 1;
                ansArr[i] = n * (n + 1) / 2 + rightSumArr[l] - rightSumArr[left];
            }
        }
        return ansArr;
    }
}
