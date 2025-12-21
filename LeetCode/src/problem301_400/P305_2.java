package problem301_400;

import java.util.*;

public class P305_2 {

    /**
     * 优化2：使用 List<Integer>[] 替换 map
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

            int firstId = -1;
            for (int i = 0; i < 4; i++) {
                int newR = r + dx[i];
                int newC = c + dy[i];
                if (newR < 0 || newR >= m || newC < 0 || newC >= n || grid[newR][newC] == 0) {
                    continue;
                }

                int key = newR * n + newC;
                int id = idArr[key];
                if (firstId == -1) {
                    firstId = id;
                } else if (id != firstId) {
                    idArr[key] = firstId;
                    for (int tmpKey : idSetList[id]) {
                        idArr[tmpKey] = firstId;
                    }
                    idSetList[firstId].addAll(idSetList[id]);
                    idSetList[id] = null;
                    islandCount--;
                }

            }

            int key = r * n + c;

            if (firstId == -1) {
                // 上下左右都是0 或者边界，新生成一个岛屿
                idArr[key] = curId;
                List<Integer> keyList = new ArrayList<>();
                keyList.add(key);
                idSetList[curId] = keyList;
                islandCount++;
                curId++;
            } else {
                // 归到 firstId 的岛屿中
                idArr[key] = firstId;
                idSetList[firstId].add(key);
            }

            ansList.add(islandCount);

            grid[r][c] = 1;
        }

        return ansList;
    }

}
