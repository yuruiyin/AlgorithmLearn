package contest.contest409;

public class C {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] nextArr = new int[n];
        for (int i = 0; i < n - 1; i++) {
            nextArr[i] = i + 1;
        }

        int qLen = queries.length;
        int[] ansArr = new int[qLen];
        int pre = n - 1;
        for (int i = 0; i < qLen; i++) {
            int[] q = queries[i];
            int from = q[0];
            int to = q[1];
            if (nextArr[from] == 0) {
                ansArr[i] = ansArr[i - 1];
                continue;
            }

            int count = 0;
            for (int j = from; j < to; ) {
                int next = nextArr[j];
                nextArr[j] = 0;
                j = next;
                count++;
            }

            nextArr[from] = to;
            ansArr[i] = pre - (count - 1);
            pre = ansArr[i];
        }

        return ansArr;
    }

}
