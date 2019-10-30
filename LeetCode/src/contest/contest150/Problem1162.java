package contest.contest150;

import java.util.ArrayList;
import java.util.List;

public class Problem1162 {

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxDistance(int[][] grid) {
        // 先计算每个海洋距离所有路径距离之和，取和最大的那个海洋
        // 然后从这个海洋开始BFS，找到第一个陆地1即可

        int rowCount = grid.length;
        int colCount = grid[0].length;

        List<Point> oneIndexList = new ArrayList<>();
        List<Point> zeroIndexList = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1) {
                    oneIndexList.add(new Point(i, j));
                } else {
                    zeroIndexList.add(new Point(i, j));
                }
            }
        }

        int ans = -1;
        for (Point zeroPoint: zeroIndexList) {
            int minDistance = Integer.MAX_VALUE;
            for (Point onePoint: oneIndexList) {
                int distance = Math.abs(zeroPoint.x - onePoint.x) + Math.abs(zeroPoint.y - onePoint.y);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }

            if (minDistance > ans) {
                ans = minDistance;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1162().maxDistance(new int[][]{
                {1,0,1},{0,0,0},{1,0,1}
        }));
    }
}
