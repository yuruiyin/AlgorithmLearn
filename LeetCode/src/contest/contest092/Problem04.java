package contest.contest092;

import java.util.HashSet;
import java.util.Set;

public class Problem04 {

    private int keyCount = 0;
    private char[][] gridArr;
    private int rowCount;
    private int colCount;
    private int ansMin = Integer.MAX_VALUE;
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private char[] map;

    private boolean isLock(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private void dfs(int row, int col, Set<Character> keySet, boolean[][] visited, int level) {
        if (level > ansMin) {
            return;
        }

        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount ||
                    gridArr[nextRow][nextCol] == '#' || visited[nextRow][nextCol]) {
                continue;
            }

            char c = gridArr[nextRow][nextCol];

            if (isLock(c) && !keySet.contains(map[c])) {
                continue;
            }

//            ["@Aa"]
            if (isKey(c)) {
                keySet.add(c);
            }

            if (keySet.size() == keyCount) {
                ansMin = Math.min(ansMin, level + 1);
            }

            dfs(nextRow, nextCol, keySet, visited,level + 1);

            if (isKey(c)) {
                keySet.remove(c);
            }
        }

        visited[row][col] = false;
    }

    private boolean isKey(char c) {
        return c >= 'a' && c <= 'f';
    }

    public int shortestPathAllKeys(String[] grid) {
        rowCount = grid.length;
        colCount = grid[0].length();
        gridArr = new char[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            gridArr[i] = grid[i].toCharArray();
        }

        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (isKey(gridArr[i][j])) {
                    keyCount++;
                }

                if (gridArr[i][j] == '@') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        map = new char['Z' + 1];
        map['A'] = 'a';
        map['B'] = 'b';
        map['C'] = 'c';
        map['D'] = 'd';
        map['E'] = 'e';
        map['F'] = 'f';

        dfs(startRow, startCol, new HashSet<>(), new boolean[rowCount][colCount], 0);

        return ansMin == Integer.MAX_VALUE ? -1 : ansMin;
    }

}
