package problem801_900;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem864 {

    class Data {
        int row;
        int col;
        int cost;
        Data(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    private int dijkstra(char[][] grid, int keyCount, int row, int col) {
        int ansMin = Integer.MAX_VALUE;
        PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.cost - o2.cost;
            }
        });

        pq.add(new Data(row, col, 0));
        // todo
        return 0;
    }

    public int shortestPathAllKeys(String[] grid) {
        // grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F'
        // '.'代表空房间，'#'代表墙，'@'代表起点，小写字母代表钥匙，大写字母代表锁
        int m = grid.length;
        int n = grid[0].length();
        char[][] arr = new char[m][n];
        int keyCount = 0;
        int[] start = new int[2];
        for (int i = 0; i < m; i++) {
            arr[i] = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                if (Character.isLowerCase(arr[i][j])) {
                    keyCount++;
                } else if (arr[i][j] == '@') {
                    start = new int[]{i, j};
                }
            }
        }

        return dijkstra(arr, keyCount, start[0], start[1]);
    }

}
