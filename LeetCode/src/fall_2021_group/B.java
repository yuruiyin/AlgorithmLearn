package fall_2021_group;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/25
 */
public class B {

    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    class Data {
        int h;
        int o;

        Data(int h, int o) {
            this.h = h;
            this.o = o;
        }
    }

    private Boolean[][][] memo;
    private int m;
    private int n;
    private Data[][] datas;

    private void dfs(int x, int y, int speed, boolean[][][] visited) {
        if (speed <= 0) {
            return;
        }

        if (visited[x][y][speed]) {
            return;
        }

        visited[x][y][speed] = true;

        if (speed == 1) {
            memo[x][y][speed] = true;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                continue;
            }
            int nextSpeed = speed + datas[x][y].h - datas[nextX][nextY].h - datas[nextX][nextY].o;
            if (nextSpeed <= 0) {
                continue;
            }
            dfs(nextX, nextY, nextSpeed, visited);
        }
    }

    public int[][] bicycleYard(int[] position, int[][] hArr, int[][] oArr) {
        List<int[]> ansArrList = new ArrayList<>();
        m = hArr.length;
        n = hArr[0].length;
        datas = new Data[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                datas[i][j] = new Data(hArr[i][j], oArr[i][j]);
            }
        }

        memo = new Boolean[m][n][102];
        int sx = position[0];
        int sy = position[1];
        dfs(sx, sy, 1, new boolean[m][n][102]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (memo[i][j][1] != null && memo[i][j][1] && !(sx == i && sy == j)) {
                    ansArrList.add(new int[]{i, j});
                }
            }
        }

        Collections.sort(ansArrList, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int size = ansArrList.size();
        int[][] ansArr = new int[size][2];
        for (int i = 0; i < size; i++) {
            ansArr[i] = ansArrList.get(i);
        }
        return ansArr;
    }

//    private static int[][] createArr() {
//        Random random = new Random();
//        int[][] arr = new int[100][100];
//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < 100; j++) {
//                arr[i][j] = random.nextInt(101);
//            }
//        }
//        return arr;
//    }

    private static int[][] createArr() {
        Random random = new Random();
        int[][] arr = new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                arr[i][j] = random.nextInt(101);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[][] hArr = new int[][]{
//                {0}, {5}, {10}
//        };
//        int[][] oArr = new int[][]{
//                {4}, {3}, {0}
//        };
//        int[][] ansArr = new B().bicycleYard(new int[]{2, 0}, hArr, oArr);
//        for (int i = 0; i < ansArr.length; i++) {
//            System.out.println(ansArr[i][0] + ", " + ansArr[i][1]);
//        }

        int[][] hArr = new int[][]{
                {0, 0}, {0, 0}
        };
        int[][] oArr = new int[][]{
                {0, 0}, {0, 0}
        };
        int[][] ansArr = new B().bicycleYard(new int[]{0, 0}, hArr, oArr);
        for (int i = 0; i < ansArr.length; i++) {
            System.out.println(ansArr[i][0] + ", " + ansArr[i][1]);
        }

    }

}
