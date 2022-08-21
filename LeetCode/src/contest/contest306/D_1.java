package contest.contest306;

public class D_1 {

    private int n;

    private int rec(long tmpNum, boolean[] visited) {
        if (tmpNum > n) {
            return 0;
        }

        int res = 1;
        for (int i = 0; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            res += rec(tmpNum * 10 + i, visited);
            visited[i] = false;
        }

        return res;
    }

    public int countSpecialNumbers(int n) {
        this.n = n;
        int ansCount = 0;
        for (int i = 1; i <= 9; i++) {
            boolean[] visited = new boolean[10];
            visited[i] = true;
            ansCount += rec(i, visited);
        }
        return ansCount;
    }

}
