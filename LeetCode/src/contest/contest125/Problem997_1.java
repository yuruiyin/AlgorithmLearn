package contest.contest125;

public class Problem997_1 {

    public int findJudge(int n, int[][] trusts) {
        int[] cntArr = new int[n + 1];
        for (int[] trust: trusts) {
            cntArr[trust[0]]--;
            cntArr[trust[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (cntArr[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }

}
