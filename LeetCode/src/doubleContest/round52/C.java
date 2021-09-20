package doubleContest.round52;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/15
 */
public class C {

    public char[][] rotateTheBox(char[][] box) {
//        '#' 表示石头
//        '*' 表示固定的障碍物
//        '.' 表示空位置

        int m = box.length;
        int n = box[0].length;
        char[][] box1 = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box1[i][j] = box[j][i];
            }
        }



        for (int j = 0; j < m; j++) {
            int nextIdx = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (box1[i][j] == '#') {
                    if (nextIdx != i) {
                        box1[nextIdx][j] = '#';
                        box1[i][j] = '.';
                        nextIdx = nextIdx - 1;
                    } else {
                        nextIdx = i - 1;
                    }
                } else if (box1[i][j] == '*') {
                    nextIdx = i - 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = m - 1;
            while (l < r) {
                char t = box1[i][l];
                box1[i][l] = box1[i][r];
                box1[i][r] = t;
                l++;
                r--;
            }
        }

        return box1;
    }

}
