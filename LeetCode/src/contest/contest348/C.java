package contest.contest348;

public class C {

    public long matrixSumQueries(int n, int[][] queries) {
//        如果 typei == 0 ，将第 indexi 行的元素全部修改为 vali ，覆盖任何之前的值。
//        如果 typei == 1 ，将第 indexi 列的元素全部修改为 vali ，覆盖任何之前的值。
        long ans = 0;
        int len = queries.length;
        boolean[] rowVisited = new boolean[n];
        boolean[] colVisited = new boolean[n];
        long rowCount = 0;
        long colCount = 0;

        for (int i = len - 1; i >= 0; i--) {
            int[] q = queries[i];
            int type = q[0];
            int index = q[1];
            long val = q[2];
            if (type == 0) {
                if (rowVisited[index]) {
                    continue;
                }
                rowVisited[index] = true;
                ans += val * (n - colCount);
                rowCount++;
            } else {
                if (colVisited[index]) {
                    continue;
                }
                colVisited[index] = true;
                ans += val * (n - rowCount);
                colCount++;
            }
        }
        return ans;
    }

}
