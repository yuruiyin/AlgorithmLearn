package problem301_400;

import java.util.*;

public class P305_1 {

    /**
     * 优化1：使用ArrayList 替代 HashSet
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ansList = new ArrayList<>();
        int[][] grid = new int[m][n];
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        // <key, id>
        Map<Integer, Integer> idMap = new HashMap<>();
        int curId = 1;

        // <id, key list>
        Map<Integer, List<Integer>> idSetMap = new HashMap<>();

        for (int[] pos : positions) {
            int r = pos[0];
            int c = pos[1];
            if (grid[r][c] == 1) {
                ansList.add(idSetMap.keySet().size());
                continue;
            }
            int firstId = -1;
            for (int i = 0; i < 4; i++) {
                int newR = r + dx[i];
                int newC = c + dy[i];
                if (newR < 0 || newR >= m || newC < 0 || newC >= n || grid[newR][newC] == 0) {
                    continue;
                }

                int key = newR * 10000 + newC;
                int id = idMap.get(key);
                if (firstId == -1) {
                    firstId = id;
                } else {
                    idMap.put(key, firstId);
                }
                if (id != firstId) {
                    for (int tmpKey : idSetMap.get(id)) {
                        idMap.put(tmpKey, firstId);
                        idSetMap.get(firstId).add(tmpKey);
                    }
                    idSetMap.remove(id);
                }

            }

            int key = r * 10000 + c;

            if (firstId == -1) {
                // 上下左右都是0 或者边界，新生成一个岛屿
                idMap.put(key, curId);
                idSetMap.put(curId, new ArrayList<>(Collections.singleton(key)));
                curId++;
            } else {
                // 归到 firstId 的岛屿中
                idMap.put(key, firstId);
                idSetMap.get(firstId).add(key);
            }

            ansList.add(idSetMap.keySet().size());

            grid[r][c] = 1;
        }

        return ansList;
    }

}
