package contest.contest206;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/13
 */
public class B {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                map[i][preferences[i][j]] = n - 1 - j;
            }
        }

        int ans = 0;
        int pairLen = pairs.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < pairLen; i++) {
            for (int j = 0; j < pairLen; j++) {
                if (i == j) {
                    continue;
                }

                for (int k = 0; k <= 1; k++) {
                    for (int l = 0; l <= 1; l++) {
                        int x = pairs[i][k];
                        int y = pairs[i][(k + 1) % 2];

                        int u = pairs[j][l];
                        int v = pairs[j][(l + 1) % 2];

                        if (map[x][u] > map[x][y] && map[u][x] > map[u][v]) {
                            set.add(x);
                        }
                    }
                }
            }
        }

        return set.size();
    }

}
