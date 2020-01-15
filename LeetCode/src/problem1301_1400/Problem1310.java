package problem1301_1400;

public class Problem1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;
        int[] prevXor = new int[len];
        prevXor[0] = arr[0];
        for (int i = 1; i < len; i++) {
            prevXor[i] = arr[i] ^ prevXor[i-1];
        }

        int qLen = queries.length;
        int[] ans = new int[qLen];

        for (int i = 0; i < qLen; i++) {
            int[] q = queries[i];
            int start = q[0];
            int end = q[1];
            if (start == 0) {
                ans[i] = prevXor[end];
            } else {
                ans[i] = prevXor[end] ^ prevXor[start-1];
            }
        }

        return ans;

    }

}
