package doubleContest.round64;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/30
 */
public class D {

    private List<int[]> getPos(String type, int row, int col) {
        List<int[]> posList = new ArrayList<>();
        if (type.equals("rook")) {
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    if (i == row && j == col) {
                        posList.add(new int[]{i, j});
                    } else if (i == row || j == col) {
                        posList.add(new int[]{i, j});
                    }
                }
            }
            System.out.println("车, " + posList.size());
        } else if (type.equals("queen")) {
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    if (i == row && j == col) {
                        posList.add(new int[]{i, j});
                    } else if (i == row || j == col) {
                        posList.add(new int[]{i, j});
                    } else if (j - col == i - row || j - col == row - i) {
                        posList.add(new int[]{i, j});
                    }
                }
            }
            System.out.println("后, " + posList.size());
        } else {
            // 象
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    if (i == row && j == col) {
                        posList.add(new int[]{i, j});
                    } else if (j - col == i - row || j - col == row - i) {
                        posList.add(new int[]{i, j});
                    }
                }
            }

            System.out.println("象, " + posList.size());
        }
        return posList;
    }

    public int countCombinations(String[] pieces, int[][] positions) {
        // "rook"（车） ，"queen"（后) 和 "bishop"（象) 。
//        车可以 水平或者竖直 从 (r, c) 沿着方向 (r+1, c)，(r-1, c)，(r, c+1) 或者 (r, c-1) 移动。
//        后可以 水平竖直或者斜对角 从 (r, c) 沿着方向 (r+1, c)，(r-1, c)，(r, c+1)，(r, c-1)，(r+1, c+1)，(r+1, c-1)，(r-1, c+1)，(r-1, c-1) 移动。
//        象可以 斜对角 从 (r, c) 沿着方向 (r+1, c+1)，(r+1, c-1)，(r-1, c+1)，(r-1, c-1) 移动。
        // 8 * 8 棋盘

        int len = pieces.length;
        List<int[]>[] posListArr = new ArrayList[len];
        int ans = 1;
        for (int i = 0; i < len; i++) {
            String type = pieces[i];
            int[] pos = positions[i];
            posListArr[i] = getPos(type, pos[0], pos[1]);
            ans *= posListArr[i].size();
        }
        
        System.out.println(ans);
        System.out.println();

        boolean[][] globalDisable = new boolean[9][9];

        for (int i = 0; i < len; i++) {
            String type = pieces[i];
            int[] curPos = positions[i];
            Set<int[]> set = new HashSet<>();
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }
                set.addAll(posListArr[j]);
            }

            List<int[]> curPosList = posListArr[i];
            boolean[][] disable = new boolean[9][9];

            for (int[] pos : set) {
                int x = pos[0];
                int y = pos[1];
                if (type.equals("rook")) {
                    if (x == curPos[0]) {
                        if (y == curPos[1]) {
                            disable[x][y] = true;
                        } else if (y > curPos[1]) {
                            for (int j = y; j <= 8; j++) {
                                disable[x][j] = true;
                            }
                        } else {
                            for (int j = 1; j <= y; j++) {
                                disable[x][j] = true;
                            }
                        }
                    } else if (y == curPos[1]) {
                        if (x > curPos[0]) {
                            for (int ii = x; ii <= 8; ii++) {
                                disable[ii][y] = true;
                            }
                        } else {
                            for (int ii = 1; ii <= x; ii++) {
                                disable[ii][y] = true;
                            }
                        }
                    }
                } else if (type.equals("queue")) {
                    // 水平垂直
                    if (x == curPos[0]) {
                        if (y == curPos[1]) {
                            disable[x][y] = true;
                        } else if (y > curPos[1]) {
                            for (int j = y; j <= 8; j++) {
                                disable[x][j] = true;
                            }
                        } else {
                            for (int j = 1; j <= y; j++) {
                                disable[x][j] = true;
                            }
                        }
                    } else if (y == curPos[1]) {
                        if (x > curPos[0]) {
                            for (int ii = x; ii <= 8; ii++) {
                                disable[ii][y] = true;
                            }
                        } else {
                            for (int ii = 1; ii <= x; ii++) {
                                disable[ii][y] = true;
                            }
                        }
                    }
                    //斜
                    if (x - curPos[0] == y - curPos[1]) {
                        if (x == curPos[0]) {
                            disable[x][y] = true;
                        } else if (x > curPos[0]) {
                            for (int offset = 0; offset + x <= 8 && offset + y <= 8; offset++) {
                                disable[offset + x][offset + y] = true;
                            }
                        } else {
                            for (int offset = 0; x - offset >= 1 && y - offset >= 1; offset++) {
                                disable[x - offset][y - offset] = true;
                            }
                        }
                    } else if (x - curPos[0] == curPos[1] - y) {
                        if (x > curPos[0]) {
                            // 右上角，x变大，y变小
                            for (int offset = 0; offset + x <= 8 && y - offset >= 1; offset++) {
                                disable[offset + x][y - offset] = true;
                            }
                        } else  {
                            // 左下角，x变小，y变大
                            for (int offset = 0; x - offset >= 1 && offset + y <= 8; offset++) {
                                disable[x - offset][y + offset] = true;
                            }
                        }
                    }
                } else {
                    // 象
                    //斜
                    if (x - curPos[0] == y - curPos[1]) {
                        if (x == curPos[0]) {
                            disable[x][y] = true;
                        } else if (x > curPos[0]) {
                            for (int offset = 0; offset + x <= 8 && offset + y <= 8; offset++) {
                                disable[offset + x][offset + y] = true;
                            }
                        } else {
                            for (int offset = 0; x - offset >= 1 && y - offset >= 1; offset++) {
                                disable[x - offset][y - offset] = true;
                            }
                        }
                    } else if (x - curPos[0] == curPos[1] - y) {
                        if (x > curPos[0]) {
                            // 右上角，x变大，y变小
                            for (int offset = 0; offset + x <= 8 && y - offset >= 1; offset++) {
                                disable[offset + x][y - offset] = true;
                            }
                        } else  {
                            // 左下角，x变小，y变大
                            for (int offset = 0; x - offset >= 1 && offset + y <= 8; offset++) {
                                disable[x - offset][y + offset] = true;
                            }
                        }
                    }
                }

                for (int ii = 1; ii <= 8; ii++) {
                    for (int jj = 1; jj <= 8; jj++) {
                        globalDisable[ii][jj] = disable[ii][jj];
                    }
                }
            }
        }

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (globalDisable[i][j]) {
                    ans--;
                }
            }
        }

        return ans;
    }

}
