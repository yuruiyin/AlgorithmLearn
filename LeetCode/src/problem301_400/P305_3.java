package problem301_400;

import java.util.ArrayList;
import java.util.List;

public class P305_3 {

    /**
     * 优化3：并查集合并的时候总是选择小岛屿往最大岛屿合并
     * 10ms
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ansList = new ArrayList<>(positions.length);
        int[][] grid = new int[m][n];
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        int max = m * n;

        // <key, id>
        int[] idArr = new int[max + 2];
        int curId = 1;

        // <id, key list>
        List<Integer>[] idSetList = new ArrayList[max / 2 + 2];
        int islandCount = 0;

        for (int[] pos : positions) {
            int r = pos[0];
            int c = pos[1];
            if (grid[r][c] == 1) {
                ansList.add(islandCount);
                continue;
            }

            int maxCountId = -1;
            int maxCount = 0;
            int[] tmpKeyArr = new int[4];
            int idx = 0;
            for (int i = 0; i < 4; i++) {
                int newR = r + dx[i];
                int newC = c + dy[i];
                if (newR < 0 || newR >= m || newC < 0 || newC >= n || grid[newR][newC] == 0) {
                    continue;
                }

                int key = newR * n + newC;
                int id = idArr[key];
                int count = idSetList[id].size();
                if (count > maxCount) {
                    maxCount = count;
                    maxCountId = id;
                }
                tmpKeyArr[idx++] = key;
            }

            for (int i = 0; i < idx; i++) {
                int key = tmpKeyArr[i];
                int id = idArr[key];
                if (id != maxCountId && idSetList[id] != null) {
                    idArr[key] = maxCountId;
                    for (int tmpKey : idSetList[id]) {
                        idArr[tmpKey] = maxCountId;
                    }
                    idSetList[maxCountId].addAll(idSetList[id]);
                    idSetList[id] = null;
                    islandCount--;
                }
            }

            int key = r * n + c;

            if (maxCountId == -1) {
                // 上下左右都是0 或者边界，新生成一个岛屿
                idArr[key] = curId;
                List<Integer> keyList = new ArrayList<>();
                keyList.add(key);
                idSetList[curId] = keyList;
                islandCount++;
                curId++;
            } else {
                // 归到 firstId 的岛屿中
                idArr[key] = maxCountId;
                idSetList[maxCountId].add(key);
            }

            ansList.add(islandCount);

            grid[r][c] = 1;
        }

        return ansList;
    }

}
