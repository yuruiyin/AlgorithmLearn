package contest.contest344;

public class C {

    public int[] colorTheArray(int n, int[][] queries) {
        int len = queries.length;
        int[] ansArr = new int[len];
        int[] arr = new int[n];
        int preCount = 0;
        for (int i = 0; i < len; i++) {
            int[] q = queries[i];
            int idx = q[0];
            int color = q[1];
            if (idx > 0) {
                if (arr[idx] != 0 && arr[idx] == arr[idx - 1] && color != arr[idx]) {
                    preCount--;
                }
                if (arr[idx] != arr[idx - 1] && color == arr[idx - 1]) {
                    preCount++;
                }
            }
            if (idx < n - 1) {
                if (arr[idx] != 0 && arr[idx] == arr[idx + 1] && color != arr[idx]) {
                    preCount--;
                }
                if (arr[idx] != arr[idx + 1] && color == arr[idx + 1]) {
                    preCount++;
                }
            }
            arr[idx] = color;
            ansArr[i] = preCount;
        }
        return ansArr;
    }


}
