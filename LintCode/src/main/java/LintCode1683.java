/**
 * LintCode1683
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode1683 {

    private boolean isBiggerOrEqual(int[] aoteman, int[] guaishou) {
        for (int i = 0; i < 5; i++) {
            if (aoteman[i] < guaishou[i]) {
                return false;
            }
        }
        return true;
    }

    public int killMonster(int n, int[][] v) {
        int ans = 0;
        boolean[] visited = new boolean[n + 1];
        while (true) {
            boolean isFound = false;
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }

                if (isBiggerOrEqual(v[0], v[i])) {
                    ans++;
                    isFound = true;
                    visited[i] = true;
                    for (int j = 0; j < 5; j++) {
                        v[0][j] += v[i][j];
                    }
                }
            }

            if (!isFound) {
                return ans;
            }
        }
    }

}
